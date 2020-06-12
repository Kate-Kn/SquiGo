
package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class Nut extends GameObject {
    Random r=new Random();
    private Handler handler;
    public static boolean isRemoved=false;
    public Nut(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 3;
        velY = 2;
    }

    public Rectangle getBounds()
    {
        return new Rectangle((int)x, (int)y, 30, 43);
    }
    @Override
    public void tick() {
        x += velX;
        y += velY;
        if(y>Game.HEIGHT) {
            handler.removeObject(this);
            SnowflakeEnemyF.isA=false;
        }
       handler.addObject(new BasicTrail(x, y, ID.BasicTrail, Color.orange, 4, 4, 0.1f, handler));

    }

    @Override
    public void render(Graphics g) {

        BufferedImage image = new BufferedImage(9, 9, 12);
        try {

          image = ImageIO.read(getClass().getResource("/resources/nut.png"));
           //image = ImageIO.read(new File("src\\Game\\resources\\nut.png")); last path used 10.06
            //тут в мене якийсь трабл зі шляхом, прайює тільки, коли повний, в Каті і з коротним все добре
            // хз як виправити, хай поки буде так
            // короткий "src\\Game\\resources\\treeG.png"
            // мій "C:\Users\Owner\IdeaProjects\SquiGo\SquiGoWithSwing\src\Game\nut.png"
        } catch (Exception e) {
            e.printStackTrace();
        }

            g.drawImage(image, (int) x, (int) y, null);
    }
}
