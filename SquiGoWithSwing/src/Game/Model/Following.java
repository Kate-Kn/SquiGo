package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Following extends GameObject {

    private Handler handler;
    private  GameObject player;
    private  int timer=250;
    Random random=new Random();

    public Following(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        for(int i=0;i<handler.object.size();i++){
            if(handler.object.get(i).getId()==ID.Player){
                player=handler.object.get(i);
            }
        }


    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 44, 97);
    }

    @Override
    public void tick() {
        float diffX=x-player.getX()-8;
        float diffY=y-player.getY()-8;
        float distance= (float) Math.sqrt((x-player.getX())*(x-player.getX())+(y-player.getY())*(y-player.getY()));
        velX=((-1)/distance)*diffX;
        velY=((-1)/distance)*diffY;
        x += velX;
        y += velY;
        if(timer<=0){
            if(!SnowflakeEnemyF.isA) {
                handler.addObject(new Nut(random.nextInt(Game.WIDTH-60), ThreadLocalRandom.current().nextInt(50, Game.HEIGHT - 100), ID.Nut, handler));
                SnowflakeEnemyF.isA=true;
            } else
                timer=200;
        }else{
            timer--;
        }

        handler.addObject(new BasicTrail(x, y, ID.BasicTrail, Color.red, 9, 9, 0.1f, handler));
    }

    @Override
    public void render(Graphics g) {
        BufferedImage image = new BufferedImage(9, 9, 12);
        try {
          image = ImageIO.read(getClass().getResource("/resources/santa.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        g.drawImage(image, (int)x, (int)y, null);
    }
}
