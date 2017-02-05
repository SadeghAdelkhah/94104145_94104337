package controller;

import model.GameOverException;
import model.gameEngine;
import view.carPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by User on 2/3/2017.
 */
public class gameController implements KeyListener {

    private gameEngine engine;
    private carPanel panel;
    private Boolean running= false;
    private int FPS = 30;
    private Boolean downKey;

    public Boolean getRunning() {
        return running;
    }

    public void setRunning(Boolean running) {
        this.running = running;
    }

    public void run() {
        Thread gameLoop = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running){
                    try {
                        engine.raceUpdate(engine.races.get(0));
                        panel.repaint();
                        try{
                            Thread.sleep(1000 / FPS);
                        }
                        catch (InterruptedException e){
                        }
                    }
                    catch (GameOverException e){
                        running = false;
                    }
                }
            }
        });
    }



    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if(engine.races.get(0).cars.get(0).vectorAngle <= 270 && engine.races.get(0).cars.get(0).vectorAngle >= 180)
                    engine.races.get(0).cars.get(0).vectorAngle -= 1;
                else if (engine.races.get(0).cars.get(0).vectorAngle < 180 && engine.races.get(0).cars.get(0).vectorAngle >= 90)
                    engine.races.get(0).cars.get(0).vectorAngle += 1;
                else
                    engine.races.get(0).cars.get(0).speed += engine.races.get(0).cars.get(0).engine.accelerate;
                break;
            case KeyEvent.VK_RIGHT:
                if(engine.races.get(0).cars.get(0).vectorAngle <= 270 && engine.races.get(0).cars.get(0).vectorAngle >= 0)
                    engine.races.get(0).cars.get(0).vectorAngle -= 1;
                else if (engine.races.get(0).cars.get(0).vectorAngle > 270 && engine.races.get(0).cars.get(0).vectorAngle < 360) {
                    engine.races.get(0).cars.get(0).vectorAngle += 1;
                    if(engine.races.get(0).cars.get(0).vectorAngle >= 360){
                        engine.races.get(0).cars.get(0).vectorAngle = 0;
                    }
                }
                else
                    engine.races.get(0).cars.get(0).speed += engine.races.get(0).cars.get(0).engine.accelerate;
                break;
            case KeyEvent.VK_DOWN:
                if(engine.races.get(0).cars.get(0).vectorAngle <= 270 && engine.races.get(0).cars.get(0).vectorAngle > 0)
                    engine.races.get(0).cars.get(0).vectorAngle += 1;
                else if (engine.races.get(0).cars.get(0).vectorAngle < 360 && engine.races.get(0).cars.get(0).vectorAngle >= 270)
                    engine.races.get(0).cars.get(0).vectorAngle -= 1;
                else
                    engine.races.get(0).cars.get(0).speed += engine.races.get(0).cars.get(0).engine.accelerate;
                break;
            case KeyEvent.VK_UP:
                if(engine.races.get(0).cars.get(0).vectorAngle <= 270 && engine.races.get(0).cars.get(0).vectorAngle >= 90)
                engine.races.get(0).cars.get(0).vectorAngle -= 1;
                else if (engine.races.get(0).cars.get(0).vectorAngle > 0 && engine.races.get(0).cars.get(0).vectorAngle >= 270) {
                    engine.races.get(0).cars.get(0).vectorAngle += 1;
                    if(engine.races.get(0).cars.get(0).vectorAngle >= 360){
                        engine.races.get(0).cars.get(0).vectorAngle = 0;
                }
            }
            else
                engine.races.get(0).cars.get(0).speed += engine.races.get(0).cars.get(0).engine.accelerate;
                break;

        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
