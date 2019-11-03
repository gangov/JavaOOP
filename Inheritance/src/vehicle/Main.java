package vehicle;
/*
Create a base class Vehicle. It should contain the following members:
DEFAULT_FUEL_CONSUMPTION – final static double (constant)
fuelConsumption –double
fuel – double
horsePower – int
Getters and Setters for the fields
A public constructor which accepts (fuel, horsePower) and set the default fuel consumption on the field fuelConsumption
void drive(double kilometers)
The drive method should have a functionality to reduce the fuel based on the travelled kilometers and fuel consumption.
Keep in mind that you can drive the vehicle only if you have enough fuel to finish the driving.
The default fuel consumption for Vehicle is 1.25. Some of the classes have different default fuel consumption:
SportCar – DEFAULT_FUEL_CONSUMPTION = 10
RaceMotorcycle – DEFAULT_FUEL_CONSUMPTION = 8
Car – DEFAULT_FUEL_CONSUMPTION = 3
Zip your package and upload it in Judge.
Hint
In the child classes' constructors use super.setFuelConsumption() to set fuelConsumption
 */
public class Main {
    public static void main(String[] args) {

    }
}
