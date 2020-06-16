package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Game extends Canvas implements Runnable {
    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH / 12 * 9;
    private HUD hud;
    private Thread thread;
    private boolean running = true;
    public static boolean paused = false;
    private Handler handler;
    private Random r;
    private Spawn spawn;
    public int diff = 0;
    private Shop shop;
    private Menu menu;

    public enum STATE {
        Menu,
        Help,
        Game,
        Select,
        End,
        Shop,
        Finish
    }

    ;
    public static STATE gameState = STATE.Menu;

    public Game() {
        hud = new HUD();
        handler = new Handler();
        menu = new Menu(this, handler, hud);
       shop = new Shop(handler, hud);
        this.addMouseListener(menu);
        this.addMouseListener(shop);

        spawn = new Spawn(handler, hud, this);
        this.addKeyListener(new KeyInput(handler, this));
        new Window(WIDTH, HEIGHT, "SquiGo", this);
//music added for menu
        Audio.loadmusic();
        Audio.getMusic("music_menu").loop();
        r = new Random();



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
        if (gameState == STATE.Game) {

            if (!(paused)) {
                handler.tick();
                hud.tick();
                spawn.tick();

                if (HUD.HEALTH <= 0) {
                    HUD.HEALTH = 100;
                    gameState = STATE.End;
                    handler.clearEnemies();

                }
            }
        } else if (gameState == STATE.Menu || gameState == STATE.End
                || gameState == STATE.Select|| gameState == STATE.Finish||gameState == STATE.Shop) {
            menu.tick();
            handler.tick();
        }
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(new Color(213, 236, 235));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        if (paused) {
            if (gameState != STATE.Shop) {
              Font fnt = new Font("arial", 1, 30);
            g.setFont(fnt);
            g.setColor(new Color(218,68,121));
            g.drawString("PAUSED", 270, 245);
            BufferedImage imagem = new BufferedImage(10, 10, 12);
            try {
             imagem = ImageIO.read(getClass().getResource("/resources/backs/helpframe3.png"));
            } catch (Exception e) {
             e.printStackTrace();
            }
            g.drawImage(imagem, 230, 200, 200, 64, null);

            }
        }
        if (gameState == STATE.Game) {
            hud.render(g);
            handler.render(g);
        }
        else if (gameState == STATE.Shop) {
            shop.render(g);
       }
        else if (gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Select||
                gameState == STATE.Finish) {
            menu.render(g);
            handler.render(g);
        }

        g.dispose();
        bs.show();
    }

    public static float clam(float var, float min, float max) {
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
