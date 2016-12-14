package model;

/**
 * Created by User on 12/6/2016.
 */
public class Car extends Purchasable implements properties{
    public int width;
    public int length;
    public int mass;
    public int Power_Body;
    public int fixCost;
    public int Cost;
    public Engine engine;
    public Brake brake;
    public Wheels wheels;

}


class Engine{
    public int power;
    public int accelerate;
    public int Max_Speed;
}


class Wheels{
    public int f_p;
    public int EPS;
}


class Brake{
    int accelerator;
}