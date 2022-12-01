package Curs06;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@Getter @Setter @NoArgsConstructor

public class Building {

   // private Floor;
    private int numberOfFloors;

    private ArrayList<Floor> floors;
    private String buildingName;

    public Building(int numberOfFloors, String buildingName,ArrayList<Floor> floors) {
      //  this.floor = floor;
        this.numberOfFloors = numberOfFloors;
        this.buildingName = buildingName;
        this.floors = floors;
    }

    public void printBuilding() {
        System.out.println("The building " + getBuildingName() + " has " + getFloors().size() + " floors");


    }






}


