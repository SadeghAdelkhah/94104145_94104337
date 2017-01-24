package model;
import java.math.*;
import java.util.Map;

/**
 * Created by User on 12/6/2016.
 */
public class Car extends carType{
    public Player owner;
    public int remainPower;
    public int fixCost;
    public double X = 0;
    public double Y = 0;
    public double speed;
    public double vectorAngle = 90;

    public Car(Player player){
        this.owner = player;
    }

    public int computeTuneCost(){
        fixCost = (this.bodyPower - this.remainPower)*fixingPrice;
        return fixCost;
    }

    public void tune(){
        this.remainPower = this.bodyPower;
    }

    public void move(){
        this.X += 10 * (Math.cos(Math.toRadians(vectorAngle)));
        this.Y += 10 * (Math.sin(Math.toRadians(vectorAngle)));
    }

    public void upgrade (Engine engine, Wheel wheel){
        this.engine = engine;
        this.wheels = wheel;
    }


}



