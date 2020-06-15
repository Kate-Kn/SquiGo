package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ReindeerEnemyFo extends GameObject {

    private Handler handler;
    private  GameObject player;
    int i;
    private Random random=new Random();
    private  int timer=250;


    public ReindeerEnemyFo(float x, float y, ID id, Handler handler,int i) {
        super(x, y, id);
        this.i=i;
        this.handler = handler;
        for(int k=0;k<handler.object.size();k++){
            if(handler.object.get(k).getId()==ID.Player){
                player=handler.object.get(k);
            }
        }
        velX=0;
        velY=5;

    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 44, 97);
    }

    @Override
    public void tick() {
        /*float diffX=x-player.getX()-8;
        float diffY=y-player.getY()-8;
        float distance= (float) Math.sqrt((x-player.getX())*(x-player.getX())+(y-player.getY())*(y-player.getY()));
        velX=((-1)/distance)*diffX;
        velY=((-1)/distance)*diffY;*/
        x += velX;
        y += velY;
        /*if (x <= 0 || x >= Game.WIDTH - 32) {
            velX *= -1;
        }*/
        if (y <= 50 || y >= Game.HEIGHT - 85) {
            velY *= -1;
        }
        if(timer<=0){
            if(!SnowflakeEnemyF.isA) {
                handler.addObject(new Nut(random.nextInt(Game.WIDTH-60), ThreadLocalRandom.current().nextInt(50, Game.HEIGHT - 100), ID.Nut, handler));
                SnowflakeEnemyF.isA=true;
            } else
                timer=200;
        }else{
            timer--;
        }
        handler.addObject(new BasicTrail(x, y, ID.BasicTrail, Color.yellow, 9, 9, 0.1f, handler));
        int spawn= random.nextInt(30);
        if(spawn==0) {
            if (i == 1)
                handler.addObject(new ReindeerBullet(x, y, ID.ReindeerBullet, handler,1, ThreadLocalRandom.current().nextInt(0, 7)));
            if (i == 2)
                handler.addObject(new ReindeerBullet(x + 150, y, ID.ReindeerBullet, handler,2,1));
        }
    }

    @Override
    public void render(Graphics g) {
        BufferedImage image = new BufferedImage(9, 9, 12);
        BufferedImage imag = new BufferedImage(9, 9, 12);
        try {

          image = ImageIO.read(getClass().getResource("/resources/deer.png"));
          imag = ImageIO.read(getClass().getResource("/resources/deerL.png"));
            //image = ImageIO.read(new File("C:\\Users\\Owner\\IdeaProjects\\SquiGo\\SquiGoWithSwing\\src\\Game\\resources\\deer.png")); last path used 10.06
        
            //тут в мене якийсь трабл зі шляхом, прайює тільки, коли повний, в Каті і з коротним все добре
            // хз як виправити, хай поки буде так
            // короткий "src\\Game\\resources\\treeG.png"
            // мій "C:\Users\Owner\IdeaProjects\SquiGo\SquiGoWithSwing\src\Game\resources\treeG.png"
        } catch (Exception e) {
            e.printStackTrace();
        }
        if( i==1)
        g.drawImage(imag,(int)x,(int)y,null);
        if(i==2)
        g.drawImage(image, (int)x, (int)y, null);
    }
}
