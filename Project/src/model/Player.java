package model;

import java.util.ArrayList;

/**
 * Created by User on 12/6/2016.
 */
public class Player {
    private String name;
    private ArrayList<Car> cars;
    private int reputation = 0;


    public Player(String name){
        this.name = name;
        ArrayList<Car> cars = new ArrayList<>();
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
