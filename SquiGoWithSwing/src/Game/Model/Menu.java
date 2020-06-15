package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Menu extends MouseAdapter {
    private Game game;
    private Handler handler;
    private Random r=new Random();
    private int buttonWidth=Game.WIDTH/5;
    private int buttonHeigth=Game.HEIGHT/5;
    HUD hud;
    int p3 = 2;
    int p4=3;
    boolean isSk = false;
    public Menu(Game game, Handler handler, HUD hud){
        this.game=game;
        this.handler=handler;
        this.hud=hud;
    }
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        int mx = e.getX();
        int my = e.getY();

        if (game.gameState == Game.STATE.Menu) {
            //play button
            if (mouseOver(mx, my, 210, 150, 300, 64)) {
//                game.gameState = Game.STATE.Game;//??
//                handler.addObject(new Player(50,  0, ID.Player, handler));
//                for(int i=0;i<5;i++)
//                handler.addObject(new SnowflakeEnemyF(r.nextInt(Game.WIDTH-60), ThreadLocalRandom.current().nextInt(50, Game.HEIGHT-100), ID.SnowflakeEnemyF, handler));
           game.gameState= Game.STATE.Select;
//click sound added
           // Audio.getSound("menu_sound").play();
           return;
            }
            //help button
            if (mouseOver(mx, my, 210, 250, 200, 64)) {
//click sound added
                Audio.getSound("menu_sound").play();
                game.gameState = Game.STATE.Help;
            }
            //quit button
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
//click sound added
                Audio.getSound("menu_sound").play();
                System.exit(1);
            }
        }
        if (game.gameState == Game.STATE.Select) {
            //normal button
            if (mouseOver(mx, my, 210, 150, 300, 64)) {
                game.gameState = Game.STATE.Game;
                handler.addObject(new Player(50,  0, ID.Player, handler));
                for(int i=0;i<5;i++)
                handler.addObject(new SnowflakeEnemyF(r.nextInt(Game.WIDTH-60), ThreadLocalRandom.current().nextInt(50, Game.HEIGHT-100), ID.SnowflakeEnemyF, handler));
                game.diff=0;
//click sound and game sound added
                Audio.getSound("menu_sound").play();
                Audio.loadmusic();
                Audio.getMusic("music_game").loop();
            }
            //hard button
            if (mouseOver(mx, my, 210, 250, 200, 64)) {
                game.gameState = Game.STATE.Game;
                handler.addObject(new Player(50,  0, ID.Player, handler));
                for(int i=0;i<5;i++)
                handler.addObject(new SnowflakeEnemyFhard(r.nextInt(Game.WIDTH-60), ThreadLocalRandom.current().nextInt(50, Game.HEIGHT-100), ID.SnowflakeEnemyF, handler));
                game.diff=1;
//click sound and game sound added
                Audio.getSound("menu_sound").play();
                Audio.loadmusic();
                Audio.getMusic("music_game").loop();
            }
            //back button
            if (mouseOver(mx, my, 210, 350, 200, 64)) {

                    game.gameState = Game.STATE.Menu;
//click sound added
                    Audio.getSound("menu_sound").play();
                    return;
            }
        }


        //back button for help
        if (game.gameState == Game.STATE.Help) {
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = Game.STATE.Menu;
//click sound added
                Audio.getSound("menu_sound").play();
                return;
            }
        }

        //buttons for end
        if (game.gameState == Game.STATE.End) {
            //try again
            if (mouseOver(mx, my, 210, 350, 200, 50)) {
                game.gameState = Game.STATE.Select;

                hud.setLevel(1);
                hud.setScore(0);
                Spawn.scoreKeep=0;
//                handler.addObject(new Player((Game.WIDTH / 2 - 32), (Game.HEIGHT / 2 - 32), ID.Player, handler));
//                for(int i=0;i<5;i++)
//                    handler.addObject(new SnowflakeEnemyF(r.nextInt(Game.WIDTH-60), ThreadLocalRandom.current().nextInt(50, Game.HEIGHT-100), ID.SnowflakeEnemyF, handler));//1 level

            }
            //previous level
            if (mouseOver(mx, my, 90, 290, 400, 50)) {
                if(hud.getNuts()>=1) {
                    game.gameState = Game.STATE.Game;
                    Game.paused=true;
                    hud.setLevel(hud.getLevel());

                    hud.setNuts(hud.getNuts()-1);
                    hud.HEALTH = 100;

                    if(game.diff==0){
                        Audio.getSound("menu_sound").play();
                        Audio.loadmusic();
                        Audio.getMusic("music_game").loop();
                        if(hud.getLevel()==1){
                            hud.setScore(0);
                            game.gameState = Game.STATE.Game;
                            handler.addObject(new Player(50,  0, ID.Player, handler));
                            for(int i=0;i<5;i++)
                                handler.addObject(new SnowflakeEnemyF(r.nextInt(Game.WIDTH-60), ThreadLocalRandom.current().nextInt(50, Game.HEIGHT-100), ID.SnowflakeEnemyF, handler));
                            game.diff=0;

                        }
                        else if (hud.getLevel()==2){
                            hud.setScore(1000);
                            handler.clearEnemies();
                            handler.addObject(new Player(50,  0, ID.Player, handler));
                            for (int i = 0; i < 10; i++)
                                handler.addObject(new TreeEnemyS(r.nextInt(Game.WIDTH - 60), ThreadLocalRandom.current().nextInt(50, Game.HEIGHT - 100), ID.TreeEnemyS, handler, ThreadLocalRandom.current().nextInt(0, 5)));

                        }
                        else if (hud.getLevel()==3){
                            hud.setScore(2000);
                            handler.clearEnemies();
                            handler.addObject(new Player(50,  0, ID.Player, handler));
                            for (int i = 0; i < 10; i++)
                                handler.addObject(new DecorationEnemyTh(r.nextInt(Game.WIDTH - 60), ThreadLocalRandom.current().nextInt(50, Game.HEIGHT - 100), ID.DecorationEnemyTh, handler, ThreadLocalRandom.current().nextInt(0, 7)));

                        }else if (hud.getLevel()==4){
                            hud.setScore(3000);
                            handler.clearEnemies();
                            handler.addObject(new Player(50,  0, ID.Player, handler));
                            handler.addObject(new ReindeerEnemyFo((Game.WIDTH - 150), (Game.HEIGHT - 300), ID.ReindeerEnemyFo, handler, 1));
                            handler.addObject(new ReindeerEnemyFo((0), (Game.HEIGHT - 150), ID.ReindeerEnemyFo, handler, 2));

                        }else if (hud.getLevel()==5){
                            hud.setScore(4000);
                            SantaEnemyFif sa = new SantaEnemyFif((Game.WIDTH / 2 - 48), -50, ID.SantaEnemyFif, handler);
                            handler.clearEnemies();
                            handler.addObject(new Player(50,  0, ID.Player, handler));

                            handler.addObject(sa);
                        }

                    }else if(game.diff==1){
                        hud.setScore(0);
                        Audio.getSound("menu_sound").play();
                        Audio.loadmusic();
                        Audio.getMusic("music_game").loop();
                        if(hud.getLevel() == 1){
                            handler.addObject(new Player(50,  0, ID.Player, handler));
                            for(int i=0;i<5;i++)
                                handler.addObject(new SnowflakeEnemyFhard(r.nextInt(Game.WIDTH-60), ThreadLocalRandom.current().nextInt(50, Game.HEIGHT-100), ID.SnowflakeEnemyF, handler));
                            game.diff=1;
                        }
                        SantaEnemyFif sa = new SantaEnemyFif((Game.WIDTH / 2 - 48), -50, ID.SantaEnemyFif, handler);
                        if (hud.getLevel() == 2) {
                            hud.setScore(1000);
                            handler.clearEnemies();
                            handler.addObject(new Player(50,  0, ID.Player, handler));

                            for (int i = 0; i < 10; i++)
                                handler.addObject(new TreeEnemyS(r.nextInt(Game.WIDTH - 60), ThreadLocalRandom.current().nextInt(50, Game.HEIGHT - 100), ID.TreeEnemyS, handler, ThreadLocalRandom.current().nextInt(0, 5)));
                        }
                        if (hud.getLevel() == 3) {
                            hud.setScore(2000);
                            handler.clearEnemies();
                            handler.addObject(new Player(50,  0, ID.Player, handler));

                            for (int i = 0; i < 10; i++)
                                handler.addObject(new DecorationEnemyTh(r.nextInt(Game.WIDTH - 60), ThreadLocalRandom.current().nextInt(50, Game.HEIGHT - 100), ID.DecorationEnemyTh, handler, ThreadLocalRandom.current().nextInt(0, 7)));
                        }
                        if (hud.getLevel() == 4) {
                            hud.setScore(3000);
                            handler.clearEnemies();
                            handler.addObject(new Player(50,  0, ID.Player, handler));

                            handler.addObject(new ReindeerEnemyFo((Game.WIDTH - 150), (Game.HEIGHT - 300), ID.ReindeerEnemyFo, handler, 1));
                            handler.addObject(new ReindeerEnemyFo((0), (Game.HEIGHT - 150), ID.ReindeerEnemyFo, handler, 2));
                        }
                        if (hud.getLevel() == 5) {
                            hud.setScore(4000);
                            handler.clearEnemies();
                            handler.addObject(new Player(50,  0, ID.Player, handler));

                            handler.addObject(sa);
                        }
                    }
                }
//                else {
//                    game.gameState=Game.STATE.Menu;
//                    hud.setLevel(1);
//                    hud.setScore(0);
//                    Spawn.scoreKeep=0;
//                }
//


            }
            //go to menu from end
            if (mouseOver(mx, my, 210, 230, 200, 50)) {
                game.gameState = Game.STATE.Menu;
                //menu sound added
                Audio.loadmusic();
                Audio.getMusic("music_menu").loop();

                hud.setLevel(1);
                hud.setScore(0);
                Spawn.scoreKeep=0;
//                handler.addObject(new Player((Game.WIDTH / 2 - 32), (Game.HEIGHT / 2 - 32), ID.Player, handler));
//                handler.addObject(new SnowflakeEnemyF(r.nextInt(Game.WIDTH - 60), Game.HEIGHT - 100, ID.SnowflakeEnemyF, handler));//1 level

            }

        }
        if (game.gameState == Game.STATE.Finish) {
            handler.clearEnemies();

            //back for finish
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = Game.STATE.Menu;

                hud.setLevel(1);
                hud.setScore(0);
//click sound added
                Audio.getSound("menu_sound").play();
                return;
            }
        }
        if(game.gameState == Game.STATE.Shop){

            mx = e.getX();
            my = e.getY();
            if (mx >= 50 && mx < 200) {
                if (my >= 100 && my <= 250) {
                    // if (hud.getNuts() >= 1) {
                    if (hud.HEALTH < 100) {
                        hud.setNuts(hud.getNuts() - 1);
                        if (hud.HEALTH <= 90)
                            hud.HEALTH = hud.HEALTH + 10;
                        else
                            hud.HEALTH = 100;
                    }
                    //}
                }
            }
            if (mx > 250 && mx < 400) {
                if (my >= 100 && my <= 250) {
                    //if (hud.getNuts() >= 1) {
                    hud.setNuts(hud.getNuts() - 1);
                    handler.speed++;
                    //}
                }
            }
            if (mx >= 450 && mx <= 600) {
                if (my >= 100 && my <= 250) {
                    //if (hud.getNuts() >= p3) {
                    if (hud.HEALTH < 100) {
                        hud.setNuts(hud.getNuts() - p3);
                        p3++;
                        hud.HEALTH = 100;
                    }
                    // }
                }
            }
            if (mx >= 250 && mx <= 640) {
                if (my >= 270 && my <= 420) {
                    //if (hud.getNuts() >= p4) {

                    if (!isSk) {
                        isSk=true;
                        hud.setNuts(hud.getNuts() - p4);
                        p4++;
                        if (hud.getLevel() <= 4) {
                            if (hud.getLevel() == 1)
                                hud.setScore(2000);
                            if (hud.getLevel() == 2)
                                hud.setScore(3000);
                            if (hud.getLevel() == 3)
                                hud.setScore(4000);
                            if (hud.getLevel() == 4)
                                hud.setScore(5000);
                        } else
                            hud.setScore(hud.getScore() + 1000);
                        Spawn.setScoreKeep(1000);
                    }
                }
                // }
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
        super.mousePressed(e);
    }
    private boolean mouseOver(int mx, int my, int x, int y,int width, int heigth){
        if(mx>x && mx<width+x){
            if(my>y && my<heigth+y){
                return  true;
            } else return false;
        }else return false;
    }

    public void tick(){

    }
    public void render (Graphics g) {
        if (game.gameState == Game.STATE.Menu) {
//added bc image menu
           BufferedImage imagem = new BufferedImage(10, 10, 12);
           try {
            imagem = ImageIO.read(getClass().getResource("/resources/backs/menuimag.png"));
            } catch (Exception e) {
                          e.printStackTrace();
            }
            g.drawImage(imagem, -10, 0, 660, 480, null);

            BufferedImage imagems = new BufferedImage(10, 10, 12);
                      try {

                          imagems = ImageIO.read(getClass().getResource("/resources/sqme.png"));
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                      g.drawImage(imagems, 10, 250, 180, 190, null);

//play customized
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            g.setFont(fnt);
            g.setColor(new Color(64,121, 127));
            g.setFont(fnt2);
            g.drawString("Play", 270, 190);
            BufferedImage imagepf = new BufferedImage(5, 5, 12);
               try {
                   imagepf = ImageIO.read(getClass().getResource("/resources/backs/frame2.png"));
               } catch (Exception e) {
                   e.printStackTrace();
               }
               g.drawImage(imagepf, 210, 150, 200, 64, null);

//help customized
            g.setColor(new Color(97,165, 177));
            g.drawString("Help", 270, 290);
            BufferedImage imagehf = new BufferedImage(5, 5, 12);
              try {
                imagehf = ImageIO.read(getClass().getResource("/resources/backs/frame1.png"));
              } catch (Exception e) {
                  e.printStackTrace();
              }
              g.drawImage(imagehf, 210, 250, 200, 64, null);

//quit customized
            g.setColor(new Color(97,165, 177));
            g.drawString("Quit", 270, 390);
            BufferedImage imageqf = new BufferedImage(5, 5, 12);
              try {
               imageqf = ImageIO.read(getClass().getResource("/resources/backs/frame1.png"));
             } catch (Exception e) {
               e.printStackTrace();
             }
             g.drawImage(imageqf, 210, 350, 200, 64, null);

//logo
            BufferedImage image = new BufferedImage(10, 10, 12);
            try {

                image = ImageIO.read(getClass().getResource("/resources/Logo.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            g.drawImage(image, 130, 5, 400, 130, null);


        } else if (game.gameState== Game.STATE.Help){
//added bc image menu
          BufferedImage imagem = new BufferedImage(10, 10, 12);
              try {

                  imagem = ImageIO.read(getClass().getResource("/resources/backs/helpm.png"));
              } catch (Exception e) {
                  e.printStackTrace();
              }
              g.drawImage(imagem, -10, 0, 660, 480, null);

            g.setColor(new Color(97,165, 177));
            Font fnt2 = new Font("arial", 1, 30);
            g.setFont(fnt2);
            g.drawString("Back", 270, 390);
            g.drawRect(210, 350, 200, 64);

        }else if (game.gameState== Game.STATE.End){
          BufferedImage imagem = new BufferedImage(10, 10, 12);
          try {
         imagem = ImageIO.read(getClass().getResource("/resources/backs/menuimag.png"));
           } catch (Exception e) {
                         e.printStackTrace();
           }
           g.drawImage(imagem, -10, 0, 660, 480, null);

            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            g.setColor(new Color(97,165, 177));
            g.fillRect(40, 120,500, 40);

            g.setFont(fnt);
            g.setColor(Color.WHITE);
            g.drawString("Game over", 185, 70);
            g.setFont(fnt2);
            g.drawString( "Score: "+hud.getScore()+", level: "+ hud.getLevel()+ ", nuts: "+hud.getNuts(), 50, 150);

            g.setFont(fnt2);

            g.setColor(new Color(97,165, 177));
            g.drawString("Menu", 270, 270);
            g.drawRect(210, 230, 200, 50);

            g.drawString("Try from last level = -1 nut", 100, 320);
            g.drawRect(90, 290, 400, 50);


            g.drawString("Try again", 245, 380);
            g.drawRect(210, 350, 200, 50);


        }else if (game.gameState == Game.STATE.Select) {

          BufferedImage imagem = new BufferedImage(10, 10, 12);
            try {

                imagem = ImageIO.read(getClass().getResource("/resources/backs/menuselect.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            g.drawImage(imagem, -10, 0, 660, 480, null);

            Font fnt2 = new Font("arial", 1, 30);


            g.setFont(fnt2);
            g.setColor(new Color(64,121, 127));
            g.drawString("Normal", 270, 190);
            BufferedImage imagehf = new BufferedImage(5, 5, 12);
            try {

                imagehf = ImageIO.read(getClass().getResource("/resources/backs/frame2.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            g.drawImage(imagehf, 210, 150, 200, 64, null);

            g.setColor(new Color(97,165, 177));
            g.drawString("Hard", 270, 290);
            BufferedImage imagepf = new BufferedImage(5, 5, 12);
            try {

                imagepf = ImageIO.read(getClass().getResource("/resources/backs/frame1.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            g.drawImage(imagepf, 210, 250, 200, 64, null);

            g.setColor(new Color(97,165, 177));
            g.drawString("Back", 270, 390);
            BufferedImage imageqf = new BufferedImage(5, 5, 12);
            try {
              imageqf = ImageIO.read(getClass().getResource("/resources/backs/frame1.png"));
            } catch (Exception e) {
              e.printStackTrace();
            }
            g.drawImage(imageqf, 210, 350, 200, 64, null);


        }
        else if (game.gameState == Game.STATE.Finish){


            g.setColor(Color.white);
            g.setFont(new Font("arial", 0, 48));
            g.drawString("YOU WIN!", Game.WIDTH / 2 - 100, 50);

            g.setFont(new Font("arial", 0, 30));

            g.drawString( "Score: "+hud.getScore()+", level: "+ hud.getLevel()+ ", nuts: "+hud.getNuts(), 50, 150);

            BufferedImage imag = new BufferedImage(9, 9, 12);
            try {
                imag = ImageIO.read(getClass().getResource("/resources/fireworks1.png"));

            } catch (Exception e) {
                e.printStackTrace();
            }
            g.drawImage(imag,75,275,null);


            BufferedImage ima = new BufferedImage(9, 9, 12);
            try {
                ima = ImageIO.read(getClass().getResource("/resources/fireworks2.png"));

            } catch (Exception e) {
                e.printStackTrace();
            }
            g.drawImage(ima,275,175,null);

            g.setColor(Color.WHITE);
            g.setFont(new Font("arial", 0, 30));
            g.drawString("Back", 270, 390);
            g.drawRect(210, 350, 200, 64);
        }
        else if(game.gameState == Game.STATE.Shop){

            g.setColor(Color.white);
            g.setFont(new Font("arial", 0, 48));
            g.drawString("SHOP", Game.WIDTH / 2 - 100, 50);

            g.setFont(new Font("arial", 0, 12));
            g.drawRect(50, 100, 150, 150);
            g.drawString("Upgrade Health (+10%) ", 60, 120);
            g.drawString("Cost : 1 nut", 60, 140);
            BufferedImage imag = new BufferedImage(9, 9, 12);
            try {
                imag = ImageIO.read(getClass().getResource("/resources/shop/hp_buymore.png"));

            } catch (Exception e) {
                e.printStackTrace();
            }
            g.drawImage(imag,75,175,null);

            g.drawRect(250, 100, 150, 150);
            g.drawString("Upgrade Speed", 260, 120);
            g.drawString("Cost : 1 nut", 260, 140);
            BufferedImage ima = new BufferedImage(9, 9, 12);
            try {
                ima = ImageIO.read(getClass().getResource("/resources/shop/speed_buy.png"));

            } catch (Exception e) {
                e.printStackTrace();
            }
            g.drawImage(ima,275,175,null);


            g.drawRect(450, 100, 150, 150);
            g.drawString("Refill Health", 460, 120);
            g.drawString("Cost : " + p3 + " nuts", 460, 140);

            BufferedImage image = new BufferedImage(9, 9, 12);
            try {
                image = ImageIO.read(getClass().getResource("/resources/shop/hp_buy.png"));

            } catch (Exception e) {
                e.printStackTrace();
            }
            g.drawImage(image,475,175,null);


            g.drawRect(250, 270, 150, 150);
            g.drawString("Skip level "+hud.getLevel(), 260, 290);
            g.drawString("Cost : " + p4 + " nuts", 260, 310);
            BufferedImage im = new BufferedImage(9, 9, 12);
            try {
                im = ImageIO.read(getClass().getResource("/resources/shop/enemy_buy.png"));

            } catch (Exception e) {
                e.printStackTrace();
            }
            g.drawImage(im,270,315,null);


            g.drawString("Nuts: " + hud.getNuts(), Game.WIDTH - 150, 400);
            g.drawString("Health: " + hud.HEALTH, Game.WIDTH - 150, 415);
            g.drawString("Speed: " + handler.speed, Game.WIDTH - 150, 385);
            g.drawString("Press s to go back", Game.WIDTH - 150, 430);

        }
    }
}
