package model;

import java.util.ArrayList;

/**
 * Created by User on 12/6/2016.
 */
public class Racing {
    public ArrayList<Cross> crosses;
    public ArrayList<Player> players;
    public ArrayList<Car> cars;
    public City city;
    public int pointer;
    public int playerNumbers;
    public int award;
    public int lapsNumber;
    public ArrayList<Player> playersRatings;
    public int timer;

    public Racing(Cross[] crosses, int award, City city){
        this.crosses = new ArrayList<>();
        for(int i=0; i<crosses.length; i++){
            this.crosses.add(crosses[i]);
        }
        this.award = award;
        players = new ArrayList<>();
        playersRatings = new ArrayList<>();
        cars = new ArrayList<>();
        this.city = city;
    }

    public void initializeRace(Player[] players, int lapsNumber, int[] carsIDs){
        for(int i=0; i<players.length; i++){
            this.players.add(players[i]);
        }
        for(int i=0; i<players.length; i++){
            cars.add(selectingCar(this.players.get(i), carsIDs[i]));
        }
        this.lapsNumber = lapsNumber;
        playerNumbers = players.length;
        pointer = crosses.get(0).ID;
        Road road = selectingStartRoad();
        if(road.startCross.X == road.endCross.X){
            if (road.startCross == crosses.get(0) && road.startCross.Y > road.endCross.Y){
                for(int i=0; i<cars.size(); i++){
                    cars.get(i).vectorAngle = 90;
                    cars.get(i).X = crosses.get(0).X + crosses.get(0).height/2;
                    if(i==0){
                        cars.get(0).Y = crosses.get(0).Y - 0.5;
                    }
                    else{
                        cars.get(i).Y = crosses.get(0).Y - cars.get(i-1).height - 0.5;
                    }
                }
            }
            else if (road.startCross == crosses.get(0) && road.startCross.Y < road.endCross.Y){
                for(int i=0; i<cars.size(); i++){
                    cars.get(i).vectorAngle = -90;
                    cars.get(i).X = crosses.get(0).X + crosses.get(0).height/2;
                    if(i==0){
                        cars.get(0).Y = crosses.get(0).Y + 0.5;
                    }
                    else{
                        cars.get(i).Y = crosses.get(0).Y + cars.get(i-1).height - 0.5;
                    }
                }
            }
            else if (road.endCross == crosses.get(0) && road.startCross.Y > road.endCross.Y){
                for(int i=0; i<cars.size(); i++){
                    cars.get(i).vectorAngle = 90;
                    cars.get(i).X = crosses.get(0).X + crosses.get(0).height/2;
                    if(i==0){
                        cars.get(0).Y = crosses.get(0).Y + 0.5;
                    }
                    else{
                        cars.get(i).Y = crosses.get(0).Y + cars.get(i-1).height - 0.5;
                    }
                }
            }
            else if (road.startCross == crosses.get(0) && road.startCross.Y > road.endCross.Y){
                for(int i=0; i<cars.size(); i++){
                    cars.get(i).vectorAngle = -90;
                    cars.get(i).X = crosses.get(0).X + crosses.get(0).height/2;
                    if(i==0){
                        cars.get(0).Y = crosses.get(0).Y - 0.5;
                    }
                    else{
                        cars.get(i).Y = crosses.get(0).Y - cars.get(i-1).height - 0.5;
                    }
                }
            }
        }
        else if(road.startCross.Y == road.endCross.Y){
            if (road.startCross == crosses.get(0) && road.startCross.X > road.endCross.X){
                for(int i=0; i<cars.size(); i++){
                    cars.get(i).vectorAngle = 0;
                    cars.get(i).Y = crosses.get(0).Y - crosses.get(0).width/2;
                    if(i==0){
                        cars.get(0).X = crosses.get(0).X - 0.5;
                    }
                    else{
                        cars.get(i).X = crosses.get(0).X - cars.get(i-1).height - 0.5;
                    }
                }
            }
            else if (road.startCross == crosses.get(0) && road.startCross.X < road.endCross.X){
                for(int i=0; i<cars.size(); i++){
                    cars.get(i).vectorAngle = 180;
                    cars.get(i).Y = crosses.get(0).Y - crosses.get(0).width/2;
                    if(i==0){
                        cars.get(0).X = crosses.get(0).X + crosses.get(0).height + 0.5;
                    }
                    else{
                        cars.get(i).X = crosses.get(0).X + crosses.get(0).height+ cars.get(i-1).height - 0.5;
                    }
                }
            }
            else if (road.endCross == crosses.get(0) && road.startCross.X > road.endCross.X){
                for(int i=0; i<cars.size(); i++){
                    cars.get(i).vectorAngle = 0;
                    cars.get(i).Y = crosses.get(0).Y - crosses.get(0).width/2;
                    if(i==0){
                        cars.get(0).X = crosses.get(0).X - 0.5;
                    }
                    else{
                        cars.get(i).X = crosses.get(0).X - cars.get(i-1).height - 0.5;
                    }
                }
            }
            else if (road.startCross == crosses.get(0) && road.startCross.Y > road.endCross.Y){
                for(int i=0; i<cars.size(); i++){
                    cars.get(i).vectorAngle = 180;
                    cars.get(i).X = crosses.get(0).X + crosses.get(0).height/2;
                    if(i==0){
                        cars.get(0).X = crosses.get(0).X + crosses.get(0).height + 0.5;
                    }
                    else{
                        cars.get(i).X = crosses.get(0).X + crosses.get(0).height+ cars.get(i-1).height - 0.5;
                    }
                }
            }
        }
    }

