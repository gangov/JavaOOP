package vehiclesexercise;

import java.text.DecimalFormat;

public class Car extends Vehicle {

    protected Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + 0.9, tankCapacity);
    }
}
