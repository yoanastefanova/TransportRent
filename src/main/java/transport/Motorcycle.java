package transport;


public class Motorcycle extends Vehicle {
    private int cubicCm;
    private int horsePower;


    public Motorcycle(int id, String brand, int yearOfManufacture, int cubicCm, int horsePower) {
        super(id, brand, yearOfManufacture);
        setCubicCm(cubicCm);
        setHorsePower(horsePower);
        this.type = Type.MOTORCYCLE;
    }

    public int getCubicCm() {
        return cubicCm;
    }

    public void setCubicCm(int cubicCm) {
        if (cubicCm > 90) {
            this.cubicCm = cubicCm;
        } else {
            System.out.println("Cubic cm should be more than 90. Will be set to default.");
            this.cubicCm = 150;
        }
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        if (horsePower > 70) {
            this.horsePower = horsePower;
        } else {
            System.out.println("Horse power should be more than 60. Will be set to default.");
            this.horsePower = 100;
        }
    }

    @Override
    public int getHPUpgrade() {
        return horsePower + cubicCm / 4;
    }

    @Override
    public double getFuelUsage() {
        return 2.0 + cubicCm * 0.03;
    }

    @Override
    public String toString() {
        return "Motorcycle: " +
                super.toString() +
                ", cubicCm=" + getCubicCm() +
                ", horsePower=" + getHorsePower() +
                ", horsePowerUpgrade=" + getHPUpgrade() +
                ", fuelUsage=" + getFuelUsage();
    }
}
