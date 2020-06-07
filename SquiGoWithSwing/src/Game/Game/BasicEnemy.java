package Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class BasicEnemy extends GameObject{
    public BasicEnemy(int x,int y,ID id){
        super(x,y,id);
    }

    @Override
    public void tick() {
    x+=velX;
    y+=velY;

    }

    @Override
    public void render(Graphics g) {
        BufferedImage image=new BufferedImage(9,9,12);
        try {
            image = ImageIO.read(new File("src\\Game\\resources\\rabbit.png"));
        }catch(Exception e){
            e.printStackTrace();
        }
        g.drawImage(image,x,y,null);
    }
}
