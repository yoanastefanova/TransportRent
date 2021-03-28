package rental;

import transport.Bus;
import transport.Car;
import transport.Motorcycle;
import transport.Vehicle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadFromFile {

    protected List<Car> cars = new ArrayList<Car>();
    protected List<Bus> buses = new ArrayList<Bus>();
    protected List<Motorcycle> motors = new ArrayList<Motorcycle>();


    private Car inputCar(String[] data) {
        Car c1 = new Car(Integer.parseInt(data[2]), data[3], Integer.parseInt(data[4]),
                Integer.parseInt(data[5]), Integer.parseInt(data[6]));//id, brand, year, doors, HP
        return c1;
    }

    private Bus inputBus(String[] data) {
        Bus b1 = new Bus(Integer.parseInt(data[2]), data[3], Integer.parseInt(data[4]),
                Integer.parseInt(data[5]));//id, brand, year, seats
        return b1;
    }


    private Motorcycle inputMotorcycle(String[] data) {
        Motorcycle m1 = new Motorcycle(Integer.parseInt(data[2]), data[3], Integer.parseInt(data[4]),
                Integer.parseInt(data[5]), Integer.parseInt(data[6]));//id, brand, year, cubicCm, HP
        return m1;
    }


    void addVehicle(String[] data) {
        String type = data[1];//add, TYPE, id, brand, blablablaaa

        switch (type) {
            case "CAR":
                cars.add(inputCar(data));
                break;
            case "BUS":
                buses.add(inputBus(data));
                break;
            case "MOTOR":
                motors.add(inputMotorcycle(data));
                break;
            default:
                System.out.println("No such type of vehicle!");
                break;
        }
    }


    void rentVehicle(String[] data) {
        String type = data[1];

        switch (type) {
            case "CAR":
                for (int i = 0; i < cars.size(); ++i) {//using this for loop so as to get the index
                    if (cars.get(i).getId() == Integer.parseInt(data[2])) {
                        //System.out.println("success car");
                        cars.remove(i);
                        break;
                    } else if (i == cars.size() - 1) {
                        System.out.println("Car rent is unsuccessful. This car isn't available.");
                    }
                }
                break;

            case "BUS":
                for (int i = 0; i < buses.size(); ++i) {//using this for loop so as to get the index
                    if (buses.get(i).getId() == Integer.parseInt(data[2])) {
                        //System.out.println("success car");
                        buses.remove(i);
                        break;
                    } else if (i == buses.size() - 1) {
                        System.out.println("Bus rent is unsuccessful. This bus isn't available.");
                    }
                }
                break;

            case "MOTOR":
                for (int i = 0; i < motors.size(); ++i) {//using this for loop so as to get the index
                    if (motors.get(i).getId() == Integer.parseInt(data[2])) {
                        //System.out.println("success car");
                        motors.remove(i);
                        break;
                    } else if (i == motors.size() - 1) {
                        System.out.println("Motorcycle rent is unsuccessful. This motorcycle isn't available.");
                    }
                }
                break;

            default:
                System.out.println("No such type of vehicle!");
                break;

        }
    }

    void fromTxtFile() throws FileNotFoundException {
        File fileInput = new File("D:\\School-Of-Java\\Transport\\fileInput.txt");
        Scanner scan = new Scanner(fileInput);

        while (scan.hasNextLine()) {
            String[] data = scan.nextLine().split(", ");

            String command = data[0];

            switch (command) {
                case "ADD":
                    System.out.println("Adding new vehicle.");
                    addVehicle(data);
                    break;
                case "RENT":
                    System.out.println("Renting vehicle.");
                    rentVehicle(data);
                    break;
                default:
                    System.out.println("Incorrect command in file! Must be ADD or RENT.");
                    break;
            }
        }
    }


    void printCarsByHP(){
        List<Car> sortedCars = new ArrayList<>(cars);
        Collections.sort(sortedCars, (Car c1, Car c2) -> (c1.getHorsePower() - c2.getHorsePower()));
        System.out.println("SORTING CARS BY HORSEPOWER");
        for (int i = 0; i < sortedCars.size(); i++) {
            System.out.println(sortedCars.get(i));
        }
    }

    void printMotorcyclesByYear(){
        List<Motorcycle> sortedMotors = new ArrayList<>(motors);
        Collections.sort(sortedMotors, (Motorcycle m1, Motorcycle m2) -> (m1.getYearOfManufacture() - m2.getYearOfManufacture()));
        System.out.println("SORTING MOTORCYCLES BY YEAR");
        for (int i = 0; i < sortedMotors.size(); i++) {
            System.out.println(sortedMotors.get(i));
        }
    }

    void printBusesByBrand(){
        List<Bus> sortedBuses = new ArrayList<>(buses);
        Collections.sort(sortedBuses, (Bus b1, Bus b2) -> (b1.getBrand().compareTo(b2.getBrand())));
        System.out.println("SORTING BUSES BY BRANDS");
        for (int i = 0; i < sortedBuses.size(); i++) {
            System.out.println(sortedBuses.get(i));
        }
    }

    void info() {
        for (Motorcycle motor : motors) {
            System.out.println(motor.getYearOfManufacture());
        }
    }
}