    private Road selectingStartRoad() {
        Cross cross1 = crosses.get(0);
        Cross cross2 = crosses.get(1);
        if ((cross1.getRoads1()[0].startCross == cross1 || cross1.getRoads1()[0].endCross == cross1) && (cross1.getRoads1()[0].startCross == cross2 || cross1.getRoads1()[0].endCross == cross2)){
            if(cross1.getRoads3()[0] != null)
                return cross1.getRoads3()[0];
            else if(cross1.getRoads2()[0] != null)
                return cross1.getRoads2()[0];
            else
                return cross1.getRoads4()[0];
        }
        else if ((cross1.getRoads2()[0].startCross == cross1 || cross1.getRoads2()[0].endCross == cross1) && (cross1.getRoads2()[0].startCross == cross2 || cross1.getRoads2()[0].endCross == cross2)){
            if(cross1.getRoads4()[0] != null)
                return cross1.getRoads4()[0];
            else if(cross1.getRoads3()[0] != null)
                return cross1.getRoads3()[0];
            else
                return cross1.getRoads1()[0];
        }
        else if ((cross1.getRoads3()[0].startCross == cross1 || cross1.getRoads3()[0].endCross == cross1) && (cross1.getRoads3()[0].startCross == cross2 || cross1.getRoads3()[0].endCross == cross2)){
            if(cross1.getRoads1()[0] != null)
                return cross1.getRoads1()[0];
            else if(cross1.getRoads2()[0] != null)
                return cross1.getRoads2()[0];
            else
                return cross1.getRoads4()[0];
        }
        else if ((cross1.getRoads4()[0].startCross == cross1 || cross1.getRoads4()[0].endCross == cross1) && (cross1.getRoads4()[0].startCross == cross2 || cross1.getRoads4()[0].endCross == cross2)){
            if(cross1.getRoads2()[0] != null)
                return cross1.getRoads2()[0];
            else if(cross1.getRoads3()[0] != null)
                return cross1.getRoads3()[0];
            else
                return cross1.getRoads1()[0];
        }
        return null;
    }

    private Car selectingCar(Player player, int carID) {
        return player.cars.get(carID);
    }

    public void startRace(){
        for(int i =0 ;i<playerNumbers; i++){
            Player player1 = players.get(i);
            player1.races.add(this);
            players.remove(i);
            players.add(i, player1);
        }
    }
    public void isFinished(){}
    public ArrayList<Player> isAccident(){
        ArrayList<Player> players1 = new ArrayList<>();
        for(int i=0; i<cars.size(); i++){
            Road road = locatingCar(cars.get(i));
            if (road.isHorizontal){
                if(cars.get(i).Y >= road.y1 || )
            }
        }
        return null;
    }

    private Road locatingCar(Car car) {
        for(int i=0; i< this.city.roads.size(); i++){
            if(car.X> this.city.roads.get(i).x1 && car.X < this.city.roads.get(i).x2 && car.Y < this.city.roads.get(i).y4 && this.city.roads.get(i).y1 < car.Y){
                return this.city.roads.get(i);
            }
        }
        return null;
    }

    public void accident(Car car1, Car car2){

    }
    public void accident(Car car){}
    public void Rate(){}
    public void damage(Car car1, Car car2){}
    public void damage(Car car){}
}

