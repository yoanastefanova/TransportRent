package parking;

import java.time.LocalTime;

public class Ticket {
    private int slotNum;//will take it from instance of inner class Slot
    private LocalTime startTime;


    public Ticket(int slotNum, LocalTime time) {
        //maybe won't need verification, because I have it in Slot class
        this.slotNum = slotNum;
        this.startTime = time;
    }


    public int getSlotNum() {
        return slotNum;
    }

    public LocalTime getTime() {
        return startTime;
    }

    public void setTime(LocalTime time) {
        this.startTime = time;
    }
}
