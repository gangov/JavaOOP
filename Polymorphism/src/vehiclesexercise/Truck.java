package vehiclesexercise;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    private static final double AIR_CONDITIONER_INCREASE = 1.6;
    private static final double TANK_LEAKAGE_PERCENTAGE = 0.95;


    protected Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITIONER_INCREASE, tankCapacity);
    }

    @Override
    public void refuel(double poorFuel) {
        super.refuel(poorFuel * TANK_LEAKAGE_PERCENTAGE);
    }
}
