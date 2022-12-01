package Curs06;

import java.util.ArrayList;
import java.util.HashMap;

import static Curs06.Room.printArrayListElements;

public class NewBuilding {

    public static void main(String[] args) {
        HashMap<String, Integer> furniture = new HashMap<>();
        furniture.put("TV", 1);
        furniture.put("Seats", 10);
        ConferenceRoom ConferenceRoom1 = new ConferenceRoom
                (1, "ConferenceRoom 1", furniture);

        ConferenceRoom ConferenceRoom2 = new ConferenceRoom
                (1, "Conference Room 2", furniture);
        ConferenceRoom ConferenceRoom3 = new ConferenceRoom
                (1, "Conference Room 3", furniture);

        HashMap<String, Integer> furniture1 = new HashMap<>();
        furniture1.put("TV", 1);
        furniture1.put("Seats", 8);

        ConferenceRoom ConferenceRoom4 = new ConferenceRoom
                (1, "Conference Room 4", furniture1);
        ConferenceRoom ConferenceRoom5 = new ConferenceRoom
                (1, "Conference Room 5", furniture1);
        ConferenceRoom ConferenceRoom6 = new ConferenceRoom
                (1, "Conference Room 6", furniture1);
        ConferenceRoom ConferenceRoom7 = new ConferenceRoom
                (1, "Conference Room 7", furniture1);

        HashMap<String, Integer> furniture2 = new HashMap<>();
        furniture2.put("TV", 1);
        furniture2.put("Seats", 10);

        ConferenceRoom ConferenceRoom9 = new ConferenceRoom
                (1, "Conference Room 9 ", furniture2);
        ConferenceRoom ConferenceRoom10 = new ConferenceRoom
                (1, "Conference Room 10", furniture2);
        ConferenceRoom ConferenceRoom11 = new ConferenceRoom
                (1, "Conference Room 11", furniture2);
        ConferenceRoom ConferenceRoom12 = new ConferenceRoom
                (1, "Conference Room 12", furniture2);

        HashMap<String, Integer> furniture3 = new HashMap<>();
        furniture3.put("TV", 1);
        furniture3.put("Seats", 30);
        furniture3.put("Video Projector", 1);

        ConferenceRoom ConferenceRoom8 = new ConferenceRoom
                (1, "Conference Room 8", furniture3);
        HashMap<String, Integer> furniture4 = new HashMap<>();
        furniture4.put("TV", 1);
        furniture4.put("Seats", 20);
        ConferenceRoom ConferenceRoom13 = new ConferenceRoom
                (1, "Conference Room 13", furniture4);

        OfficeSpace OfficeSpace1 = new OfficeSpace(1, "Office Space 1", 20 );
        OfficeSpace OfficeSpace2 = new OfficeSpace(1, "Office Space 2", 10 );
        OfficeSpace OfficeSpace3 = new OfficeSpace(1, "Office Space 3", 10 );

        Kitchen Kitchen1 = new Kitchen(1, "Kitchen", 1, 1, 1);
        Toilet toilet1 = new Toilet(1, "Toilet");
        Toilet toilet2 = new Toilet(1, "Toilet");

        ArrayList<Room> conferenceRooms1 = new ArrayList<>();
        conferenceRooms1.add(ConferenceRoom1);
        conferenceRooms1.add(ConferenceRoom2);
        conferenceRooms1.add(ConferenceRoom3);

        ArrayList<Room> officeSpaces1 = new ArrayList<>();
        officeSpaces1.add(OfficeSpace1);

        ArrayList<Room> kitchen1 = new ArrayList<>();
        kitchen1.add(Kitchen1);

        ArrayList<Room> Toilet1 = new ArrayList<>();
        Toilet1.add(toilet1);
        Toilet1.add(toilet2);




        Floor Floor1 = new Floor(1, conferenceRooms1, kitchen1, officeSpaces1, Toilet1);

        ArrayList<Room> conferenceRooms2 = new ArrayList<>();
        conferenceRooms2.add(ConferenceRoom4);
        conferenceRooms2.add(ConferenceRoom5);
        conferenceRooms2.add(ConferenceRoom6);
        conferenceRooms2.add(ConferenceRoom7);

        ArrayList<Room> conferenceRooms3 = new ArrayList<>();
        conferenceRooms3.add(ConferenceRoom13);
        conferenceRooms3.add(ConferenceRoom8);
        conferenceRooms3.add(ConferenceRoom11);
        conferenceRooms3.add(ConferenceRoom12);
        conferenceRooms3.add(ConferenceRoom9);
        conferenceRooms3.add(ConferenceRoom10);


        ArrayList<Room> officeSpaces2 = new ArrayList<>();
        officeSpaces2.add(OfficeSpace2);
        officeSpaces2.add(OfficeSpace3);

        Floor Floor2 = new Floor(2, conferenceRooms2, kitchen1, officeSpaces2, Toilet1);
        Floor Floor3 = new Floor(3, conferenceRooms3, Toilet1);

        ArrayList<Floor> floors = new ArrayList<>();
        floors.add(Floor1);
        floors.add(Floor2);
        floors.add(Floor3);

        Building NewBuilding = new Building(3, " NEW", floors);



        NewBuilding.printBuilding();
        Floor1.printFloor();
        //  System.out.println(Floor1.toString());

        printArrayListElements(conferenceRooms1);
        printArrayListElements(officeSpaces1);
        printArrayListElements(kitchen1);
        printArrayListElements(Toilet1);

        Floor2.printFloor();
        //System.out.println(Floor2.toString());
        printArrayListElements(conferenceRooms2);
        printArrayListElements(officeSpaces2);
        printArrayListElements(kitchen1);
        printArrayListElements(Toilet1);


        Floor3.printFloor();
        printArrayListElements(conferenceRooms3);
        printArrayListElements(Toilet1);


        //Floor3.printFloor1();



    }
}
