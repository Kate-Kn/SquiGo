package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SnowflakeEnemyF extends GameObject {
    private Handler handler;
    private int dec = ThreadLocalRandom.current().nextInt(0, 4);
    private int timer = 250;
    private Random r = new Random();
    public static boolean isA = false;

    public SnowflakeEnemyF(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 5;
        velY = 2;
    }

    public Rectangle getBounds() {

        return new Rectangle((int) x, (int) y, 50, 50);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        if (timer <= 0) {
            if (!isA) {
                handler.addObject(new Nut(r.nextInt(Game.WIDTH - 60), ThreadLocalRandom.current().nextInt(50, Game.HEIGHT - 100), ID.Nut, handler));
                isA = true;
            } else
                timer = 200;
        } else {
            timer--;
        }
        y = Game.clam(y, 50, Game.HEIGHT - 82);
        if (x <= 0 || x >= Game.WIDTH - 32) {
            velX *= -1;
        }
        if (y <= 50 || y >= Game.HEIGHT - 85) {
            velY *= -1;
        }

        handler.addObject(new BasicTrail(x, y, ID.BasicTrail, Color.white, 4, 4, 0.1f, handler));
    }

    @Override
    public void render(Graphics g) {


        BufferedImage image = new BufferedImage(9, 9, 12);
        BufferedImage imag = new BufferedImage(9, 9, 12);
        BufferedImage ima = new BufferedImage(9, 9, 12);
        BufferedImage im = new BufferedImage(9, 9, 12);
        try {


            image = ImageIO.read(getClass().getResource("/resources/sprite_0045.png"));
            imag = ImageIO.read(getClass().getResource("/resources/snowball1.png"));
            ima = ImageIO.read(getClass().getResource("/resources/snowball2.png"));
            im = ImageIO.read(getClass().getResource("/resources/snowball3.png"));

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

    }
}

