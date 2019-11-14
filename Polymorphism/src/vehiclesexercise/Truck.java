package vehiclesexercise;

import java.text.DecimalFormat;

public class Truck extends Vehicle {


    protected Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + 1.6, tankCapacity);
    }

    @Override
    public void refuel(double poorFuel) {
        super.refuel(poorFuel * 0.95);
    }
}
