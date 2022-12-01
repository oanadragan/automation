package Curs06;

public class Toilet extends Room{
    public Toilet(int floorNumber, String roomName) {
        super(floorNumber, roomName);
    }

    public String toString() {
        return getRoomName();
    }
}
