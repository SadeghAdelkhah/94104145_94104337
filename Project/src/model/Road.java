package model;

/**
 * Created by User on 12/6/2016.
 */
public class Road {
    public int linesNumber;
    public boolean isTwoWay;
    public int width;
    private Cross cross1;
    private Cross cross2;


    public Cross[] getCrosses() {
        Cross[] crosses = new Cross[2];
        crosses[0] = cross1;
        crosses[1] = cross2;
        return crosses;
    }

    public Road(Cross cross1, Cross cross2, boolean isTwoWay, int linesNumber){
        this.isTwoWay = isTwoWay;
        this.linesNumber = linesNumber;
        this.cross1 = cross1;
        this.cross2 = cross2;
    }
}