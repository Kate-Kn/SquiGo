package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SantaEnemyFif extends GameObject {

    private Handler handler;
    private GameObject player;
    Random random = new Random();
    private int timer = 35;
    private int timer2 = 10;
    private int timer3 = 250;

    public SantaEnemyFif(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 0;
        velY = 3;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 44, 97);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        if (timer <= 0) {
            velY = 0;
        } else {
            timer--;
        }
        if (timer <= 0) {
            timer2--;
        }
        if (timer2 <= 0) {
            if (velX == 0) {
                velX = 4;
            }
            int spawn = random.nextInt(10);
            if (spawn == 0)
                handler.addObject(new SantaBullet(x + 40, y + 75, ID.SantaBullet, handler, ThreadLocalRandom.current().nextInt(0, 5), (int) x));
        }
        if (timer3 <= 0) {
            if (!SnowflakeEnemyF.isA) {
                handler.addObject(new Nut(random.nextInt(Game.WIDTH - 60), ThreadLocalRandom.current().nextInt(50, Game.HEIGHT - 100), ID.Nut, handler));
                SnowflakeEnemyF.isA = true;
            } else
                timer3 = 200;
        } else {
            timer3--;
        }

        if (x <= -30 || x >= 640 - 50) {
            velX *= -1;
        }
        //if (y <= 0 || y >= Game.HEIGHT - 85) {
        //  velY *= -1;
        //}
        //  handler.addObject(new BasicTrail(x, y, ID.BasicTrail, Color.red, 9, 9, 0.08f, handler));
    }

    @Override
    public void render(Graphics g) {
        BufferedImage image = new BufferedImage(9, 9, 12);
        try {

            image = ImageIO.read(getClass().getResource("/resources/santa2.png"));
            //image = ImageIO.read(new File("C:\\Users\\Owner\\IdeaProjects\\SquiGo\\SquiGoWithSwing\\src\\Game\\resources\\santa2.png")); last path used 10.06
            //тут в мене якийсь трабл зі шляхом, прайює тільки, коли повний, в Каті і з коротним все добре
            // хз як виправити, хай поки буде так
            // короткий "src\\Game\\resources\\treeG.png"
            // мій "C:\Users\Owner\IdeaProjects\SquiGo\SquiGoWithSwing\src\Game\resources\treeG.png"
        } catch (Exception e) {
            e.printStackTrace();
        }

        g.drawImage(image, (int) x, (int) y, null);
    }

}
