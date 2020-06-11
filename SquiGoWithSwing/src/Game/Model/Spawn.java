package Model;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Spawn {
    private  Handler handler;
    private  HUD hud;
    public static int scoreKeep=0;
    private Random r=new Random();
    private Game game;
    public Spawn(Handler handler,HUD hud, Game game){
        this.handler=handler;
        this.hud=hud;
        this.game=game;
    }
    public void tick(){
     scoreKeep++;

     if(scoreKeep>=1000){
         scoreKeep=0;
         hud.setLevel(hud.getLevel()+1);
         if (game.diff==0) {
             SantaEnemyFif sa = new SantaEnemyFif((Game.WIDTH / 2 - 48), -50, ID.SantaEnemyFif, handler);
             if (hud.getLevel() == 2) {
                 SnowflakeEnemyF.isA=false;
                 handler.clearEnemies();
                 for (int i = 0; i < 6; i++)
                     handler.addObject(new TreeEnemyS(r.nextInt(Game.WIDTH - 60), ThreadLocalRandom.current().nextInt(50, Game.HEIGHT - 100), ID.TreeEnemyS, handler, ThreadLocalRandom.current().nextInt(0, 5)));
             }
             if (hud.getLevel() == 3) {
                 SnowflakeEnemyF.isA=false;
                 handler.clearEnemies();
                 for (int i = 0; i < 10; i++)
                     handler.addObject(new DecorationEnemyTh(r.nextInt(Game.WIDTH - 60), ThreadLocalRandom.current().nextInt(50, Game.HEIGHT - 100), ID.DecorationEnemyTh, handler, ThreadLocalRandom.current().nextInt(0, 7)));
             }
             if (hud.getLevel() == 4) {
                 SnowflakeEnemyF.isA=false;
                 handler.clearEnemies();
                 handler.addObject(new ReindeerEnemyFo((Game.WIDTH - 150), (Game.HEIGHT - 300), ID.ReindeerEnemyFo, handler, 1));
                 handler.addObject(new ReindeerEnemyFo((0), (Game.HEIGHT - 150), ID.ReindeerEnemyFo, handler, 2));
             }
             if (hud.getLevel() == 5) {
                 SnowflakeEnemyF.isA=false;
                 handler.clearEnemies();
                 handler.addObject(sa);
             }
             if (hud.getLevel() == 6) {
             }
         }else if (game.diff==1) {

             SantaEnemyFif sa = new SantaEnemyFif((Game.WIDTH / 2 - 48), -50, ID.SantaEnemyFif, handler);
             if (hud.getLevel() == 2) {
                 handler.clearEnemies();
                 for (int i = 0; i < 10; i++)
                     handler.addObject(new TreeEnemyS(r.nextInt(Game.WIDTH - 60), ThreadLocalRandom.current().nextInt(50, Game.HEIGHT - 100), ID.TreeEnemyS, handler, ThreadLocalRandom.current().nextInt(0, 5)));
             }
             if (hud.getLevel() == 3) {
                 handler.clearEnemies();
                 for (int i = 0; i < 10; i++)
                     handler.addObject(new DecorationEnemyTh(r.nextInt(Game.WIDTH - 60), ThreadLocalRandom.current().nextInt(50, Game.HEIGHT - 100), ID.DecorationEnemyTh, handler, ThreadLocalRandom.current().nextInt(0, 7)));
             }
             if (hud.getLevel() == 4) {
                 handler.clearEnemies();
                 handler.addObject(new ReindeerEnemyFo((Game.WIDTH - 150), (Game.HEIGHT - 300), ID.ReindeerEnemyFo, handler, 1));
                 handler.addObject(new ReindeerEnemyFo((0), (Game.HEIGHT - 150), ID.ReindeerEnemyFo, handler, 2));
             }
             if (hud.getLevel() == 5) {
                 handler.clearEnemies();
                 handler.addObject(sa);
             }
             if (hud.getLevel() == 6) {
             }
     }}
    }
}
