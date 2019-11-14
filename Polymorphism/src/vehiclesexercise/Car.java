package vehiclesexercise;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    private static final double AIR_CONDITIONER_INCREASE = 0.9;

    protected Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITIONER_INCREASE, tankCapacity);
    }
}
