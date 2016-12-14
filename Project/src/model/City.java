package model;

import java.util.ArrayList;

/**
 * Created by User on 12/6/2016.
 */

public class City {
    private String name;
    private ArrayList<Avenue> avenues;
    public Cross[] crosses;

    public City(String name){
        this.name = name;
        ArrayList<Avenue> avenues = new ArrayList<>();

    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public Avenue[] getAvenues(){
        return (Avenue[])this.avenues.toArray();
    }

    public void addAvenue(Avenue avenue){
        avenues.add(avenue);
    }
}
