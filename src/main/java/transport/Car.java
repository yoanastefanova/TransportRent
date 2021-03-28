package transport;


public class Car extends Vehicle {
    private int numOfDoors;
    private int horsePower;


    public Car(int id, String brand, int yearOfManufacture, int numOfDoors, int horsePower) {
        super(id, brand, yearOfManufacture);
        setNumOfDoors(numOfDoors);
        setHorsePower(horsePower);
        this.type = Type.CAR;
    }

    public int getNumOfDoors() {
        return numOfDoors;
    }

    public void setNumOfDoors(int numOfDoors) {
        if (numOfDoors != 2 && numOfDoors != 4) {
            System.out.println("Number of doors should be either 2 or 4. Will be set to 4.");
            this.numOfDoors = 4;
        } else {

            this.numOfDoors = numOfDoors;
        }
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        if (horsePower > 50) {
            this.horsePower = horsePower;
        } else {
            System.out.println("Horse power should be greater than 50. Will be set to default.");
            this.horsePower = 80;
        }
    }

    @Override
    public int getHPUpgrade() {
        return horsePower + 35;
    }

    @Override
    public double getFuelUsage() {
        return 2.0 + horsePower*0.1;
    }

    @Override
    public String toString() {
        return "Car: " +
                super.toString() +
                ", numOfDoors=" + getNumOfDoors() +
                ", horsePower=" + getHorsePower() +
                ", horsePowerUpgrade=" + getHPUpgrade() +
                ", fuelUsage=" + getFuelUsage();

    }
}
