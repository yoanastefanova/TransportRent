package parking;


import transport.Vehicle;

import rental.ReadFromFile;

import java.time.LocalTime;
import java.util.*;


public class AirportParking {


    private List<Slot> slots = new LinkedList<Slot>();
    private Map<Vehicle, Ticket> vehicleTicket = new HashMap<Vehicle, Ticket>();//using instances for keys
    private int size;
    private final double HOURLY_PRICE_CAR = 2.0;
    private final double HOURLY_PRICE_BUS = 4.50;
    private final double HOURLY_PRICE_MOTOR = 3.45;
    private double priceToPay;
    //Random rand = new Random();

    private class Slot {

        private int slotNum;
        private boolean available;
        //Random rand;// it's better to use only one Random object, I guess?


        public Slot(boolean available) {
            if(size > 0) {
                Random rand = new Random();
                this.slotNum = rand.nextInt(size);
            }
            //this.slotNum += 1;
            this.available = available;
        }

        public int getSlotNum() {
            return slotNum;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean availability) {
            this.available = availability;
        }


        @Override
        public String toString() {
            return "Slot{" +
                    "slotNum=" + slotNum +
                    ", available=" + available +
                    '}';
        }
    }


    public AirportParking(int size) {
        for (int i = 0; i < size; i++) {
            slots.add(new Slot(true));//populating the parking with free spaces with random numbers
        }
    }


    public void parkVehicle(Vehicle vehicle) {
        //Random rand = new Random();
        if(size > 0) {
            Random rand = new Random();
            int randSlot = rand.nextInt(size);
            if (slots.get(randSlot).isAvailable() != true) {
                System.out.println("Unavailable slot. Try again with another one!");
            } else {
                vehicleTicket.put(vehicle, new Ticket(randSlot, LocalTime.now()));
                slots.get(randSlot).setAvailable(false);//it's taken now, so we should take care of its availability
            }
        }
    }


    public void exit(Vehicle vehicle) {
        Ticket t1 = vehicleTicket.get(vehicle);//using the Vehicle map key

        int establishedTime = LocalTime.now().getHour() - t1.getTime().getHour();

        switch (vehicle.getType()) {
            case CAR:
                priceToPay = establishedTime * HOURLY_PRICE_CAR;
                break;
            case BUS:
                priceToPay = establishedTime * HOURLY_PRICE_BUS;
                break;
            case MOTORCYCLE:
                priceToPay = establishedTime * HOURLY_PRICE_MOTOR;
                break;
            default:
                System.out.println("Incorrect type!");
                break;
        }
        System.out.println("PRICE TO PAY IS: " + priceToPay);

        int num = t1.getSlotNum();
        slots.get(num).setAvailable(true);//after exiting, this space is available again
    }
}