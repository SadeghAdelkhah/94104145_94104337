package model;

/**
 * Created by User on 12/6/2016.
 */
public class Road {
    public int linesNumber;
    public boolean isTwoWay;
    public int width;
    public Cross startCross;
    public Cross endCross;
    public int startCrossDirection;
    public int endCrossDirection;
    public double x1;
    public double y1;
    public double x2;
    public double y2;
    public double x3;
    public double y3;
    public double x4;
    public double y4;
    public boolean isHorizontal;


    public Cross[] getCrosses() {
        Cross[] crosses = new Cross[2];
        crosses[0] = startCross;
        crosses[1] = endCross;
        return crosses;
    }

    public Road(){

    }

    public Road(Cross startCross, Cross endCross, boolean isTwoWay, int linesNumber, int startCrossDirection, int endCrossDirection){
        this.isTwoWay = isTwoWay;
        this.linesNumber = linesNumber;
        this.startCross = startCross;
        this.endCross = endCross;
        this.width = linesNumber *3;
        this.startCrossDirection = startCrossDirection;
        this.endCrossDirection = endCrossDirection;
        if(this.startCrossDirection == 1 || this.startCrossDirection == 3){
            this.isHorizontal = true;
        }
        else if(this.startCrossDirection == 1 || this.startCrossDirection == 3){
            this.isHorizontal = false;
        }


    }
}