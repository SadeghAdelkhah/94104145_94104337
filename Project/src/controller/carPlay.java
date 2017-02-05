package controller;

import javax.swing.*;
import model.gameEngine;
import controller.gameController;
import view.carPanel;

import java.io.IOException;


/**
 * Created by User on 2/3/2017.
 */
public class carPlay {
    public static void main(String[] args) throws IOException {
        String s = JOptionPane.showInputDialog("Please enter your Creation files");
        JFrame frame = new JFrame("Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        gameEngine engine = new gameEngine();
        engine.makeCarTypeFromFile("Sajdegh", "Make/Cars.txt");
//        engine.makeCityFromFile("Utopia", "Make/Roads", "Make/Crosses");
//        System.out.println(engine.carTypes.get(0).brake);
        carPanel panel = new carPanel();
        gameController controller = new gameController();
        panel.init(controller, engine);
//        controller.init(engine, panel);
        frame.setContentPane(panel);
//        controller.run();

        frame.pack();
        frame.setLocationRelativeTo(null);
    }
}
