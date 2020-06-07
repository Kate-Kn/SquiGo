package Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Player extends GameObject {
    Random r=new Random();
    public Player(int x, int y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {
    x+=velX;
    y+=velY;
    }

    @Override
    public void render(Graphics g)  {
        if(id==ID.Player) {
           // g.setColor(Color.white);
            BufferedImage image=new BufferedImage(9,9,12);
            try {
                 image = ImageIO.read(new File("src\\Game\\resources\\rabbit.png"));
            }catch(Exception e){
                e.printStackTrace();
            }
            g.drawImage(image,x,y,null);
        }
        if(id==ID.Player2) {
            g.setColor(Color.red);
           g.fillRect(x,y,32,32);
        }



    }
}
