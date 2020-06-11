package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class DecorationEnemyTh extends GameObject {

    private int dec;
    private Handler handler;

    public DecorationEnemyTh(float x, float y, ID id, Handler handler,int dec) {
        super(x, y, id);
        this.dec=dec;
        this.handler = handler;
        velX = 5;
        velY = 4;
    }
    public Rectangle getBounds() {
        if(dec==0)
        return new Rectangle((int)x, (int)y, 23, 24);
        if(dec==1)
            return new Rectangle((int)x, (int)y, 40, 49);
        if(dec==2)
            return new Rectangle((int)x, (int)y, 30, 24);
        if(dec==3)
            return new Rectangle((int)x, (int)y, 21, 31);
        if(dec==4)
            return new Rectangle((int)x, (int)y, 45, 60);
        if(dec==5)
            return new Rectangle((int)x, (int)y, 37, 40);
        if(dec==6)
            return new Rectangle((int)x, (int)y, 32, 32);
        return new Rectangle((int)x, (int)y, 0, 0);
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
        handler.addObject(new BasicTrail(x, y, ID.BasicTrail, Color.cyan, 9, 9, 0.1f, handler));
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
            image = ImageIO.read(new File("C:\\Users\\Owner\\IdeaProjects\\SquiGo\\SquiGoWithSwing\\src\\Game\\resources\\ornament\\ornament1.png"));
            imag = ImageIO.read(new File("C:\\Users\\Owner\\IdeaProjects\\SquiGo\\SquiGoWithSwing\\src\\Game\\resources\\ornament\\ornament2.png"));
            ima = ImageIO.read(new File("C:\\Users\\Owner\\IdeaProjects\\SquiGo\\SquiGoWithSwing\\src\\Game\\resources\\ornament\\ornament2.png"));
            im = ImageIO.read(new File("C:\\Users\\Owner\\IdeaProjects\\SquiGo\\SquiGoWithSwing\\src\\Game\\resources\\ornament\\ornament4.png"));
            i = ImageIO.read(new File("C:\\Users\\Owner\\IdeaProjects\\SquiGo\\SquiGoWithSwing\\src\\Game\\resources\\ornament\\ornament5.png"));
            i1 = ImageIO.read(new File("C:\\Users\\Owner\\IdeaProjects\\SquiGo\\SquiGoWithSwing\\src\\Game\\resources\\ornament\\ornament6.png"));
            i2 = ImageIO.read(new File("C:\\Users\\Owner\\IdeaProjects\\SquiGo\\SquiGoWithSwing\\src\\Game\\resources\\ornament\\ornament7.png"));
            //тут в мене якийсь трабл зі шляхом, прайює тільки, коли повний, в Каті і з коротним все добре
            // хз як виправити, хай поки буде так
            // короткий "src\\Game\\resources\\treeG.png"
            // мій "C:\Users\Owner\IdeaProjects\SquiGo\SquiGoWithSwing\src\Game\resources\treeG.png"
        } catch (Exception e) {
            e.printStackTrace();
        }g.drawImage(image, (int) x, (int) y, null);
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

