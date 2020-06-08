package Model;

import java.util.Random;

public class Spawn {
    private  Handler handler;
    private  HUD hud;
    private int scoreKeep=0;
    private Random r=new Random();
    public Spawn(Handler handler,HUD hud){
        this.handler=handler;
        this.hud=hud;
    }
    public void tick(){
     scoreKeep++;
     if(scoreKeep>=100){
         scoreKeep=0;
         hud.setLevel(hud.getLevel()+1);
         if(hud.getLevel()==2){
             handler.addObject(new FastSnowflake(r.nextInt(Game.WIDTH-60), r.nextInt(Game.HEIGHT-80), ID.FastSnowflake, handler));
         }
     }
    }
}
