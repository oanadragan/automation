package Curs06;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@Getter @Setter @NoArgsConstructor

public class Floor {
    private int floorNumber;

    private ArrayList<Room> conferenceRooms;
    private ArrayList<Room> kitchen;
    private ArrayList<Room> officeSpaces;
    private ArrayList<Room> toilet;

    private ArrayList<Room> rooms;

    private Room room;
    public Floor(int floorNumber, ArrayList<Room> conferenceRooms,
                 ArrayList<Room> kitchen,
                 ArrayList<Room> officeSpaces,
    ArrayList<Room> toilet)
    {
        this.floorNumber = floorNumber;
        this.conferenceRooms = conferenceRooms;
        this.kitchen = kitchen;
        this.officeSpaces = officeSpaces;
        this.toilet = toilet;
    }

    public Floor(int floorNumber,
                 ArrayList<Room> conferenceRooms,
                 ArrayList<Room> toilet) {
        this.floorNumber = floorNumber;
        this.conferenceRooms = conferenceRooms;
        this.toilet = toilet;
    }
    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        }


    public void printFloor() {

       System.out.println("The floor no " + getFloorNumber() + " has: " );

       if(floorNumber == 3){
           System.out.println(" All the conference Rooms from 3rd floor have conference equipment - Telepresence ");
       }
    }







}

