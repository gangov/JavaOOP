package CardRankExercise;

import java.util.Scanner;

/*
Create an enumeration type that has as its constants the fourteen ranks of a deck of playing cards
(ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING). Iterate over the values of the
enumeration type and print all ordinal values and names.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println("Card Ranks:");
        for (Ranks value : Ranks.values()) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s",
                    value.ordinal(), value.name()));
        }
    }
}
