package transport;


public class Bus extends Vehicle {
    private int numOfSeats;


    public Bus(int id, String brand, int yearOfManufacture, int numOfSeats) {
        super(id, brand, yearOfManufacture);
        setNumOfSeats(numOfSeats);
        this.type = Type.BUS;
    }


    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        if (numOfSeats > 5) {
            this.numOfSeats = numOfSeats;
        } else {
            System.out.println("Number of seats should be bigger than 5. Will be set to default.");
            this.numOfSeats = 12;
        }
    }


    @Override
    public int getHPUpgrade() {
        return 100 + numOfSeats * 10;
    }

    @Override
    public double getFuelUsage() {
        return 2.0 + numOfSeats;
    }

    @Override
    public String toString() {
        return "Bus: " +
                super.toString() +
                ", numOfSeats=" + getNumOfSeats() +
                ", horsePowerUpgrade=" + getHPUpgrade() +
                ", fuelUsage=" + getFuelUsage();
    }
}
