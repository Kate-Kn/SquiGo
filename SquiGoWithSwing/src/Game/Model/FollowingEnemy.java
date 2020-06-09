package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class FollowingEnemy extends GameObject {

    private Handler handler;
    private  GameObject player;

    public FollowingEnemy(float x, float y, ID id, Handler handler) {
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
        /*if (x <= 0 || x >= Game.WIDTH - 32) {
            velX *= -1;
        }
        if (y <= 0 || y >= Game.HEIGHT - 85) {
            velY *= -1;
        }*/

        handler.addObject(new BasicTrail(x, y, ID.BasicTrail, Color.red, 9, 9, 0.1f, handler));
    }

    @Override
    public void render(Graphics g) {
        BufferedImage image = new BufferedImage(9, 9, 12);
        try {
            image = ImageIO.read(new File("C:\\Users\\Owner\\IdeaProjects\\SquiGo\\SquiGoWithSwing\\src\\Game\\resources\\santa.png"));
            //тут в мене якийсь трабл зі шляхом, прайює тільки, коли повний, в Каті і з коротним все добре
            // хз як виправити, хай поки буде так
            // короткий "src\\Game\\resources\\treeG.png"
            // мій "C:\Users\Owner\IdeaProjects\SquiGo\SquiGoWithSwing\src\Game\resources\treeG.png"
        } catch (Exception e) {
            e.printStackTrace();
        }

        g.drawImage(image, (int)x, (int)y, null);
    }
}

