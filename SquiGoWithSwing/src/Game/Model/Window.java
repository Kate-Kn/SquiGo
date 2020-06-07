package Model;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {
    public Window (int WIGTH, int HEIGTH, String title, Game game){
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(WIGTH, HEIGTH));
        frame.setMaximumSize(new Dimension(WIGTH, HEIGTH));
        frame.setMinimumSize(new Dimension(WIGTH, HEIGTH));


        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();


    }

}
