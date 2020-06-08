package Model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private Handler handler;
    private boolean[] keyDown = new boolean[4];


    public KeyInput(Handler handler) {
        for (int i = 0; i < keyDown.length; i++) {
            keyDown[i] = false;
        }
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject temp = handler.object.get(i);
            if (temp.getId() == ID.Player) {
                if (key == 38) {
                    temp.setVelY(-5);
                    keyDown[0] = true;
                }
                if (key == 40) {
                    temp.setVelY(5);
                    keyDown[1] = true;
                }
                if (key == 37) {
                    temp.setVelX(-5);
                    keyDown[2] = true;
                }
                if (key == 39) {
                    temp.setVelX(5);
                    keyDown[3] = true;
                }


            }
//            if(temp.getId()==ID.Player2){
//                if(key==KeyEvent.VK_W)
//                    temp.setVelY(5);
//                if(key==KeyEvent.VK_S)
//                    temp.setVelY(-5);
//                if(key==KeyEvent.VK_D)
//                    temp.setVelX(5);
//                if(key==KeyEvent.VK_A)
//                    temp.setVelX(-5);
//
//
//            }


        }
        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(1);
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject temp = handler.object.get(i);
            if (temp.getId() == ID.Player) {
                if (key == 38)
                    keyDown[0]=false;
                    //temp.setVelY(0);
                if (key == 40)
                    keyDown[0]=false;
                    //temp.setVelY(0);
                if (key == 37)
                    keyDown[0]=false;
                   // temp.setVelX(0);
                if (key == 39)
                    keyDown[0]=false;
                   // temp.setVelX(0);
                if(keyDown[0]&& keyDown[1]){
                    temp.setVelY(0);
                }
                if(keyDown[2]&& keyDown[3]){
                    temp.setVelX(0);

                }

            }
            if (temp.getId() == ID.Player2) {
                if (key == KeyEvent.VK_W)
                    temp.setVelY(0);
                if (key == KeyEvent.VK_S)
                    temp.setVelY(0);
                if (key == KeyEvent.VK_D)
                    temp.setVelX(0);
                if (key == KeyEvent.VK_A)
                    temp.setVelX(0);


            }

        }

    }
}
