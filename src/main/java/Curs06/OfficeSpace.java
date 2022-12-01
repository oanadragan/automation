package Curs06;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class OfficeSpace extends Room{
    private int desks;

    public OfficeSpace(int floorNumber, String roomName, int desks) {
        super(floorNumber, roomName);
        this.desks = desks;
    }




    public String toString() {
        return getRoomName() +" has " +
                getDesks() +
                " desks";
    }
}
