package vehiclesexercise;

import java.text.DecimalFormat;
// TODO it is "Cannot fit fuel in tank" should be "Fuel must be a positive number"
public class Vehicle {
    private static final DecimalFormat df = new DecimalFormat("#.##");

    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            System.out.println("Fuel must be a positive number");
        } else {
            this.fuelQuantity = fuelQuantity;
        }
    }

    protected void setTankCapacity(double tankCapacity) {
        if (tankCapacity <= 0) {
            System.out.println("Fuel must be a positive number");
        } else {
            this.tankCapacity = tankCapacity;
        }
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }


    public double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void drive(double distance) {
        if (distance * this.getFuelConsumption() <= this.getFuelQuantity()) {
            this.setFuelQuantity(this.getFuelQuantity() - (distance * this.getFuelConsumption()));
            System.out.println(String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(distance)));
        } else {
            System.out.println(this.getClass().getSimpleName() + " needs refueling");
        }
    }

    public void refuel(double poorFuel) {
        if (poorFuel <= 0) {
            System.out.println("Fuel must be a positive number");
        } else {
            if (this.getFuelQuantity() + poorFuel > this.tankCapacity) {
                System.out.println("Cannot fit fuel in tank");
            } else {
                this.setFuelQuantity(this.getFuelQuantity() + poorFuel);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}
