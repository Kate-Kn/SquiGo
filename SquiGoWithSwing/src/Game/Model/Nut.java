
package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Nut extends GameObject {
    private Handler handler;

    public Nut(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 3;
        velY = 2;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 30, 43);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        if (y > Game.HEIGHT) {
            handler.removeObject(this);
            SnowflakeEnemyF.isA = false;
        }
        handler.addObject(new BasicTrail(x, y, ID.BasicTrail, Color.orange, 4, 4, 0.1f, handler));

    }

    @Override
    public void render(Graphics g) {

        BufferedImage image = new BufferedImage(9, 9, 12);
        try {

            image = ImageIO.read(getClass().getResource("/resources/nut.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        g.drawImage(image, (int) x, (int) y, null);
    }
}
