package animals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
Create a hierarchy(package) of animals. Your program should have three different animals – Dog, Frog and Cat. Deeper in
the hierarchy you should have two additional classes – Kitten and Tomcat. Kittens are "Female" and Tomcats are "Male".
All types of animals should be able to produce some kind of sound - String produceSound(). For example, the dog should
be able to bark. Your task is to model the hierarchy and test its functionality. Create an animal of each kind and make
them all produce sound and create getters for all fields.
You will be given some lines of input. Each two lines will represent an animal. On the first line will be the type of
animal and on the second – the name, the age and the gender. When the command "Beast!" is given, stop the input and
print all the animals in the format shown below.
Output
Print the information for each animal on three lines. On the first line, print: "{animalType}"
On the second line print: "{name} {age} {gender}"
On the third line print the sounds it produces: "{produceSound()}"
Constraints
Each Animal should have a name, an age and a gender
All input values should not be blank (e.g. name, age and so on…)
If you receive an input for the gender of a Tomcat or a Kitten, ignore it but create the animal
If the input is invalid for one of the properties, throw an exception with message: "Invalid input!"
Each animal should have the functionality to produceSound()
Here is the type of sound each animal should produce:
Dog: "Woof!"
Cat: "Meow meow"
Frog: "Ribbit"
Kittens: "Meow"
Tomcat: "MEOW"
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayList<Animal> animals = new ArrayList<>();

        while (!input.equals("Beast!")) {
            String[] information = scanner.nextLine().split("\\s+");
            String name = information[0];
            int age = Integer.parseInt(information[1]);
            String gender = information[2];

//            if (name.isEmpty() || age < 0 || gender.isEmpty()) {
//                System.out.println("Invalid input!");
//                input = scanner.nextLine();
//                continue;
//            }

            switch (input) {
                case "Cat":
                    Cat cat = new Cat(name, age, gender);
                    animals.add(cat);
                    break;
                case "Dog":
                    Dog dog = new Dog(name, age, gender);
                    animals.add(dog);
                    break;
                case "Frog":
                    Frog frog = new Frog(name, age, gender);
                    animals.add(frog);
                    break;
                case "Kitten":
                    Kitten kitten = new Kitten(name, age, gender);
                    animals.add(kitten);
                    break;
                case "Tomcat":
                    Tomcat tomcat = new Tomcat(name, age, gender);
                    animals.add(tomcat);
                    break;
            }

            input = scanner.nextLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
