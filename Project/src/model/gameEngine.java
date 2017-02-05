package model;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by User on 1/24/2017.
 */
public class gameEngine {
    public City city;
    public ArrayList<carType> carTypes;
    public ArrayList<Engine> engines;
    public ArrayList<Wheel> wheels;
    public ArrayList<Player> players;
    public ArrayList<Racing> races;

    public void addCarTypes(carType carType) {
        this.carTypes.add(carType);
    }

    public RandomAccessFile getter = null;
    public PrintWriter outputStream = null;

    public gameEngine(){
        carTypes = new ArrayList<>();
        wheels = new ArrayList<>();
        engines = new ArrayList<>();
        players = new ArrayList<>();
    }

    public void makeCarTypeFromFile(String name, String carTypeAddress) throws IOException {
        getter = new RandomAccessFile(carTypeAddress, "rw");
        String l = getter.readLine();
        int price = 0;
        double height=0.0, width=0.0, bodyPower=0.0, fixingPrice=0, brake=0, accelerate=0, maxSpeed=0, effectiveForceOfFarman=0, StekakAmoodBarMasir=0, weight = 0;
        while(l.contains("-") == false){
            if (l.contains(";")) {
                l = getter.readLine();
            }
            price = Integer.parseInt(l);
            System.out.println(l);
            height = Double.parseDouble(l = getter.readLine());
            width = Double.parseDouble(l = getter.readLine());
            weight = Double.parseDouble(l = getter.readLine());
            bodyPower = Double.parseDouble(l = getter.readLine());
            fixingPrice = Double.parseDouble(l = getter.readLine());
            brake = Double.parseDouble(l = getter.readLine());
            accelerate = Double.parseDouble(l = getter.readLine());
            maxSpeed = Double.parseDouble(l = getter.readLine());
            effectiveForceOfFarman = Double.parseDouble(l = getter.readLine());
            StekakAmoodBarMasir = Double.parseDouble(l = getter.readLine());
            Engine engine = new Engine(accelerate, maxSpeed);
            engines.add(engine);
            Wheel wheel = new Wheel(StekakAmoodBarMasir, effectiveForceOfFarman);
            wheels.add(wheel);
            carType carType = new carType(name, price, wheel, brake, engine, fixingPrice, bodyPower, height, width, weight);
            this.addCarTypes(carType);
            l = getter.readLine();
            System.out.println(l);
        }
    }

    public void makeEnginesFromFile(String EngineAddress) throws IOException {
        getter = new RandomAccessFile(EngineAddress, "rw");
        String l;
        int accelerate=0, maxSpeed=0;
        while((l = getter.readLine()) != null){
            while (l != ";"){
                accelerate = Integer.parseInt(l);
                maxSpeed = Integer.parseInt(l = getter.readLine());
                getter.readLine();
            }
            Engine engine = new Engine(accelerate, maxSpeed);
            engines.add(engine);
        }
    }

    public void makeWheelsFromFile(String WheelsAddress) throws IOException {
        getter = new RandomAccessFile(WheelsAddress, "rw");
        String l;
        int effectiveForceOfFarman=0, StekakAmoodBarMasir=0;
        while((l = getter.readLine()) != null){
            while (l != ";"){
                effectiveForceOfFarman = Integer.parseInt(l);
                StekakAmoodBarMasir = Integer.parseInt(l = getter.readLine());
                getter.readLine();
            }
            Wheel wheel = new Wheel(StekakAmoodBarMasir, effectiveForceOfFarman);
            wheels.add(wheel);
        }
    }

    public void makeCityFromInput(String name, ArrayList<Road> roads, ArrayList<Cross> crosses){
        city = new City(name);
        for(Road road:roads){
            city.addRoad(road);
        }
        for(Cross cross:crosses){
            city.addCross(cross);
        }
    }

