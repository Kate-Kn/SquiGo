package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class BasicEnemy extends GameObject{

    private Handler handler;

    public BasicEnemy(int x,int y,ID id, Handler handler){
        super(x,y,id);
        this.handler=handler;
        velX=5;
        velY=5;


    }
    public Rectangle getBounds(){
        return new Rectangle(x,y, 30,56);
    }
    @Override
    public void tick() {
    x+=velX;
    y+=velY;
      if(x<=0||x>=Game.WIDTH-32){
          velX *= -1;
      }
        if(y<=0||y>=Game.HEIGHT-16){
            velY*=-1;
        }

    handler.addObject(new BasicTrail(x,y,ID.BasicTrail, Color.green, 9,9, 0.1f, handler) );
    }

    @Override
    public void render(Graphics g) {
        BufferedImage image=new BufferedImage(9,9,12);
        try {
            image = ImageIO.read(new File("src\\Game\\resources\\treeG.png"));
            //тут в мене якийсь трабл зі шляхом, прайює тільки, коли повний, в Каті і з коротним все добре
            // хз як виправити, хай поки буде так
            // короткий "src\\Game\\resources\\treeG.png"
            // мій "C:\Users\Owner\IdeaProjects\SquiGo\SquiGoWithSwing\src\Game\resources\treeG.png"
        }catch(Exception e){
            e.printStackTrace();
        }

        g.drawImage(image,x,y,null);
    }
}
