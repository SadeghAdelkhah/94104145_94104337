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
    public int requiredReputation;
    public int givingReputation;

    public Racing(Cross[] crosses, int award, City city, int requiredReputation){
        this.crosses = new ArrayList<>();
        for(int i=0; i<crosses.length; i++){
            this.crosses.add(crosses[i]);
        }
        this.award = award;
        players = new ArrayList<>();
        playersRatings = new ArrayList<>();
        cars = new ArrayList<>();
        this.city = city;
        this.requiredReputation = requiredReputation;
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
                    cars.get(i).X1 = crosses.get(0).X + crosses.get(0).height/2;
                    if(i==0){
                        cars.get(0).Y1 = crosses.get(0).Y - 0.5;
                    }
                    else{
                        cars.get(i).Y1 = crosses.get(0).Y - cars.get(i-1).height - 0.5;
                    }
                }
            }
            else if (road.startCross == crosses.get(0) && road.startCross.Y < road.endCross.Y){
                for(int i=0; i<cars.size(); i++){
                    cars.get(i).vectorAngle = -90;
                    cars.get(i).X1 = crosses.get(0).X + crosses.get(0).height/2;
                    if(i==0){
                        cars.get(0).Y1 = crosses.get(0).Y + 0.5;
                    }
                    else{
                        cars.get(i).Y1 = crosses.get(0).Y + cars.get(i-1).height - 0.5;
                    }
                }
            }
            else if (road.endCross == crosses.get(0) && road.startCross.Y > road.endCross.Y){
                for(int i=0; i<cars.size(); i++){
                    cars.get(i).vectorAngle = 90;
                    cars.get(i).X1 = crosses.get(0).X + crosses.get(0).height/2;
                    if(i==0){
                        cars.get(0).Y1 = crosses.get(0).Y + 0.5;
                    }
                    else{
                        cars.get(i).Y1 = crosses.get(0).Y + cars.get(i-1).height - 0.5;
                    }
                }
            }
            else if (road.startCross == crosses.get(0) && road.startCross.Y > road.endCross.Y){
                for(int i=0; i<cars.size(); i++){
                    cars.get(i).vectorAngle = -90;
                    cars.get(i).X1 = crosses.get(0).X + crosses.get(0).height/2;
                    if(i==0){
                        cars.get(0).Y1 = crosses.get(0).Y - 0.5;
                    }
                    else{
                        cars.get(i).Y1 = crosses.get(0).Y - cars.get(i-1).height - 0.5;
                    }
                }
            }
        }
        else if(road.startCross.Y == road.endCross.Y){
            if (road.startCross == crosses.get(0) && road.startCross.X > road.endCross.X){
                for(int i=0; i<cars.size(); i++){
                    cars.get(i).vectorAngle = 0;
                    cars.get(i).Y1 = crosses.get(0).Y - crosses.get(0).width/2;
                    if(i==0){
                        cars.get(0).X1 = crosses.get(0).X - 0.5;
                    }
                    else{
                        cars.get(i).X1 = crosses.get(0).X - cars.get(i-1).height - 0.5;
                    }
                }
            }
            else if (road.startCross == crosses.get(0) && road.startCross.X < road.endCross.X){
                for(int i=0; i<cars.size(); i++){
                    cars.get(i).vectorAngle = 180;
                    cars.get(i).Y1 = crosses.get(0).Y - crosses.get(0).width/2;
                    if(i==0){
                        cars.get(0).X1 = crosses.get(0).X + crosses.get(0).height + 0.5;
                    }
                    else{
                        cars.get(i).X1 = crosses.get(0).X + crosses.get(0).height+ cars.get(i-1).height - 0.5;
                    }
                }
            }
            else if (road.endCross == crosses.get(0) && road.startCross.X > road.endCross.X){
                for(int i=0; i<cars.size(); i++){
                    cars.get(i).vectorAngle = 0;
                    cars.get(i).Y1 = crosses.get(0).Y - crosses.get(0).width/2;
                    if(i==0){
                        cars.get(0).X1 = crosses.get(0).X - 0.5;
                    }
                    else{
                        cars.get(i).X1 = crosses.get(0).X - cars.get(i-1).height - 0.5;
                    }
                }
            }
            else if (road.startCross == crosses.get(0) && road.startCross.Y > road.endCross.Y){
                for(int i=0; i<cars.size(); i++){
                    cars.get(i).vectorAngle = 180;
                    cars.get(i).X1 = crosses.get(0).X + crosses.get(0).height/2;
                    if(i==0){
                        cars.get(0).X1 = crosses.get(0).X + crosses.get(0).height + 0.5;
                    }
                    else{
                        cars.get(i).X1 = crosses.get(0).X + crosses.get(0).height+ cars.get(i-1).height - 0.5;
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
    public boolean isFinished(){
        int carsPassedTheEndLine = 0;
        for(int j=0; j<this.city.roads.size(); j++) {
            for (int i=0; i<cars.size(); i++){
                if ((this.city.roads.get(j).endCross == this.crosses.get(this.crosses.size() - 1) && this.city.roads.get(j).startCross == this.crosses.get(this.crosses.size() - 2)) || (this.city.roads.get(j).startCross == this.crosses.get(this.crosses.size() - 1) && this.city.roads.get(j).endCross == this.crosses.get(this.crosses.size() - 2))){
                    if ((this.city.roads.get(j).startCrossDirection == 1 && this.city.roads.get(j).startCross == this.city.crosses.get(this.city.crosses.size() - 1)) || (this.city.roads.get(j).endCrossDirection == 1 && this.city.roads.get(j).endCross == this.city.crosses.get(this.city.crosses.size() - 1))){
                        if(cars.get(i).Y4 <= crosses.get(crosses.size() - 1).Y){
                            carsPassedTheEndLine ++;
                        }
                    }
                    else if ((this.city.roads.get(j).startCrossDirection == 2 && this.city.roads.get(j).startCross == this.city.crosses.get(this.city.crosses.size() - 1)) || (this.city.roads.get(j).endCrossDirection == 2 && this.city.roads.get(j).endCross == this.city.crosses.get(this.city.crosses.size() - 1))){
                        if(cars.get(i).X3 <= crosses.get(crosses.size() - 1).X + crosses.get(crosses.size() - 1).height){
                            carsPassedTheEndLine ++;
                        }
                    }if ((this.city.roads.get(j).startCrossDirection == 3 && this.city.roads.get(j).startCross == this.city.crosses.get(this.city.crosses.size() - 1)) || (this.city.roads.get(j).endCrossDirection == 3 && this.city.roads.get(j).endCross == this.city.crosses.get(this.city.crosses.size() - 1))){
                        if(cars.get(i).Y4 >= crosses.get(crosses.size() - 1).Y - crosses.get(crosses.size() -1).width){
                            carsPassedTheEndLine ++;
                        }
                    }if ((this.city.roads.get(j).startCrossDirection == 4 && this.city.roads.get(j).startCross == this.city.crosses.get(this.city.crosses.size() - 1)) || (this.city.roads.get(j).endCrossDirection == 4 && this.city.roads.get(j).endCross == this.city.crosses.get(this.city.crosses.size() - 1))){
                        if(cars.get(i).X4 >= crosses.get(crosses.size() - 1).X){
                            carsPassedTheEndLine ++;
                        }
                    }
                }
            }
        }
        if (carsPassedTheEndLine == cars.size()){
            return true;
        }
        return false;
    }
    public ArrayList<Car> isAccident(){
        ArrayList<Car> cars1 = new ArrayList<>();
        for(int i=0; i<cars.size(); i++){
            Road road = locatingCar(cars.get(i));
            if (road.isHorizontal){
                if(cars.get(i).Y1 >= road.y1 || cars.get(i).Y2 >= road.y1 || cars.get(i).Y1 <= road.y4 || cars.get(i).Y2 <= road.y4){
                    cars1.add(cars.get(i));
                    return cars1;
                }
            }
        }
        for (int i = 0; i < cars.size(); i++) {
            for (int j = 0; j < cars.size(); j++) {
                int x1 = cars.get(i).X1;
                int x2 = cars.get(i).X2;
                int y1 = cars.get(i).Y1;
                int y2 = cars.get(i).Y2;
                int x12 = cars.get(j).X1;
                int x22 = cars.get(j).X2;
                int y12 = cars.get(j).Y1;
                int y22 = cars.get(j).Y2;
                if((cars.get(i).X2 - cars.get(i).X1) / (cars.get(j).X2 - cars.get(j).X1) == (cars.get(i).Y2 - cars.get(i).Y1) / (cars.get(j).Y2 - cars.get(j).Y1)){
                }
                else{
                    int x = (x1*x12*y22 - x1*x22*y12 - x2*x12*y22 + x2*x22*y12 - x12*x1*y2 + x12*x2*y1 +x22) / ();
                    int y =;
                    if(cars.get(i).X2 > cars.get(i).X1){
                        if(cars.get(i).Y2 > cars.get(i).Y1){
                            if(cars.get(i).X1 < x && x < cars.get(i).X2 && cars.get(i).Y1 < y && y < cars.get(i).Y2){
                                cars1.add(cars.get(i));
                                cars1.add(cars.get(j));
                                return cars1;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    private Road locatingCar(Car car) {
        for(int i=0; i< this.city.roads.size(); i++){
            if(car.X1> this.city.roads.get(i).x1 && car.X1 < this.city.roads.get(i).x2 && car.Y1 < this.city.roads.get(i).y4 && this.city.roads.get(i).y1 < car.Y1){
                return this.city.roads.get(i);
            }
        }
        return null;
    }

    public void accident(Car car1, Car car2){
        double t11 = (((car1.weight - (0.5 * car2.weight) * car1.speed * Math.cos(Math.toRadians(car1.vectorAngle)) + ((car2.weight + 0.5 * car1.weight) * car2.speed * Math.cos(Math.toRadians(car2.vectorAngle))))) / (car1.weight + car2.weight));
        double t21 = (((car2.weight - (0.5 * car1.weight) * car2.speed * Math.cos(Math.toRadians(car2.vectorAngle)) + ((car1.weight + 0.5 * car2.weight) * car1.speed * Math.cos(Math.toRadians(car1.vectorAngle))))) / (car1.weight + car2.weight));
        double t12 = (((car1.weight - (0.5 * car2.weight) * car1.speed * Math.sin(Math.toRadians(car1.vectorAngle)) + ((car2.weight + 0.5 * car1.weight) * car2.speed * Math.sin(Math.toRadians(car2.vectorAngle))))) / (car1.weight + car2.weight));
        double t22 = (((car2.weight - (0.5 * car1.weight) * car2.speed * Math.sin(Math.toRadians(car2.vectorAngle)) + ((car1.weight + 0.5 * car2.weight) * car1.speed * Math.sin(Math.toRadians(car1.vectorAngle))))) / (car1.weight + car2.weight));
        if(car1.vectorAngle < 90 && car1.vectorAngle > 270){
            car1.vectorAngle = Math.toDegrees(Math.atan(t12 / t11));
            car2.vectorAngle = Math.toDegrees(Math.atan(t22 / t21));
        }

    }
    public void accident(Car car){
        if(car.vectorAngle < 180 && car.vectorAngle >= 0){
            car.vectorAngle = 180 - car.vectorAngle;
            double u = 0.75 * 0.5 * car.weight * car.speed * car.speed;
            car.speed /= 2;
            car.remainPower -= u;
        }
        else if(car.vectorAngle >= 180 && car.vectorAngle < 360){
            car.vectorAngle = 360 - car.vectorAngle;
            double u = 0.75 * 0.5 * car.weight * car.speed * car.speed;
            car.speed /= 2;
            car.remainPower -= u;
        }
    }
    public void Rate(){}
    public void damage(Car car1, Car car2){}
    public void damage(Car car){}
}

