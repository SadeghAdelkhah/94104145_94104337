package model;
import java.math.*;
import java.util.Map;

/**
 * Created by User on 12/6/2016.
 */
public class Car extends carType{
    public Player owner;
    public double remainPower = this.bodyPower;
    public double fixCost;
    public double X1 = 0;
    public double Y1 = 0;
    public double X2 = this.width * Math.cos(Math.toRadians(this.vectorAngle - 90));
    public double Y2 = this.width * Math.sin(Math.toRadians(this.vectorAngle - 90));
    public double X3 = this.height * Math.cos(Math.toRadians(this.vectorAngle - 90));
    public double Y3 = this.height * Math.sin(Math.toRadians(this.vectorAngle - 90));
    public double X4 = this.X1;
    public double Y4 = 0;
    public double speed;
    public double vectorAngle = 90;

    public Car(Player player){
        this.owner = player;
    }

    public double computeTuneCost(){
        fixCost = (this.bodyPower - this.remainPower)*fixingPrice;
        return fixCost;
    }

    public void tune(){
        this.remainPower = this.bodyPower;
    }

    public void move(){
        this.X1 += 10 * (Math.cos(Math.toRadians(vectorAngle)));
        this.Y1 += 10 * (Math.sin(Math.toRadians(vectorAngle)));
        this.X2 = this.X1 + (this.width * Math.cos(Math.toRadians(this.vectorAngle - 90)));
        this.Y2 = this.Y1 + (this.width * Math.sin(Math.toRadians(this.vectorAngle - 90)));
        this.X3 = this.X2 + (this.height * Math.cos(Math.toRadians(this.vectorAngle - 90)));
        this.Y3 = this.Y2 + (this.height * Math.sin(Math.toRadians(this.vectorAngle - 90)));
        this.X4 = this.X1 + (this.height * Math.cos(Math.toRadians(this.vectorAngle - 90)));
        this.Y4 = this.Y1 + (this.height * Math.sin(Math.toRadians(this.vectorAngle - 90)));
    }

    public void upgrade (Engine engine, Wheel wheel){
        this.engine = engine;
        this.wheels = wheel;
    }


}



