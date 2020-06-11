package Model;

import java.awt.*;

public class HUD {
    public static float HEALTH = 100;
    private float greenValue = 200;
    private float score=0;
    private float level=1;
  public static   int nuts=0;

    public void tick() {
        HEALTH = Game.clam(HEALTH, 0, 100);
        greenValue = Game.clam(greenValue, 0, 255);
        greenValue = HEALTH * 2;
        score++;
    }

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(new Color(100, (int)greenValue, 0));
        g.fillRect(15, 15, (int)HEALTH * 2, 32);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 32);
        g.drawString("Health: "+ HEALTH,220,35);
        g.drawString("Level: "+ level,320,35);
        g.drawString("Scores: "+ score ,420,35);
        g.drawString("Nuts: "+ nuts ,520,35);

    }

    public  float getLevel(){
        return  level;
    }
    public void setLevel(float level){
        this.level=level;
    }
    public void setScore(float score){
        this.score=score;
    }
    public float getScore(){
        return score;
    }
}
