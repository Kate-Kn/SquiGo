package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Shop extends MouseAdapter {
    private Handler handler;
    HUD hud;
    private int p3 = 2;
    private int p4 = 3;
    boolean isSk = false;

    public Shop(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("arial", 1, 48));
        g.drawString("SHOP", 260, 50);

        g.setFont(new Font("arial", 0, 15));
        g.drawRect(50, 100, 170, 150);
        g.setColor(new Color(97,165, 177));
        g.drawString("Upgrade Health (+10%) ", 60, 120);
        g.drawString("Cost : 1 nut", 60, 140);
        BufferedImage imag = new BufferedImage(9, 9, 12);
        try {
            imag = ImageIO.read(getClass().getResource("/resources/shop/hp_buymore.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        g.drawImage(imag, 75, 175, null);
        g.setColor(Color.white);
        g.drawRect(250, 100, 150, 150);
        g.setColor(new Color(97,165, 177));
        g.drawString("Upgrade Speed", 260, 120);
        g.drawString("Cost : 1 nut", 260, 140);
        BufferedImage ima = new BufferedImage(9, 9, 12);
        try {
            ima = ImageIO.read(getClass().getResource("/resources/shop/speed_buy.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        g.drawImage(ima, 275, 175, null);

        g.setColor(Color.white);
        g.drawRect(450, 100, 150, 150);
        g.setColor(new Color(97,165, 177));
        g.drawString("Refill Health", 460, 120);
        g.drawString("Cost : " + p3 + " nuts", 460, 140);

        BufferedImage image = new BufferedImage(9, 9, 12);
        try {
            image = ImageIO.read(getClass().getResource("/resources/shop/hp_buy.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        g.drawImage(image, 475, 175, null);

        g.setColor(Color.white);
        g.drawRect(250, 270, 150, 150);
        g.setColor(new Color(97,165, 177));
        g.drawString("Skip level " + hud.getLevel(), 260, 290);
        g.drawString("Cost : " + p4 + " nuts", 260, 310);
        BufferedImage im = new BufferedImage(9, 9, 12);
        try {
            im = ImageIO.read(getClass().getResource("/resources/shop/enemy_buy.png"));
          } catch (Exception e) {
            e.printStackTrace();
        }
        g.drawImage(im, 270, 315, null);

        g.setColor(new Color(97,165, 177));
        g.setFont(new Font("arial", 0, 17));
        g.drawString("Nuts: " + hud.getNuts(), 475, 400);
        g.drawString("Health: " + hud.HEALTH, 475, 420);
        g.drawString("Speed: " + handler.speed, 475, 380);
        g.drawString("Press s to go back", 475, 435);
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (Game.gameState == Game.STATE.Shop) {
            if (mx >= 50 && mx < 200) {
                if (my >= 100 && my <= 250) {
                    if (hud.HEALTH < 100 && hud.getNuts() >= 1) {
                      Audio.getSound("shop_s").play();
                        hud.setNuts(hud.getNuts() - 1);
                        if (hud.HEALTH <= 90)
                            hud.HEALTH = hud.HEALTH + 10;
                        else
                            hud.HEALTH = 100;
                    }
                }
            }
            if (mx > 250 && mx < 400) {
                if (my >= 100 && my <= 250) {
                    if (hud.getNuts() >= 1) {
                      Audio.getSound("shop_s").play();
                        hud.setNuts(hud.getNuts() - 1);
                        handler.speed++;
                    }
                }
            }
            if (mx >= 450 && mx <= 600) {
                if (my >= 100 && my <= 250) {
                    if (hud.getNuts() >= p3 && hud.HEALTH < 100) {
                      Audio.getSound("shop_s").play();
                        hud.setNuts(hud.getNuts() - p3);
                        p3++;
                        hud.HEALTH = 100;
                    }
                }
            }
            if (mx >= 250 && mx <= 640) {
                if (my >= 270 && my <= 420) {
                    if (hud.getNuts() >= p4 && !isSk) {
                        isSk = true;
                        Audio.getSound("shop_s").play();
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
            }
        }
    }

}
