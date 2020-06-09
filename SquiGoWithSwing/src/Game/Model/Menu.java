package Model;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {
    private Game game;
    private Handler handler;
    private Random r=new Random();
    public Menu(Game game, Handler handler){
        this.game=game;
        this.handler=handler;
    }
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        int mx = e.getX();
        int my = e.getY();

        if (game.gameState == Game.STATE.Menu) {
            //play button
            if (mouseOver(mx, my, 210, 150, 300, 64)) {
                game.gameState = Game.STATE.Game;//??
                handler.addObject(new Player((Game.WIDTH / 2 - 32), (Game.HEIGHT / 2 - 32), ID.Player, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 60), r.nextInt(Game.HEIGHT - 30), ID.BasicEnemy, handler));
            }
            //help button
            if (mouseOver(mx, my, 210, 250, 200, 64)) {
                game.gameState = Game.STATE.Help;
            }
            //quit button
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                System.exit(1);
            }
        }


        //back button for help
        if (game.gameState == Game.STATE.Help) {
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = Game.STATE.Menu;
                return;
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

        }
    }
}
