package Model;

import java.awt.*;

public class BasicTrail extends GameObject {

    private float alpha = 1;
    private Handler handler;
    private Color color;
    private int width, height;
    float life; //life = 0.001-0.1


    public BasicTrail(float x, float y, ID id, Color color, int width, int height, float life, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        this.color = color;
        this.width = width;
        this.height = height;
        this.life = life;
    }

    @Override
    public void tick() {
        if (alpha > life) {
            alpha -= life - 0.001f;
        } else {
            handler.removeObject(this);
        }
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        g.setColor(color);
        g.fillRect((int) x, (int) y, width, height);
        g2d.setComposite(makeTransparent(1));

    }

    private AlphaComposite makeTransparent(float alfa) {
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type, alfa));
    }

    @Override

    public Rectangle getBounds() {
        return null;
    }
}
