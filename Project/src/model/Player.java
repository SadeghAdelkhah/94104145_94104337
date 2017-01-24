package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by User on 12/6/2016.
 */
public class Player {
    private String name;
    private ArrayList<Racing> races;
    private ArrayList<Car> cars;
    public double money;
    private int reputation = 0;


    public Player(String name){
        this.name = name;
        races =  new ArrayList<>();
        cars = new ArrayList<>();
    }

    public boolean tune(int cost, int id){
        if(money >= cost) {
            this.money -= cost;
            Car car = new Car(this);
            car = this.cars.get(id);
            car.tune();
            cars.remove(id);
            cars.add(id, car);
            return true;
        }
        return false;
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public Car[] getCars(){
        return (Car[])this.cars.toArray();
    }

    public int getReputation() {
        return reputation;
    }

    public void addReputation(int reputation) {
        this.reputation += reputation;
    }
}
