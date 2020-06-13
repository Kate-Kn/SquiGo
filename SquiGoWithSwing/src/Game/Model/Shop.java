package Model;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends MouseAdapter {
    private Handler handler;
    HUD hud;
    private int p3 = 2;
    private int p4=3;

    public Shop(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("arial", 0, 48));
        g.drawString("SHOP", Game.WIDTH / 2 - 100, 50);

        g.setFont(new Font("arial", 0, 12));
        g.drawRect(50, 100, 150, 150);
        g.drawString("Upgrade Health (+10%) ", 60, 120);
        g.drawString("Cost : 1 nut", 60, 140);

        g.drawRect(250, 100, 150, 150);
        g.drawString("Upgrade Speed", 260, 120);
        g.drawString("Cost : 1 nut", 260, 140);

        g.drawRect(450, 100, 150, 150);
        g.drawString("Refill Health", 460, 120);
        g.drawString("Cost : " + p3 + " nuts", 460, 140);

        g.drawRect(250, 270, 150, 150);
        g.drawString("Remove all enemies", 260, 290);
        g.drawString("Cost : " + p4 + " nuts", 260, 310);


        g.drawString("Nuts: " + hud.getNuts(), Game.WIDTH - 150, 400);
        g.drawString("Health: " + hud.HEALTH, Game.WIDTH - 150, 415);
        g.drawString("Speed: " + handler.speed, Game.WIDTH - 150, 385);
        g.drawString("Press s to go back", Game.WIDTH - 150, 430);
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

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
                    hud.setNuts(hud.getNuts() - p4);
                    p4++;
                    hud.HEALTH = 100;

                // }
            }
        }

    }
}
