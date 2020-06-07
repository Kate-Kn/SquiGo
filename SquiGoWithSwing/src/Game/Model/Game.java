package Model;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {
    protected    static final int WIDTH = 640;
    protected  static final int HEIGHT = WIDTH /12*9;

    private Thread thread;
    private boolean running =true;
    private Handler handler;
    private Random r;
    public Game(){
        handler=new Handler();
        this.addKeyListener(new KeyInput(handler));
        new Window(WIDTH, HEIGHT, "SquiGo", this);

        r=new Random();
        handler.addObject(new Player((WIDTH /2-32), (HEIGHT /2-32), ID.Player));
        //if everything is on time, may add multiplayer
       // handler.addObject(new Player((WIGHT/2+64), (HEIGHT /2+64), ID.Player2));
        handler.addObject(new BasicEnemy((WIDTH /2+64), (HEIGHT /2+64), ID.BasicEnemy));
    }
    public  synchronized void start(){
        thread= new Thread(this);
        thread.start();
        running= true;
    }
    public  synchronized void stop(){
        try{
            thread.join();
            running= false;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void run(){
        long lastTime=System.nanoTime();
        double amountOfTricks = 60;
        double ns= 1000000000/amountOfTricks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta+=(now-lastTime)/ns;
            lastTime=now;
            while(delta>=1){
                tick();
                delta--;
            }
            if (running){
                render();
            }
            frames++;
            if (System.currentTimeMillis()-timer> 1000) {
                timer += 1000;
               // System.out.println("FPS:  " + frames);
                frames = 0;

            }
        }

        stop();
    }

    private void tick(){
        handler.tick();
    }
    private void render(){
        BufferStrategy bs= this.getBufferStrategy();
        if(bs==null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g=bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0,0,getWidth(),getHeight());
        handler.render(g);
        g.dispose();
        bs.show();
    }
    public static void main (String args[]){
        new Game();
    }
}
