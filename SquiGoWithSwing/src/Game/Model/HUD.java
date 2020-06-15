package Model;

import java.awt.*;

public class HUD {
    public static float HEALTH = 100;
    private float greenValue = 200;
    private float score = 0;
    private float level = 1;
    public static float nuts = 0;

    public void tick() {
        HEALTH = Game.clam(HEALTH, 0, 100);
        nuts=Game.clam(nuts,0,10000000);
        greenValue = HEALTH * 2;
        greenValue = Game.clam(greenValue, 0, 255);
        score++;
    }

    public void render(Graphics g) {
        g.setColor(new Color(97,165, 177));
        g.fillRect(0,0,640,50);
        g.setColor(new Color(234,248, 249));
        g.fillRect(15, 10, 200, 32);
        g.setColor(new Color(100, (int) greenValue, 0));
        g.fillRect(15, 10, (int) HEALTH * 2, 32);
        g.setColor(new Color(29,139, 145));
        g.drawRect(15, 10, 200, 32);

        //level space
                g.setColor(new Color(193,219, 217));
                g.fillRect(313, 0, 116, 50);
        //score space
                g.setColor(new Color(226,243, 243));
                g.fillRect(396, 0, 124, 50);
        //nut space
                g.setColor(new Color(234,248, 249));
                g.fillRect(520, 0, 120, 50);
                BufferedImage image = new BufferedImage(7, 7, 12);
                try {
                    image = ImageIO.read(getClass().getResource("/resources/nut.png"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                g.drawImage(image, 525, 5, null);

        g.setColor(new Color(230,249, 250));
        Font fnt2 = new Font("arial", 1, 15);
        g.setFont(fnt2 );
        g.drawString("Health: " + HEALTH, 220, 35);
        g.setColor(new Color(97,165, 177));
        g.drawString("Level: " + level, 320, 35);
        g.drawString("Scores: " + score, 420, 35);
        g.setColor(new Color(181,97, 57));
        g.drawString("Nuts: " + nuts, 520, 35);
        g.setColor(Color.orange);
        g.drawString("Space for pause, esc for escape, s for shop", 220, 15);

    }

    public float getLevel() {
        return level;
    }

    public void setLevel(float level) {
        this.level = level;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public float getScore() {
        return score;
    }

    public float getNuts() {
        return nuts;
    }

    public void setNuts(float nuts) {
        this.nuts = nuts;
    }
}
