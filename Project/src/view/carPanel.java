package view;

import model.gameEngine;
import controller.gameController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by User on 2/3/2017.
 */
public class carPanel extends JPanel{
    public gameEngine engine;
    public gameController controller;
    public static final int height = 1000;
    public static final int width = 1000;

    public carPanel(){
        setPreferredSize(new Dimension(height, width));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    public void init(gameController controller, gameEngine engine){
        this.engine = engine;
        this.controller = controller;
        addKeyListener(controller);
        setFocusable(true);
        requestFocus();
        setLayout(null);
        setPreferredSize(new Dimension(width, height));
    }

    protected void paintComponent(java.awt.Graphics g){

    }

}
