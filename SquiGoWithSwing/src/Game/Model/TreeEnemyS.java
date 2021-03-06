package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TreeEnemyS extends GameObject {

    private Handler handler;
    private Random random = new Random();
    private int timer = 500;
    private int dec;

    public TreeEnemyS(float x, float y, ID id, Handler handler, int dec) {
        super(x, y, id);
        this.dec = dec;
        this.handler = handler;
        velX = 5;
        velY = 5;
    }

    public Rectangle getBounds() {
        if (dec == 0)
            return new Rectangle((int) x, (int) y, 30, 56);
        if (dec == 1)
            return new Rectangle((int) x, (int) y, 28, 57);
        if (dec == 2)
            return new Rectangle((int) x, (int) y, 30, 40);
        if (dec == 3)
            return new Rectangle((int) x, (int) y, 30, 36);
        if (dec == 4)
            return new Rectangle((int) x, (int) y, 29, 34);
        return new Rectangle((int) x, (int) y, 0, 0);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        if (x <= 0 || x >= Game.WIDTH - 32) {
            velX *= -1;
        }
        if (y <= 50 || y >= Game.HEIGHT - 85) {
            velY *= -1;
        }
        if (timer <= 0) {
            if (!SnowflakeEnemyF.isA) {
                handler.addObject(new Nut(random.nextInt(Game.WIDTH - 60), ThreadLocalRandom.current().nextInt(50, Game.HEIGHT - 100), ID.Nut, handler));
                SnowflakeEnemyF.isA = true;
            } else
                timer = 500;
        } else {
            timer--;
        }
        handler.addObject(new BasicTrail(x, y, ID.BasicTrail, Color.green, 9, 9, 0.1f, handler));
    }

    @Override
    public void render(Graphics g) {
        BufferedImage image = new BufferedImage(9, 9, 12);
        BufferedImage imag = new BufferedImage(9, 9, 12);
        BufferedImage ima = new BufferedImage(9, 9, 12);
        BufferedImage im = new BufferedImage(9, 9, 12);
        BufferedImage i = new BufferedImage(9, 9, 12);

        try {

            image = ImageIO.read(getClass().getResource("/resources/chtree/treeG.png"));
            imag = ImageIO.read(getClass().getResource("/resources/chtree/treeW.png"));
            ima = ImageIO.read(getClass().getResource("/resources/chtree/chrtree1.png"));
            im = ImageIO.read(getClass().getResource("/resources/chtree/chrtree2.png"));
            i = ImageIO.read(getClass().getResource("/resources/chtree/chrtree3.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (dec == 0)
            g.drawImage(image, (int) x, (int) y, null);
        if (dec == 1)
            g.drawImage(imag, (int) x, (int) y, null);
        if (dec == 2)
            g.drawImage(ima, (int) x, (int) y, null);
        if (dec == 3)
            g.drawImage(im, (int) x, (int) y, null);
        if (dec == 4)
            g.drawImage(i, (int) x, (int) y, null);
    }
}