    public void makeCityFromFile(String name,String addressRoads, String addressCrosses)throws IOException{
        city = new City(name);
        getter = new RandomAccessFile(addressRoads, "rw");
        String l;
        while((l = getter.readLine()) != null){
            Cross cross = new Cross();
            while (l != ";"){
                cross.ID = Integer.parseInt(l);
                cross.X = Integer.parseInt(l = getter.readLine());
                cross.Y = Integer.parseInt(l = getter.readLine());
                getter.readLine();
            }
            city.addCross(cross);
        }
        getter.close();
        getter = new RandomAccessFile(addressCrosses, "rw");
        while((l = getter.readLine()) != null){
            int startCrossID = 0;
            int endCrossID = 0;
            boolean isTwoWay = false;
            int linesNumber = 0;
            int startCrossDirection = 0;
            int endCrossDirection = 0;
            while (l != ";"){
                startCrossID = Integer.parseInt(l);
                endCrossID = Integer.parseInt(l = getter.readLine());
                isTwoWay = getter.readBoolean();
                linesNumber = Integer.parseInt(l = getter.readLine());
                startCrossDirection = Integer.parseInt(l = getter.readLine());
                endCrossDirection = Integer.parseInt(l = getter.readLine());
                getter.readLine();
            }
            Road road = new Road(city.getCrosses()[startCrossID], city.getCrosses()[endCrossID], isTwoWay, linesNumber, startCrossDirection, endCrossDirection);
            for (int i = 0; i < city.getCrosses().length; i++){
                if(city.getCrosses()[i].ID == startCrossID){
                    switch (startCrossDirection){
                        case 1:
                            city.getCrosses()[i].addRoad1(road);
                            break;
                        case 2:
                            city.getCrosses()[i].addRoad2(road);
                            break;
                        case 3:
                            city.getCrosses()[i].addRoad3(road);
                            break;
                        case 4:
                            city.getCrosses()[i].addRoad4(road);
                            break;
                    }
                }
            }
            for (int i = 0; i < city.getCrosses().length; i++){
                if(city.getCrosses()[i].ID == startCrossID){
                    switch (startCrossDirection){
                        case 1:
                            city.getCrosses()[i].addRoad1(road);
                            break;
                        case 2:
                            city.getCrosses()[i].addRoad2(road);
                            break;
                        case 3:
                            city.getCrosses()[i].addRoad3(road);
                            break;
                        case 4:
                            city.getCrosses()[i].addRoad4(road);
                            break;
                    }
                }
            }
            city.addRoad(road);
        }
        int y =0;
        int x =0;
        int d =0;
        for(int i=0; i < city.getCrosses().length; i++){
            int height1 = 0;
            int height2 = 0;
            for (int j=0; j<city.getCrosses()[i].getRoads1().length; j++){
                height1 += city.getCrosses()[i].getRoads1()[j].width;
            }
            for (int j=0; j<city.getCrosses()[i].getRoads3().length; j++){
                height2 += city.getCrosses()[i].getRoads3()[j].width;
            }
            if (height1 > height2) {
                city.getCrosses()[i].height = height1;
            }
            else {
                city.getCrosses()[i].height = height2;
            }
            int width1 = 0;
            int width2 = 0;
            for (int j=0; j<city.getCrosses()[i].getRoads4().length; j++){
                width1 += city.getCrosses()[i].getRoads1()[j].width;
            }
            for (int j=0; j<city.getCrosses()[i].getRoads2().length; j++){
                width2 += city.getCrosses()[i].getRoads3()[j].width;
            }
            if (width1 > width2) {
                city.getCrosses()[i].width = width1;
            }
            else {
                city.getCrosses()[i].width = width2;
            }
        }
        for(int i=0; i<this.city.getRoads().size(); i++){
            if(this.city.roads.get(i).startCrossDirection == 1) {
                int xAdd = 0;
                if(this.city.roads.get(i).startCross.getRoads1()[0] != this.city.roads.get(i)){
                    xAdd += this.city.roads.get(i).startCross.getRoads1()[0].width;
                }
                this.city.roads.get(i).x4 = this.city.roads.get(i).startCross.X + xAdd;
                this.city.roads.get(i).y4 = this.city.roads.get(i).startCross.Y;
                this.city.roads.get(i).x3 = this.city.roads.get(i).startCross.X + xAdd + this.city.roads.get(i).width;
                this.city.roads.get(i).y3 = this.city.roads.get(i).startCross.Y;
                this.city.roads.get(i).x2 = this.city.roads.get(i).x3;
                this.city.roads.get(i).x1 = this.city.roads.get(i).x4;
                this.city.roads.get(i).y1 = this.city.roads.get(i).endCross.Y - this.city.roads.get(i).endCross.width;
                this.city.roads.get(i).y2 = this.city.roads.get(i).y1;
            }
            else if(this.city.roads.get(i).startCrossDirection == 2){
                int yAdd = 0;
                if(this.city.roads.get(i).startCross.getRoads2()[0] != this.city.roads.get(i)){
                    yAdd -= this.city.roads.get(i).startCross.getRoads2()[0].width;
                }
                this.city.roads.get(i).x4 = this.city.roads.get(i).startCross.X + this.city.roads.get(i).startCross.height;
                this.city.roads.get(i).y4 = this.city.roads.get(i).startCross.Y + yAdd;
                this.city.roads.get(i).x3 = this.city.roads.get(i).endCross.X;
                this.city.roads.get(i).y3 = this.city.roads.get(i).startCross.Y + yAdd;
                this.city.roads.get(i).x2 = this.city.roads.get(i).endCross.X;
                this.city.roads.get(i).x1 = this.city.roads.get(i).startCross.X + this.city.roads.get(i).startCross.height;
                this.city.roads.get(i).y1 = this.city.roads.get(i).startCross.Y + yAdd;
                this.city.roads.get(i).y2 = this.city.roads.get(i).y1;
            }
            else if(this.city.roads.get(i).startCrossDirection == 3){
                int xAdd = 0;
                if(this.city.roads.get(i).startCross.getRoads3()[0] != this.city.roads.get(i)){
                    xAdd -= this.city.roads.get(i).startCross.getRoads3()[0].width;
                }
                this.city.roads.get(i).x1 = this.city.roads.get(i).startCross.X + this.city.roads.get(i).startCross.height - this.city.roads.get(i).width + xAdd;
                this.city.roads.get(i).y1 = this.city.roads.get(i).startCross.Y - this.city.roads.get(i).startCross.width;
                this.city.roads.get(i).x2 = this.city.roads.get(i).startCross.X + this.city.roads.get(i).startCross.height + xAdd;
                this.city.roads.get(i).y2 = this.city.roads.get(i).y1;
                this.city.roads.get(i).x3 = this.city.roads.get(i).x2;
                this.city.roads.get(i).y3 = this.city.roads.get(i).endCross.Y;
                this.city.roads.get(i).x4 = this.city.roads.get(i).x1;
                this.city.roads.get(i).y4 = this.city.roads.get(i).y3;
            }
            else if(this.city.roads.get(i).startCrossDirection == 4){
                int yAdd = 0;
                if(this.city.roads.get(i).startCross.getRoads4()[0] != this.city.roads.get(i)){
                    yAdd += this.city.roads.get(i).startCross.getRoads4()[0].width;
                }
                this.city.roads.get(i).x1 = this.city.roads.get(i).endCross.X + this.city.roads.get(i).endCross.height;
                this.city.roads.get(i).y1 = this.city.roads.get(i).endCross.Y - this.city.roads.get(i).startCross.width + yAdd + this.city.roads.get(i).width;
                this.city.roads.get(i).x2 = this.city.roads.get(i).startCross.X;
                this.city.roads.get(i).y2 = this.city.roads.get(i).y1;
                this.city.roads.get(i).x3 = this.city.roads.get(i).x2;
                this.city.roads.get(i).y3 = this.city.roads.get(i).endCross.Y - this.city.roads.get(i).startCross.width + yAdd;
                this.city.roads.get(i).x4 = this.city.roads.get(i).x1;
                this.city.roads.get(i).y4 = this.city.roads.get(i).y3;
            }
        }
    }


    public void makePlayer(String name){
        Player player = new Player(name);
        players.add(player);
    }

    public boolean buyCarForPlayer(carType carType, int playerID){
        carType car = new Car(players.get(playerID));
        Player player = players.get(playerID - 1);
        if(player.buyCar((Car)car)){
            players.remove(playerID - 1);
            players.add(playerID - 1, player);
            return true;
        }
        else
            return false;
    }


    public void makeRace(int[] crossIDs, int award, int givingReputation){
        int i = crossIDs.length;
        Cross[] crosses = new Cross[i];
        for (int j=0; j<i; j++){
            crosses[j] = this.city.crosses.get(crossIDs[i]);
        }
        Racing race = new Racing(crosses, award, this.city, givingReputation);
        this.races.add(race);
    }

    public void startRace(Racing race){
        race.startRace();
    }

    public void raceUpdate(Racing race) throws GameOverException{
        for (int i=0 ; i< race.cars.size(); i++){
            race.cars.get(i).move();
        }
        if (race.isFinished()){
            throw new GameOverException();
        }
    }
}


