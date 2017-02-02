package model;

import java.util.ArrayList;

/**
 * Created by User on 12/6/2016.
 */
public class Player {
    public String name;
    public ArrayList<Racing> races;
    public ArrayList<Car> cars;
    public double money;
    private int reputation = 0;


    public Player(String name){
        this.name = name;
        races =  new ArrayList<>();
        cars = new ArrayList<>();
    }

    public boolean tune(int cost, int carId){
        if(money >= cost) {
            this.money -= cost;
            Car car = new Car(this);
            car = this.cars.get(carId);
            car.tune();
            cars.remove(carId);
            cars.add(carId, car);
            return true;
        }
        return false;
    }

    public boolean buyCar(Car car){
        if (car.price <= this.money){
            this.money -= car.price;
            cars.add(car);
            return true;
        }
        return false;
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
