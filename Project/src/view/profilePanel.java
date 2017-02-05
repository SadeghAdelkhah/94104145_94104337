package view;

import model.Player;
import model.Racing;
import model.gameEngine;
import controller.gameController;
import sun.awt.image.BufferedImageDevice;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * Created by User on 2/3/2017.
 */
public class profilePanel extends JPanel{
    public Player player;
    public gameEngine engine;
    public gameController controller;
    public static final int width = 500;
    public static final int height = 500;
    public JComboBox carComboBox;
    public profilePanel1 profilePanel1;
    public JList<Racing> racingList;
    private imagePanel image;


    public profilePanel(Player player){
        this.player = player;
        setPreferredSize(new Dimension(width, height));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        carComboBox = new JComboBox();
        for(int i=0; i<player.getCars().length; i++){
            carComboBox.addItem(player.getCars()[i].name);
        }
        profilePanel1 = new profilePanel1(player);
        racingList = new JList<>();
    }

    public void init(gameController controller, gameEngine engine){
        this.engine = engine;
        this.controller = controller;
        setFocusable(true);
        requestFocus();
        setLayout(null);
        setPreferredSize(new Dimension(width, height));
        this.profilePanel1.init();
        this.add(profilePanel1, BorderLayout.WEST);
        this.add(racingList, BorderLayout.WEST);

    }





}
