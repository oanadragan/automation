package Curs06;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter @NoArgsConstructor


public class Kitchen extends Room {
    private int coffeeMachine;
    private int waterDispenser;
    private int fridge;

    public Kitchen(int floorNumber, String roomName, int coffeeMachine, int waterDispenser, int fridge) {
        super(floorNumber, roomName);
        this.coffeeMachine = coffeeMachine;
        this.waterDispenser = waterDispenser;
        this.fridge = fridge;
    }



    public String toString() {
        return getRoomName() +" has " + getCoffeeMachine() +
                " Coffee machine "  + getWaterDispenser() + " water dispenser, and " +
                getFridge() + " fridge. ";
    }


}

