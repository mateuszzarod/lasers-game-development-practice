package com.game.main;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {

    public Window(int width, int height, String title, Game game){
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//to metoda coś jak x w rogu okna
        frame.setResizable(false); //can we resize our window
        frame.setLocationRelativeTo(null); //okno na środku, bazowo zaczyna w lewym rogu
        frame.add(game); //game class into the frame
        frame.setVisible(true);
        game.start(); //start method starts our thread in Game class

    }


}
