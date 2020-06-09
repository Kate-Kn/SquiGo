package Model;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {
    protected static final int WIDTH = 640;
    protected static final int HEIGHT = WIDTH / 12 * 9;
    private HUD hud;
    private Thread thread;
    private boolean running = true;
    private Handler handler;
    private Random r;
    private Spawn spawn;
    private Menu menu;
    public enum STATE {
        Menu,
        Help,
        Game
    };
    public STATE gameState= STATE.Menu;
    public Game() {
        handler = new Handler();
        menu= new Menu(this, handler);
        this.addMouseListener(menu);
        hud = new HUD();
        spawn = new Spawn(handler,hud);
        this.addKeyListener(new KeyInput(handler));
        new Window(WIDTH, HEIGHT, "SquiGo", this);

        r = new Random();
        if(gameState==STATE.Game){
            handler.addObject(new Player((WIDTH / 2 - 32), (HEIGHT / 2 - 32), ID.Player, handler));
            //if everything is on time, may add multiplayer
            // handler.addObject(new Player((WIGHT/2+64), (HEIGHT /2+64), ID.Player2));
//
//    //for many enemies
//    for(int i=0;i<20;i++) {
//            handler.addObject(new BasicEnemy(r.nextInt(WIDTH ),r.nextInt (HEIGHT ), ID.BasicEnemy, handler));
//        }
            handler.addObject(new BasicEnemy(r.nextInt(WIDTH-60), r.nextInt(HEIGHT-30), ID.BasicEnemy, handler));
//
        }


    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTricks = 60;
        double ns = 1000000000 / amountOfTricks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                // System.out.println("FPS:  " + frames);
                frames = 0;

            }
        }
        stop();
    }

    private void tick() {
        //hud = new HUD();
        //spawn=new Spawn(handler,hud);
        handler.tick();
        if(gameState==STATE.Game){
        hud.tick();
        spawn.tick();
        } else if (gameState==STATE.Menu){
            menu.tick();
        }



    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        if(gameState==STATE.Game){
            hud.render(g);
        }else if (gameState==STATE.Menu||gameState==STATE.Help){
            menu.render(g);
        }


        g.dispose();
        bs.show();
    }

    public static float clam(float var, float min,float max) {
        if (var >= max) {
            return var = max;
        } else if (var <= min) {
            return var = min;
        }
        return var;
    }

    public static void main(String args[]) {
        new Game();
    }
}
