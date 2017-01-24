package model;

/**
 * Created by User on 1/24/2017.
 */
public class carType extends Purchasable{
    public int fixingPrice;
    public int bodyPower;
    public int height;
    public int width;
    public int weight;
    public Engine engine;
    public int brake;
    public Wheel wheels;

    public carType(){}

    public carType(int price, Wheel wheels, int brake, Engine engine,int fixingPrice, int bodyPower,int height, int width, int weight) {
        this.price = price;
        this.height = height;
        this.width = width;
        this.weight = weight;
        this.bodyPower = bodyPower;
        this.fixingPrice = fixingPrice;
        this.engine = engine;
        this.brake = brake;
        this.wheels = wheels;
    }
}
