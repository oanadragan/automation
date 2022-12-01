package Curs06;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;

@Getter @Setter @NoArgsConstructor
public class Room {

    private String appliances;
    private int seats;
    private int desks;
    private int floorNumber;

    private String roomName;

    private HashMap<String, Integer> furniture;
    static ArrayList<Room> rooms;

    private Room roomType;
    public Room(int floorNumber, String roomName, HashMap<String, Integer> furniture) {
        this.floorNumber = floorNumber;
        this.roomName = roomName;
        this.furniture = furniture;
    }

    public Room(int floorNumber, String roomName) {
        this.floorNumber = floorNumber;
        this.roomName = roomName;
    }

    public Room(int floorNumber, Room roomType, HashMap<String, Integer> furniture) {
        this.floorNumber = floorNumber;
        this.roomType = roomType;
        this.furniture = furniture;
    }

    public Room(int floorNumber, String roomName, int seats) {
        this.floorNumber = floorNumber;
        this.roomName = roomName;
        this.seats = seats;
    }


    public static void printArrayListElements(ArrayList<Room> rooms) {
        System.out.println(rooms.size());
        for (Room r : rooms) {
            System.out.println(r);
        }
    }

}





