package defineaninterfacepersonexercise;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

/*
#1. Define an interface Person with methods getName and getAge. Define a class Citizen which implements Person and has a
constructor which takes a String name and an int age.

#2. Using the code from the previous task, define an interface Identifiable with a String method getId and an interface
Birthable with a String method getBirthDate and implement them in the Citizen class. Rewrite the Citizen constructor to
accept the new parameters.

#3. It is a well known fact that people celebrate birthdays, it is also known that some people also celebrate their pets
birthdays. Extend the program from your last task to add birthdates to citizens and include a class Pet, pets have a
name and a birthdate. Also create class Robot which has an id and model. Encompass repeated functionality into
interfaces and implement them in your classes.
You will receive from the console an unknown amount of lines until the command "End" is received,  each line will
contain information in one of the following formats "Citizen <name> <age> <id> <birthdate>" for citizens,  "Robot <model>
<id>" for robots or "Pet <name> <birthdate>" for pets. After the end command on the next line you will receive a single
number representing a specific year, your task is to print all birthdates (of both citizens and pets) in that year in
the format day/month/year (the order of printing doesn’t matter).

#4. Your totalitarian dystopian society suffers a shortage of food, so many rebels appear. Extend the code from your
previous (Problem 2.Multiple Implementation) task with new functionality to solve this task.
Define a class Rebel which has a name, age and group (String), names are unique - there will never be 2 Rebels/Citizens
or a Rebel and Citizen with the same name. Define an interface Buyer which defines a methods buyFood() and a getFood().
Implement the Buyer interface in the Citizen and Rebel class, both Rebels and Citizens start with 0 food, when a Rebel
buys food his food increases by 5, when a Citizen buys food his food increases by 10.
On the first line of the input you will receive an integer N - the number of people, on each of the next N lines you
will receive information in one of the following formats "<name> <age> <id> <birthdate>" for a Citizen or  "<name> <age>
<group>" for a Rebel. After the N lines until the command "End" is received, you will receive names of people who bought
food, each on a new line. Note that not all names may be valid, in case of an incorrect name - nothing should happen.
On the only line of output, you should print the total amount of food purchased.


 */
public class Main {
    public static void main(String[] args) {
        Class[] citizenInterfaces = Citizen.class.getInterfaces();
        if (Arrays.asList(citizenInterfaces).contains(Birthable.class)
                && Arrays.asList(citizenInterfaces).contains(Identifiable.class)) {
            Method[] methods = Birthable.class.getDeclaredMethods();
            methods = Identifiable.class.getDeclaredMethods();
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            int age = Integer.parseInt(scanner.nextLine());
            String id = scanner.nextLine();
            String birthDate = scanner.nextLine();
            Identifiable identifiable = new Citizen(name,age,id,birthDate);
            Birthable birthable = new Citizen(name,age,id,birthDate);
            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName());
            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName());
        }
    }
}
