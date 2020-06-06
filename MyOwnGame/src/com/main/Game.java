package com.main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    private static final int WIGHT = 640;
    private static final int HEIGTH = WIGHT/12*9;
    private Thread thread;
    private boolean running =true;
    private Handler handler;
    private Random r;
    public Game (){
        handler=new Handler();
        new Window(WIGHT, HEIGTH, "MY GAME", this);

        r=new Random();
        for(int i=0; i<20; i++) {
            handler.addObject(new Player(r.nextInt(WIGHT/2-32), r.nextInt(HEIGTH/2-32), ID.Player));
        }
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
                System.out.println("FPS:  " + frames);
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
