package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.io.File;
import java.text.AttributedCharacterIterator;
import java.util.Map;
import java.util.Random;

public class Player extends GameObject {
    Random r = new Random();
    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {

        super(x, y, id);
        this.handler = handler;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 30, 41);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        x = Game.clam(x, 0, Game.WIDTH - 45);
        y = Game.clam(y, 0, Game.HEIGHT - 82);
        handler.addObject(new BasicTrail(x, y, ID.BasicTrail, Color.white, 9, 9, 0.02f, handler));

        collision();
    }

    private void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getId() == ID.BasicEnemy||tempObject.getId() == ID.FastSnowflake) {
                if (getBounds().intersects(tempObject.getBounds())) { //temp object is now a basic enemy
                    // collision code
                    HUD.HEALTH -= 5;

                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        if (id == ID.Player) {
            Graphics2D g2 = (Graphics2D) g;
            //корисний код, щоб перевірити, чи відповідає задана висота і ширина картинці
            //g.setColor(Color.green);
            //g2.draw(getBounds());
            // g.setColor(Color.white);
            //задана висота і ширина не грає ніякої ролі, має значення тільки розмірність картинки
            BufferedImage image = new BufferedImage(156, 9, 12);

            try {
                image = ImageIO.read(new File("src\\Game\\resources\\rabbit.png"));
                //тут в мене якийсь трабл зі шляхом, прайює тільки, коли повний, в Каті і з коротним все добре
                // хз як виправити, хай поки буде так
                // короткий "src\\Game\\resources\\rabbit.png"
                // мій "C:\Users\Owner\IdeaProjects\SquiGo\SquiGoWithSwing\src\Game\resources\rabbit.png"

            } catch (Exception e) {
                e.printStackTrace();
            }
            g.drawImage(image, x, y, null);
        }
//        if(id==ID.Player2) {
//            g.setColor(Color.red);
//           g.fillRect(x,y,32,32);


    }
}
