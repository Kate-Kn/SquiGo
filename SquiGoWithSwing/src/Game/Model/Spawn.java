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

     if(scoreKeep>=500){
         scoreKeep=0;
         hud.setLevel(hud.getLevel()+1);
         TreeEnemyS tr=new TreeEnemyS(r.nextInt(Game.WIDTH-
                 60),Game.HEIGHT-100, ID.TreeEnemyS, handler);
         SantaEnemyFif sa=new SantaEnemyFif((Game.WIDTH/2-48), -50, ID.SantaEnemyFif, handler);
         if(hud.getLevel()==2){
             handler.addObject(tr);
         }
         if(hud.getLevel()==3){
             handler.clearEnemies();
             for(int i=0;i<10;i++)
             handler.addObject(new DecorationEnemyTh(r.nextInt(Game.WIDTH-60), r.nextInt(Game.HEIGHT-80), ID.DecorationEnemyTh, handler));
         }
         if(hud.getLevel()==4){
             handler.clearEnemies();
             handler.addObject(new ReindeerEnemyFo((Game.WIDTH-150), (Game.HEIGHT-300), ID.ReindeerEnemyFo, handler,1));
             handler.addObject(new ReindeerEnemyFo((0), (Game.HEIGHT-150), ID.ReindeerEnemyFo, handler,2));
         }
         if(hud.getLevel()==5){
             handler.clearEnemies();
             handler.addObject(sa);
         }
         if(hud.getLevel()==6) {
         }
     }
    }
}
