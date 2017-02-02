package model;

import java.util.ArrayList;

/**
 * Created by User on 12/6/2016.
 */
public class Cross {
    public double X;
    public double Y;
    public int ID;
    public int height;
    public int width;
    public ArrayList<Road> roads1;
    public ArrayList<Road> roads2;
    public ArrayList<Road> roads3;
    public ArrayList<Road> roads4;


    public Cross(){
        ArrayList<Road> roads1 = new ArrayList<>();
        ArrayList<Road> roads2 = new ArrayList<>();
        ArrayList<Road> roads3 = new ArrayList<>();
        ArrayList<Road> roads4 = new ArrayList<>();
    }

    public void addRoad1(Road road){
        roads1.add(road);
    }

    public void addRoad2(Road road){
        roads2.add(road);
    }

    public void addRoad3(Road road){
        roads3.add(road);
    }

    public void addRoad4(Road road){
        roads4.add(road);
    }

    public Road[] getRoads1(){
        return (Road[])this.roads1.toArray();
    }

    public Road[] getRoads2(){
        return (Road[])this.roads2.toArray();
    }

    public Road[] getRoads3(){
        return (Road[])this.roads3.toArray();
    }

    public Road[] getRoads4(){
        return (Road[])this.roads4.toArray();
    }

}
