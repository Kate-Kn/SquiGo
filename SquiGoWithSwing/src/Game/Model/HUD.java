package Model;

import java.awt.*;

public class HUD {

    public static  int HEALTH=100;
    private int greenValue=200;

    public void tick(){
    HEALTH=Game.clam(HEALTH,0,100);
    greenValue=Game.clam(greenValue,0,255);
    greenValue=HEALTH*2;

    }
    public void render(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(15,15,200,32);
        g.setColor(new Color(100,greenValue,0));
        g.fillRect(15,15,HEALTH*2,32);
        g.setColor(Color.white);
        g.drawRect(15,15,200,32);
    }
}
