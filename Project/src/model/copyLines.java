package model;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by User on 1/24/2017.
 */
public class copyLines {
    public static void main(String[] args) throws IOException{
        System.out.println(Math.toDegrees(Math.asin(0.5)));
    }
}

class Test1{
    public ArrayList<Test2> strings;

    public Test1(){
        strings = new ArrayList<>();
    }

    public Integer[] getStrings(){
        return (Integer[])this.strings.toArray();
    }
}

class Test2{
    public int value = 0;
}