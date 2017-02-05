package model;

/**
 * Created by User on 1/24/2017.
 */
public class carType extends Purchasable{
    public String name;
    public double fixingPrice;
    public double bodyPower;
    public double height;
    public double width;
    public double weight;
    public double brake;
    public Engine engine;
    public Wheel wheels;

    public carType(){}

    public carType(String name, int price, Wheel wheels, double brake, Engine engine,double fixingPrice, double bodyPower,double height, double width, double weight) {
        this.price = price;
        this.height = height;
        this.width = width;
        this.weight = weight;
        this.bodyPower = bodyPower;
        this.fixingPrice = fixingPrice;
        this.brake = brake;
        this.engine = engine;
        this.wheels = wheels;
    }
}
