package Model;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Menu extends MouseAdapter {
    private Game game;
    private Handler handler;
    private Random r=new Random();
    private int buttonWidth=Game.WIDTH/5;
    private int buttonHeigth=Game.HEIGHT/5;
    HUD hud;
    public Menu(Game game, Handler handler, HUD hud){
        this.game=game;
        this.handler=handler;
        this.hud=hud;
    }
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        int mx = e.getX();
        int my = e.getY();

        if (game.gameState == Game.STATE.Menu) {
            //play button
            if (mouseOver(mx, my, 210, 150, 300, 64)) {
//                game.gameState = Game.STATE.Game;//??
//                handler.addObject(new Player(50,  0, ID.Player, handler));
//                for(int i=0;i<5;i++)
//                handler.addObject(new SnowflakeEnemyF(r.nextInt(Game.WIDTH-60), ThreadLocalRandom.current().nextInt(50, Game.HEIGHT-100), ID.SnowflakeEnemyF, handler));
           game.gameState= Game.STATE.Select;
//click sound added
            Audio.getSound("menu_sound").play();
           return;
            }
            //help button
            if (mouseOver(mx, my, 210, 250, 200, 64)) {
//click sound added
                Audio.getSound("menu_sound").play();
                game.gameState = Game.STATE.Help;
            }
            //quit button
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
//click sound added
                Audio.getSound("menu_sound").play();
                System.exit(1);
            }
        }
        if (game.gameState == Game.STATE.Select) {
            //normal button
            if (mouseOver(mx, my, 210, 150, 300, 64)) {
                game.gameState = Game.STATE.Game;
                handler.addObject(new Player(50,  0, ID.Player, handler));
                for(int i=0;i<5;i++)
                handler.addObject(new SnowflakeEnemyF(r.nextInt(Game.WIDTH-60), ThreadLocalRandom.current().nextInt(50, Game.HEIGHT-100), ID.SnowflakeEnemyF, handler));
                game.diff=0;
//click sound and game sound added
                Audio.getSound("menu_sound").play();
                Audio.loadmusic();
                Audio.getMusic("music_game").loop();
            }
            //hard button
            if (mouseOver(mx, my, 210, 250, 200, 64)) {
                game.gameState = Game.STATE.Game;
                handler.addObject(new Player(50,  0, ID.Player, handler));
                for(int i=0;i<5;i++)
                handler.addObject(new SnowflakeEnemyFhard(r.nextInt(Game.WIDTH-60), ThreadLocalRandom.current().nextInt(50, Game.HEIGHT-100), ID.SnowflakeEnemyF, handler));
                game.diff=1;
//click sound and game sound added
                Audio.getSound("menu_sound").play();
                Audio.loadmusic();
                Audio.getMusic("music_game").loop();
            }
            //back button
            if (mouseOver(mx, my, 210, 350, 200, 64)) {

                    game.gameState = Game.STATE.Menu;
//click sound added
                    Audio.getSound("menu_sound").play();
                    return;
            }
        }


        //back button for help
        if (game.gameState == Game.STATE.Help) {
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = Game.STATE.Menu;
//click sound added
                Audio.getSound("menu_sound").play();
                return;
            }
        }

        //buttons for end
        if (game.gameState == Game.STATE.End) {
            //try again
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = Game.STATE.Select;

                hud.setLevel(1);
                hud.setScore(0);
                Spawn.scoreKeep=0;
//                handler.addObject(new Player((Game.WIDTH / 2 - 32), (Game.HEIGHT / 2 - 32), ID.Player, handler));
//                for(int i=0;i<5;i++)
//                    handler.addObject(new SnowflakeEnemyF(r.nextInt(Game.WIDTH-60), ThreadLocalRandom.current().nextInt(50, Game.HEIGHT-100), ID.SnowflakeEnemyF, handler));//1 level



            }
            //go to menu
            if (mouseOver(mx, my, 210, 250, 200, 64)) {
                game.gameState = Game.STATE.Menu
                //menu sound added
                Audio.loadmusic();
                Audio.getMusic("music_menu").loop();

                hud.setLevel(1);
                hud.setScore(0);
                Spawn.scoreKeep=0;
//                handler.addObject(new Player((Game.WIDTH / 2 - 32), (Game.HEIGHT / 2 - 32), ID.Player, handler));
//                handler.addObject(new SnowflakeEnemyF(r.nextInt(Game.WIDTH - 60), Game.HEIGHT - 100, ID.SnowflakeEnemyF, handler));//1 level

            }

        }
    }

    public void mouseReleased(MouseEvent e) {
        super.mousePressed(e);
    }
    private boolean mouseOver(int mx, int my, int x, int y,int wigth, int heigth){
        if(mx>x && mx<wigth+x){
            if(my>y && my<heigth+y){
                return  true;
            } else return false;
        }else return false;
    }

    public void tick(){

    }
    public void render (Graphics g) {
        if (game.gameState == Game.STATE.Menu) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            g.setFont(fnt);
            g.setColor(Color.WHITE);
            g.drawString("Menu", 240, 70);

            g.setFont(fnt2);
            g.drawString("Play", 270, 190);
            g.drawRect(210, 150, 200, 64);

            g.setColor(Color.WHITE);
            g.drawString("Help", 270, 290);
            g.drawRect(210, 250, 200, 64);

            g.setColor(Color.WHITE);
            g.drawString("Quit", 270, 390);
            g.drawRect(210, 350, 200, 64);


        } else if (game.gameState== Game.STATE.Help){
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            g.setFont(fnt);
            g.setColor(Color.WHITE);
            g.drawString("Help", 240, 70);

            g.setFont(fnt2);
            g.drawString("lalalalkjghdljshl indtructions", 50, 200);


            g.setFont(fnt2);
            g.drawString("Back", 270, 390);
            g.drawRect(210, 350, 200, 64);

        }else if (game.gameState== Game.STATE.End){
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            g.setFont(fnt);
            g.setColor(Color.WHITE);
            g.drawString("Game over", 185, 70);

            g.setFont(fnt2);
            g.drawString("You lost with score: "+hud.getScore()+" and level "+ hud.getLevel(), 30, 200);

            g.setFont(fnt2);
            g.drawString("Try again", 245, 390);
            g.drawRect(210, 350, 200, 64);


            g.setColor(Color.WHITE);
            g.drawString("Menu", 270, 290);
            g.drawRect(210, 250, 200, 64);
        }else if (game.gameState == Game.STATE.Select) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            g.setFont(fnt);
            g.setColor(Color.WHITE);
            g.drawString("SELECT DIFICULTY", 140, 70);

            g.setFont(fnt2);
            g.drawString("Normal", 270, 190);
            g.drawRect(210, 150, 200, 64);

            g.setColor(Color.WHITE);
            g.drawString("Hard", 270, 290);
            g.drawRect(210, 250, 200, 64);

            g.setColor(Color.WHITE);
            g.drawString("Back", 270, 390);
            g.drawRect(210, 350, 200, 64);


        }
    }
}
