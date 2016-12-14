package model;

import java.util.ArrayList;

/**
 * Created by User on 12/6/2016.
 */
public class Cross {
    public ArrayList<Avenue> avenues;


    public Cross(){
        ArrayList<Avenue> avenues = new ArrayList<>();
    }

    public void addAvenue(Avenue avenue){
        avenues.add(avenue);
    }

    public Avenue[] getAvenue(){
        return (Avenue[])this.avenues.toArray();
    }
}
