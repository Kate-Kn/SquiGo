package Model;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends MouseAdapter {
    private Handler handler;
    HUD hud;
    private int p3 = 2;

    public Shop(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("arial", 0, 48));
        g.drawString("SHOP", Game.WIDTH / 2 - 100, 50);

        g.setFont(new Font("arial", 0, 12));
        g.drawRect(100, 100, 100, 80);
        g.drawString("Upgrade Health (+10%)", 110, 120);
        g.drawString("Cost : 1 nut", 110, 140);

        g.drawRect(250, 100, 100, 80);
        g.drawString("Upgrade Speed", 260, 120);
        g.drawString("Cost : 1 nut", 260, 140);

        g.drawRect(400, 100, 100, 80);
        g.drawString("Refill Health", 410, 120);
        g.drawString("Cost : " + p3 + " nuts", 410, 140);

        g.drawString("Nuts: " + hud.getNuts(), Game.WIDTH / 2 - 50, 300);
        g.drawString("Press s to go back", Game.WIDTH / 2 - 50, 330);
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (mx >= 100 || mx <= 200) {
            if (my >= 100 && my <= 180) {
                if (hud.getNuts() >= 1) {
                    hud.setNuts(hud.getNuts() - 1);
                    hud.bounds += 20;
                    if (hud.HEALTH <= 90)
                        hud.HEALTH = hud.HEALTH + hud.bounds / 2;
                    else
                        hud.HEALTH = 100;
                }
            }
        }
        if (mx >= 250 || mx <= 500) {
            if (my >= 100 && my <= 180) {
                if (hud.getNuts() >= 1) {
                    hud.setNuts(hud.getNuts() - 1);
                    handler.speed++;
                }
            }
        }
        if (mx >= 400 || mx <= 500) {
            if (my >= 100 && my <= 180) {
                if (hud.getNuts() >= 1) {
                    hud.setNuts(hud.getNuts() - p3);
                    p3++;
                    hud.HEALTH = 100;
                }
            }
        }

    }
}
