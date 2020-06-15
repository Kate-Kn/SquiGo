package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class Player extends GameObject {
    Random r = new Random();
    Handler handler;

    public Player(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 30, 41);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        x = Game.clam(x, 0, Game.WIDTH - 45);
        y = Game.clam(y, 50, Game.HEIGHT - 82);
        handler.addObject(new BasicTrail(x, y, ID.BasicTrail, Color.white, 9, 9, 0.02f, handler));

        collision();
    }

    private void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getId() == ID.TreeEnemyS || tempObject.getId() == ID.SnowflakeEnemyF || tempObject.getId() == ID.SantaEnemyFif || tempObject.getId() == ID.ReindeerEnemyFo || tempObject.getId() == ID.ReindeerBullet | tempObject.getId() == ID.SantaBullet || tempObject.getId() == ID.DecorationEnemyTh) {
                if (getBounds().intersects(tempObject.getBounds())) { //temp object is now a basic enemy
                    // collision code
                    HUD.HEALTH -= 0;

                }
            }
            if (tempObject.getId() == ID.Nut) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    handler.removeObject(tempObject);
                    HUD.nuts += 1;
//nut sound added
                    Audio.getSound("nut").play();
                    SnowflakeEnemyF.isA = false;
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
                //image = ImageIO.read(new File("src\\Game\\resources\\rabbit.png")); попередній шлях 10.06
                image = ImageIO.read(getClass().getResource("/resources/rabbit.png"));

            } catch (Exception e) {
                e.printStackTrace();
            }
            g.drawImage(image, (int) x, (int) y, null);
        }
//        if(id==ID.Player2) {
//            g.setColor(Color.red);
//           g.fillRect(x,y,32,32);
    }
}
