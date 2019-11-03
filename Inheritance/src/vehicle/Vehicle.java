package vehicle;

public class Vehicle {
    private final double DEFAULT_FUEL_CONSUMPTION = 1.25;
    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    // constructor
    public Vehicle(double fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        this.fuelConsumption = this.DEFAULT_FUEL_CONSUMPTION;
    }


    // getters and setters
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    // custom methods

    // reduce fuel in a car after it has been driven
    public void drive(double kilometers) {
        if (canDrive(kilometers)) {
            double usage = kilometers * this.fuelConsumption;
            this.fuel -= usage;
        }
    }

    // check if a vehicle can be driven
    private boolean canDrive(double kilometers) {
        return kilometers * this.fuelConsumption > 0;
    }
}

