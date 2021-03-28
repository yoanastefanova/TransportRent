package transport;

public abstract class Vehicle {

    public enum Type {
        CAR,
        BUS,
        MOTORCYCLE
    }


    private final int id;
    private String brand;
    private int yearOfManufacture;
    protected Type type;
    //private String cityToFindItIn;

    public Vehicle(int id, String brand, int yearOfManufacture) {
        if (id >= 0) {
            this.id = id;
        } else {
            this.id = 0001;
        }
        setBrand(brand);
        setYearOfManufacture(yearOfManufacture);
    }

    public int getId() {
        return id;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand != null) {
            this.brand = brand;
        }else {
            System.out.println("Brand can't be null! Will be set to default.");
            this.brand = "BMW";
        }
    }


    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        if (yearOfManufacture > 1900) {
            this.yearOfManufacture = yearOfManufacture;
        } else {
            System.out.println("Year of manufacture should be after 1900. Will be set to default.");
            this.yearOfManufacture = 2000;
        }
    }

    public Type getType() {
        return type;
    }

    /*
    public String getCityToFindItIn() {
        return cityToFindItIn;
    }

    public void setCityToFindItIn(String cityToFindItIn) {
        if (cityToFindItIn != null) {
            this.cityToFindItIn = cityToFindItIn;
        }
    }
     */

    public abstract int getHPUpgrade();

    public abstract double getFuelUsage();


    @Override
    public String toString() {
        return  "id=" + id +
                ", brand='" + brand + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", type=" + type;
    }
}
