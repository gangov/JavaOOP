package militaryeliteexercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Soldier> army = new ArrayList<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String soldierType = tokens[0];
            int id = Integer.parseInt(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];

            switch (soldierType) {
                case "Private":

                    break;
                case "LeutenantGeneral":
                    double salary = Double.parseDouble(tokens[4]);
                    LieutenantGeneral lieutenantGeneral = new LieutenantGeneral(id, firstName, lastName, salary);
                    army.add(lieutenantGeneral);
                    break;
                case "Engineer":

                    break;
                case "Commando":

                    break;
                case "Spy":
                    String codeNumber = tokens[4];
                    Spy spy = new Spy(id, firstName, lastName, codeNumber);
                    army.add(spy);
                    break;
            }

            input = scanner.nextLine();
        }

        for (Soldier soldier : army) {
            System.out.println(soldier.toString());
        }
    }
}
