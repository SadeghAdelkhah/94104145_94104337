package view;

import javax.swing.*;
import javax.swing.border.Border;

import model.Player;
import model.gameEngine;
import controller.gameController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by User on 2/3/2017.
 */
public class gamePanel1 extends JPanel{
    private gameEngine engine;
    private JButton profile;
    private JTextArea jTextArea;
    private carPanel carPanel;
    private profilePanel profilePanel;
    private imagePanel image;

    public void init(gameEngine engine, gameController controller, Player player){
        this.engine = engine;
        this.setLayout(new BorderLayout());
        this.addKeyListener(controller);
        profile = new JButton("My Profile");
        this.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        profile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profilePanel = new profilePanel(player);
                profilePanel.setVisible(true);
                profilePanel.requestFocus();
            }
        });
        this.add(profile, BorderLayout.PAGE_END);
        this.carPanel = new carPanel();
        this.add(carPanel, BorderLayout.CENTER);
        carPanel.init(controller, engine);
        carPanel.setFocusable(true);
        carPanel.requestFocus();
    }
}
