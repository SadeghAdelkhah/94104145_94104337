package model;

import java.util.ArrayList;

/**
 * Created by User on 12/6/2016.
 */
public class Cross {
    public int X;
    public int Y;
    public int ID;
    public int height;
    public int width;
    public ArrayList<Road> roads;


    public Cross(){
        ArrayList<Road> roads = new ArrayList<>();
    }

    public void addRoad(Road road){
        roads.add(road);
    }

    public Road[] getRoads(){
        return (Road[])this.roads.toArray();
    }
}
