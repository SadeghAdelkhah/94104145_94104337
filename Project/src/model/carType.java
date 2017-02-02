package model;

/**
 * Created by User on 1/24/2017.
 */
public class carType extends Purchasable{
    public String name;
    public int fixingPrice;
    public int bodyPower;
    public int height;
    public int width;
    public int weight;
    public int brake;
    public Engine engine;
    public Wheel wheels;

    public carType(){}

    public carType(String name, int price, Wheel wheels, int brake, Engine engine,int fixingPrice, int bodyPower,int height, int width, int weight) {
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
