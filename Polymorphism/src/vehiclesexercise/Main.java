package vehiclesexercise;

import java.util.Scanner;

/*

Exercise #1

Write a program that models 2 vehicles (Car and Truck) and will be able to simulate driving and refueling them in the
summer. Car and truck both have fuel quantity, fuel consumption in liters per km and can be driven given distance and
refueled with given liters. But in the summer both vehicles use air conditioner and their fuel consumption per km is
increased by 0.9 liters for the car and with 1.6 liters for the truck. Also the truck has a tiny hole in his tank and
when it gets refueled it gets only 95% of given fuel. The car has no problems when refueling and adds all given fuel to
its tank. If vehicle cannot travel given distance its fuel does not change.


Input
On the first line - information about the car in format "Car {fuel quantity} {liters per km}"
On the second line – info about the truck in format "Truck {fuel quantity} {liters per km}"
On third line - number of commands N that will be given on the next N lines
On the next N lines – commands in format:
Drive Car {distance}
Drive Truck {distance}
Refuel Car {liters}
Refuel Truck {liters}


Output
After each Drive command print whether the Car/Truck was able to travel given distance in format if it’s successful.
Print the distance with two digits after the decimal separator except trailing zeros. Use the DecimalFormat class:
"Car/Truck travelled {distance} km"
Or if it is not:
"Car/Truck needs refueling"
Finally print the remaining fuel for both car and truck rounded 2 digits after floating point in format:
"Car: {liters}
Truck: {liters}"

Exercise #2

Use your solution of the previous task for starting point and add more functionality. Add new vehicle – Bus. Now every
vehicle has tank capacity and fuel quantity cannot fall (set) below 0 (If fuel quantity become less than 0 print on the
console "Fuel must be a positive number").
The vehicles cannot be filled with fuel more than their tank capacity. If you try to put more fuel in the tank than the
available space, print on the console "Cannot fit fuel in tank" and do not add any fuel in vehicles tank.
Add new command for the bus. The bus can drive with or without people. If the bus is driving with people, the
air-conditioner is turned on and its fuel consumption per kilometer is increased with 1.4 liters. If there are no people
in the bus when driving the air-conditioner is turned off and does not increase the fuel consumption.


Input
On the first three lines you will receive information about the vehicles in format:
Vehicle {initial fuel quantity} {liters per km} {tank capacity}
On fourth line - number of commands N that will be given on the next N lines
On the next N lines – commands in format
Drive Car {distance}
Drive Truck {distance}
Drive Bus {distance}
DriveEmpty Bus {distance}
Refuel Car {liters}
Refuel Truck {liters}
Refuel Bus {liters}


Output
After each Drive command print whether the Car/Truck was able to travel given distance in format if it’s successful:
"Car/Truck/Bus travelled {distance} km"
Or if it is not:
"Car/Truck/Bus needs refueling"
If given fuel is ≤ 0 print "Fuel must be a positive number".
If given fuel cannot fit in car or bus tank print "Cannot fit fuel in tank"
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] carInput = scanner.nextLine().split("\\s+");
        String[] truckInput = scanner.nextLine().split("\\s+");
        String[] busInput = scanner.nextLine().split("\\s+");


        Car car = new Car(Double.parseDouble(carInput[1]), Double.parseDouble(carInput[2]), Double.parseDouble(carInput[3]));
        Truck truck = new Truck(Double.parseDouble(truckInput[1]), Double.parseDouble(truckInput[2]), Double.parseDouble(carInput[3]));
        Bus bus = new Bus(Double.parseDouble(busInput[1]), Double.parseDouble(busInput[2]), Double.parseDouble(busInput[3]));

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            String vehicle = input[1];
            double quantity = Double.parseDouble(input[2]);

            switch (command) {
                case "Drive":
                    switch (vehicle) {
                        case "Car":
                            car.drive(quantity);
                            break;
                        case "Truck":
                            truck.drive(quantity);
                            break;
                        case "Bus":
                            bus.setFuelConsumption(bus.getFuelConsumption() + 1.4);
                            bus.drive(quantity);
                            bus.setFuelConsumption(bus.getFuelConsumption() - 1.4);
                            break;
                    }
                    break;
                case "DriveEmpty":
                    bus.drive(quantity);
                    break;
                case "Refuel":
                    switch (vehicle) {
                        case "Car":
                            car.refuel(quantity);
                            break;
                        case "Truck":
                            truck.refuel(quantity);
                            break;
                        case "Bus":
                            bus.refuel(quantity);
                            break;
                    }
                    break;
            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }
}
