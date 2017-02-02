package model;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by User on 1/24/2017.
 */
public class copyLines {
    public static void main(String[] args) throws IOException{
        Test1 test1 = new Test1();
        Test2 test2 = new Test2();
        Test2 test3 = new Test2();
        test1.strings.add(test2);
        test1.strings.add(test3);
//        Test2 test4 = test2;
        test2.value++;

        System.out.println(test1.strings.get(0));
//        Integer[] integers = new Integer[10];
//        for(int i=0; i< 10; i++) {
//            integers[i] = new Integer(1);
//        }
//        integers = test1.getStrings();
//        integers[0]++;
        System.out.println(test1.strings.get(0).value);

//        BufferedReader inputStream = null;
//        PrintWriter outputStream = null;
//        try{
//            inputStream = new BufferedReader(new FileReader("xanadu.txt"));
//            outputStream = new PrintWriter(new FileWriter("characteroutput.txt"));
//            String l;
//            while((l = inputStream.readLine()) != null){
//                while ((l = inputStream.readLine()) != null){
//                    System.out.println(l);
//                }
//            }
//        } finally {
//            if(inputStream != null){
//                inputStream.close();
//            }
//            if (outputStream != null){
//                outputStream.close();
//            }
//        }
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