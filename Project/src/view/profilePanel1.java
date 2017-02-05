package view;

import javafx.embed.swing.JFXPanel;
import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by User on 2/4/2017.
 */
public class profilePanel1 extends JPanel{
    public static final int width = 300;
    public static final int height = 300;
    public JLabel nameLabel;
    public JLabel moneyLabel;
    public JLabel reputationLabel;
    public JButton confirm;
    public JTextArea name1;
    public JLabel money;
    public JLabel reputation;
    public Player player;


    public profilePanel1(Player player){
        this.player = player;
        nameLabel = new JLabel("Name: " + player.name);
        moneyLabel = new JLabel("Remain money: " + player.money);
        nameLabel = new JLabel("Reputation: " + player.getReputation());
        confirm = new JButton("Confirm");
        name1 = new JTextArea(player.name);
        money = new JLabel(Double.toString(player.money));
        reputation = new JLabel(Double.toString(player.getReputation()));
    }

    public void init(){
        setFocusable(true);
        requestFocus();
        setLayout(null);
        setPreferredSize(new Dimension(width, height));
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.name = name1.getText();
                setVisible(false);
            }
        });
    }
}
