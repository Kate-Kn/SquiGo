package Model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private Handler handler;
    private boolean[] keyDown = new boolean[4];
    Game game;


    public KeyInput(Handler handler, Game game) {
        this.game=game;
        this.handler = handler;
        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject temp = handler.object.get(i);
            if (temp.getId() == ID.Player) {
                if (key == KeyEvent.VK_UP) {
                    temp.setVelY(-5);
                    keyDown[0] = true;
                }
                if (key == KeyEvent.VK_DOWN) {
                    temp.setVelY(5);
                    keyDown[1] = true;
                }
                if (key == KeyEvent.VK_LEFT) {
                    temp.setVelX(-5);
                    keyDown[2] = true;
                }
                if (key == KeyEvent.VK_RIGHT) {
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
        if (key ==KeyEvent.VK_SPACE){
            if(game.gameState== Game.STATE.Game){
                Game.paused=!Game.paused;
//                    if(Game.paused){
//                        Game.paused=false;
//                    }else {
//                        Game.paused = true;
//                    }
            }
        }

        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(1);
        }
        if(key==KeyEvent.VK_S){
            if(Game.gameState== Game.STATE.Game){
                Game.gameState= Game.STATE.Shop;
            }else if(Game.gameState== Game.STATE.Shop)
                Game.gameState= Game.STATE.Game;
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject temp = handler.object.get(i);
            if (temp.getId() == ID.Player) {
                if (key == 38) {
                    keyDown[0] = false;
                    //temp.setVelY(0);
                }
                if (key == 40) {
                    keyDown[1] = false;
                    //temp.setVelY(0);
                }
                if (key == 37) {
                    keyDown[2] = false;
                    // temp.setVelX(0);
                }
                if (key == 39) {
                    keyDown[3] = false;
                    // temp.setVelX(0);
                }
                if(!keyDown[0]&& !keyDown[1]){
                    temp.setVelY(0);
                }
                if(!keyDown[2]&& !keyDown[3]){
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
