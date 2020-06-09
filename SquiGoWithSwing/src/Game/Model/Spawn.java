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
             handler.addObject(new TreeEnemyS(r.nextInt(Game.WIDTH-60),Game.HEIGHT-100, ID.TreeEnemyS, handler));
         }
         if(hud.getLevel()==3){
             //handler.addObject(new DecorationEnemyTh(r.nextInt(Game.WIDTH-60), r.nextInt(Game.HEIGHT-80), ID.DecorationEnemyTh, handler));
         }
         if(hud.getLevel()==4){
             handler.addObject(new SantaEnemyFif((Game.WIDTH/2-48), -50, ID.SantaEnemyFif, handler));
         }
     }
    }
}
