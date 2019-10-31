package CardSuitExercise;

import java.util.Scanner;

/*
Create an enumeration type that has as its constants the four suits of a deck of playing cards (CLUBS, DIAMONDS, HEARTS,
SPADES). Iterate over the values of the enumeration type and print all ordinal values and names.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println("Card Suits:");

        for (Cards value : Cards.values()) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s", value.ordinal(), value.name()));
        }
    }
}
