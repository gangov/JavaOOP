package wildfarmexercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Your task is to create a class hierarchy like the picture below. All the classes except Vegetable, Meat, Mouse, Tiger,
Cat & Zebra should be abstract.

Input should be read from the console. Every even line will contain information about the Animal in following format:
{AnimalType} {AnimalName} {AnimalWeight} {AnimalLivingRegion} [{CatBreed} = Only if its cat]
On the odd lines you will receive information about the food that you should give to the Animal. The line will consist
of FoodType and quantity separated by a whitespace.
You should build the logic to determine if the animal is going to eat the provided food. The Mouse and Zebra should
check if the food is a Vegetable. If it is they will eat it. Otherwise you should print a message in the format:
{AnimalType} are not eating that type of food!
Cats eat any kind of food, but Tigers accept only Meat. If Vegetable is provided to a tiger message like the one above
should be printed on the console.
After you read information about the Animal and Food then invoke makeSound() method of the current animal and then feed
it. At the end print the whole object and proceed reading information about the next animal/food. The input will
continue until you receive "End". After that print the information of all received animals in format:
{AnimalType} [{AnimalName}, {CatBreed}, {AnimalWeight}, {AnimalLivingRegion}, {FoodEaten}]
Print all AnimalWeight with no trailing zeroes after the decimal separator. Use the DecimalFormat class.
Note: consider overriding toString() method.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] animalTokens = scanner.nextLine().split("\\s+");

        List<Animal> animals = new ArrayList<>();

        while (!animalTokens[0].equals("End")) {
            String[] foodTokens = scanner.nextLine().split("\\s+");

            String animaltype = animalTokens[0];
            String name = animalTokens[1];
            double weight = Double.parseDouble(animalTokens[2]);
            String livingRegion = animalTokens[3];

            String foodType = foodTokens[0];
            int foodQuantity = Integer.parseInt(foodTokens[1]);

            Food food = null;
            if (foodType.equals("Meat")) {
                food = new Meat(foodQuantity);
            } else {
                food = new Vegetable(foodQuantity);
            }

            switch (animaltype) {
                case "Cat":
                    String breed = animalTokens[4];
                    Cat cat = new Cat(name, animaltype, weight, foodQuantity, livingRegion, breed);
                    cat.eat(food);
                    animals.add(cat);
                    break;
                case "Tiger":
                    Tiger tiger = new Tiger(name, animaltype, weight, foodQuantity, livingRegion);
                    tiger.eat(food);
                    animals.add(tiger);
                    break;
                case "Zebra":
                    Zebra zebra = new Zebra(name, animaltype, weight, foodQuantity, livingRegion);
                    zebra.eat(food);
                    animals.add(zebra);
                    break;
                case "Mouse":
                    Mouse mouse = new Mouse(name, animaltype, weight, foodQuantity, livingRegion);
                    mouse.eat(food);
                    animals.add(mouse);
                    break;
            }

            animalTokens = scanner.nextLine().split("\\s+");
        }

        for (Animal animal : animals) {
            animal.makeSound();
            System.out.println(animal.toString());
        }
    }
}
