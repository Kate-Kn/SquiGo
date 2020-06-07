package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class BasicEnemy extends GameObject{
    public BasicEnemy(int x,int y,ID id){
        super(x,y,id);
        velX=5;
        velY=5;

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
    }

    @Override
    public void render(Graphics g) {
        BufferedImage image=new BufferedImage(9,9,12);
        try {
            image = ImageIO.read(new File("src\\Game\\resources\\treeG.png"));
        }catch(Exception e){
            e.printStackTrace();
        }
        g.drawImage(image,x,y,null);
    }
}
