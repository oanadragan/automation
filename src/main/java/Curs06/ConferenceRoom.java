package Curs06;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Getter @Setter @NoArgsConstructor
public class ConferenceRoom extends Room {

    private String appliances;


    public ConferenceRoom(int floorNumber, String roomName, String appliances, int seats) {
        super(floorNumber, roomName, seats);
        this.appliances = appliances;

    }

    public ConferenceRoom(int floorNumber, String roomName, HashMap<String, Integer> furniture) {
        super(floorNumber, roomName, furniture);
    }




    public String toString() {
         return  getRoomName() + " : " + getFurniture() ;
       }


   }



