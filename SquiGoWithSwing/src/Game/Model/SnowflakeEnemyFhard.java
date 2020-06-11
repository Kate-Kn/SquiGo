package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SnowflakeEnemyFhard extends GameObject {
    private Handler handler;
    private Random r = new Random();
    private  int dec = ThreadLocalRandom.current().nextInt(0, 4);
    public SnowflakeEnemyFhard(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 5;
        velY = 2;
    }

    public Rectangle getBounds() {

        return new Rectangle((int)x, (int)y, 50, 50);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        y = Game.clam(y, 50, Game.HEIGHT - 82);
        if (x <= 0 || x >= Game.WIDTH - 32) {
            if(velX<0){
                velX= -(r.nextInt(7)+1)*-1;
            } else{
                velX= (r.nextInt(7)+1)*-1;
            }

        }
        if (y <= 50 || y >= Game.HEIGHT - 85) {
            if(velY<0){
                velY= -(r.nextInt(7)+1)*-1;
            } else{
                velY= (r.nextInt(7)+1)*-1;
            }
        }

        handler.addObject(new BasicTrail(x, y, ID.BasicTrail, Color.red, 4, 4, 0.1f, handler));
    }

    @Override
    public void render(Graphics g) {
        BufferedImage image = new BufferedImage(9, 9, 12);
        BufferedImage imag = new BufferedImage(9, 9, 12);
        BufferedImage ima = new BufferedImage(9, 9, 12);
        BufferedImage im = new BufferedImage(9, 9, 12);
        try {
            image = ImageIO.read(new File("C:\\Users\\Owner\\IdeaProjects\\SquiGo\\SquiGoWithSwing\\src\\Game\\resources\\sprite_0045.png"));
            imag = ImageIO.read(new File("C:\\Users\\Owner\\IdeaProjects\\SquiGo\\SquiGoWithSwing\\src\\Game\\resources\\snowball1.png"));
            ima = ImageIO.read(new File("C:\\Users\\Owner\\IdeaProjects\\SquiGo\\SquiGoWithSwing\\src\\Game\\resources\\snowball2.png"));
            im = ImageIO.read(new File("C:\\Users\\Owner\\IdeaProjects\\SquiGo\\SquiGoWithSwing\\src\\Game\\resources\\snowball3.png"));
            //тут в мене якийсь трабл зі шляхом, прайює тільки, коли повний, в Каті і з коротним все добре  sprite_0045
            // хз як виправити, хай поки буде так
            // короткий "src\\Game\\resources\\treeG.png"
            // мій "C:\Users\Owner\IdeaProjects\SquiGo\SquiGoWithSwing\src\Game\resources\snowflake.png"
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(dec==0)
            g.drawImage(image, (int)x, (int)y, null);

        if(dec==1)
            g.drawImage(imag, (int)x, (int)y, null);

        if(dec==2)
            g.drawImage(ima, (int)x, (int)y, null);

        if(dec==3)
            g.drawImage(im, (int)x, (int)y, null);

    }
}

