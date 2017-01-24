package model;

import java.util.ArrayList;

/**
 * Created by User on 12/6/2016.
 */

public class City {
    private String name;
    private ArrayList<Cross> crosses;
    private ArrayList<Road> roads;

    public ArrayList<Road> getRoads() {
        return roads;
    }

    public void addRoad(Road road, int end, int start) {
        crosses.get(end).addRoad(road);
        crosses.get(start).addRoad(road);
        roads.add(road);
    }


    public City(String name){
        this.name = name;
        ArrayList<Cross> crosses = new ArrayList<>();
        ArrayList<Road> roads = new ArrayList<>();

    }

    public Cross[] getCrosses(){
        return (Cross[])this.crosses.toArray();
    }

    public void addCross(Cross cross){
        crosses.add(cross);
    }
}
