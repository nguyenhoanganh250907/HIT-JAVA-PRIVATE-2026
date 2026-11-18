package Test1;

public class Car {
    private String carld;
    private String brand;
    private String licensePlate;

    public Car(String carld, String brand, String licensePlate) {
        this.carld = carld;
        this.brand = brand;
        this.licensePlate = licensePlate;
    }

    public String getCarld() {
        return carld;
    }

    public String getBrand() {
        return brand;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setCarld(String carld) {
        this.carld = carld;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}

