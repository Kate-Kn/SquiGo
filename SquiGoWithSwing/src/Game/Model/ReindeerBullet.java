package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ReindeerBullet extends GameObject {
    Random r=new Random();
    private Handler handler;
    private int dec;
    private int i;
    private int timer=20;

    public ReindeerBullet(float x, float y, ID id, Handler handler,int i,int dec) {
        super(x, y, id);
        this.dec=dec;

        this.i=i;
        this.handler = handler;
        if(i==2) {
            velX = 3;
            velY = 0;
        }
        if(i==1) {
            velX = -3;
            velY = 0;
        }

    }
    public Rectangle getBounds() {
        if(dec==0)
             return new Rectangle((int)x, (int)y, 18, 24);
        if(dec==1)
            return new Rectangle((int)x+20, (int)y+20, 20, 20);
        if(dec==2)
            return new Rectangle((int)x, (int)y, 47, 49);
        if(dec==3)
            return new Rectangle((int)x, (int)y, 19, 19);
        if(dec==4)
            return new Rectangle((int)x, (int)y, 20, 20);
        if(dec==5)
            return new Rectangle((int)x, (int)y, 50, 40);
        if(dec==6)
            return new Rectangle((int)x, (int)y, 34, 40);
        return new Rectangle((int)x, (int)y, 0, 0);
    }
    @Override
    public void tick() {
        x += velX;
        y += velY;
if (timer<=0){
    if((i==1&&velY==0)||(i==2&&velY==0)){
        velY=3;
    }
}else{
    timer--;
}
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
        BufferedImage i1 = new BufferedImage(9, 9, 12);
        BufferedImage i2 = new BufferedImage(9, 9, 12);
        try {
//            image = ImageIO.read(new File("src\\Game\\resources\\candy\\candy1.png"));
//            imag = ImageIO.read(new File("src\\Game\\resources\\candy\\candy2.png"));
//            ima = ImageIO.read(new File("src\\Game\\resources\\candy\\candy3.png"));
//            im = ImageIO.read(new File("src\\Game\\resources\\candy\\candy4.png"));
//            i = ImageIO.read(new File("src\\Game\\resources\\candy\\candy5.png"));
//            i1 = ImageIO.read(new File("src\\Game\\resources\\candy\\candy6.png"));
//            i2 = ImageIO.read(new File("src\\Game\\resources\\candy\\candy7.png"));

            image = ImageIO.read(new File("C:\\Users\\Owner\\IdeaProjects\\SquiGo\\SquiGoWithSwing\\src\\Game\\resources\\candy\\candy1.png"));
            imag = ImageIO.read(new File("C:\\Users\\Owner\\IdeaProjects\\SquiGo\\SquiGoWithSwing\\src\\Game\\resources\\candy\\candy2.png"));
            ima = ImageIO.read(new File("C:\\Users\\Owner\\IdeaProjects\\SquiGo\\SquiGoWithSwing\\src\\Game\\resources\\candy\\candy3.png"));
            im = ImageIO.read(new File("C:\\Users\\Owner\\IdeaProjects\\SquiGo\\SquiGoWithSwing\\src\\Game\\resources\\candy\\candy4.png"));
            i = ImageIO.read(new File("C:\\Users\\Owner\\IdeaProjects\\SquiGo\\SquiGoWithSwing\\src\\Game\\resources\\candy\\candy5.png"));
            i1 = ImageIO.read(new File("C:\\Users\\Owner\\IdeaProjects\\SquiGo\\SquiGoWithSwing\\src\\Game\\resources\\candy\\candy6.png"));
            i2 = ImageIO.read(new File("C:\\Users\\Owner\\IdeaProjects\\SquiGo\\SquiGoWithSwing\\src\\Game\\resources\\candy\\candy7.png"));
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
        if(dec==5) {
            g.drawImage(i1, (int) x, (int) y, null);
        }
        if(dec==6) {
            g.drawImage(i2, (int) x, (int) y, null);
        }
    }
}

