package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SantaBullet extends GameObject {
   Random r=new Random();
    private Handler handler;
    private int dec=ThreadLocalRandom.current().nextInt(0, 5);

    public SantaBullet(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = (r.nextInt(5));
        velY = 4;


    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 30, 56);
    }
    @Override
    public void tick() {
        x += velX;
        y += velY;
     if(y>Game.HEIGHT)
         handler.removeObject(this);
        handler.addObject(new BasicTrail(x, y, ID.BasicTrail, Color.pink, 9, 9, 0.1f, handler));
    }

    @Override
    public void render(Graphics g) {

        BufferedImage image = new BufferedImage(9, 9, 12);
        BufferedImage imag = new BufferedImage(9, 9, 12);
        BufferedImage ima = new BufferedImage(9, 9, 12);
        BufferedImage im = new BufferedImage(9, 9, 12);
        BufferedImage i = new BufferedImage(9, 9, 12);
        try {
            image = ImageIO.read(new File("src\\Game\\resources\\present\\present1.png"));
            imag = ImageIO.read(new File("src\\Game\\resources\\present\\present3.png"));
            ima = ImageIO.read(new File("src\\Game\\resources\\present\\present4.png"));
            im = ImageIO.read(new File("src\\Game\\resources\\present\\present5.png"));
            i = ImageIO.read(new File("src\\Game\\resources\\present\\present6.png"));
            //тут в мене якийсь трабл зі шляхом, прайює тільки, коли повний, в Каті і з коротним все добре
            // хз як виправити, хай поки буде так
            // короткий "src\\Game\\resources\\treeG.png"
            // мій "C:\Users\Owner\IdeaProjects\SquiGo\SquiGoWithSwing\src\Game\resources\treeG.png"
        } catch (Exception e) {
            e.printStackTrace();
        }
       if(dec==0) {
           g.drawImage(image, (int) x, (int) y, null);
       }
      if(dec==1) {
           g.drawImage(imag, (int) x, (int) y, null);
       }
       if(dec==2) {
           g.drawImage(ima, (int) x, (int) y, null);
       }
       if(dec==3) {
           g.drawImage(im, (int) x, (int) y, null);
       }
       if(dec==4) {
           g.drawImage(i, (int) x, (int) y, null);
       }
    }
    }
