package rental;

import parking.AirportParking;
import transport.Car;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ReadFromFile read = new ReadFromFile();
        read.fromTxtFile();
        read.info();

        read.printCarsByHP();


        AirportParking parking = new AirportParking(10);
        Car c1 = new Car(1717, "Mazda", 2007, 4,149);
        parking.parkVehicle(c1);

       /* for (int i = 0; i < parking.slots.size(); i++) {

            System.out.println(parking.slots.get(i).isAvailable());
        }*/

        //parking.exit(c1);

        //System.out.println(slots.get(parking.vehicleTicket.get(c1).getSlotNum().isAvailable()));

       /* for (int i = 0; i < parking.slots.size(); i++) {
            System.out.println(parking.slots.get(i));
        }*/
    }
}
