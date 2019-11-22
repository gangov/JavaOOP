package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/*
You are given a RichSoilLand class with lots of fields (look at the provided skeleton). Like the good farmer you are,
you must harvest them. Harvesting means that you must print each field in a certain format (see output).

Input
You will receive a maximum of 100 lines with one of the following commands:
private - print all private fields
protected - print all protected fields
public - print all public fields
all - print ALL declared fields
HARVEST - end the input

Output
For each command you must print the fields that have the given access modifier as described in the input section. The
format in which the fields should be printed is:
"<access modifier> <field type> <field name>"
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Class privateClazz = RichSoilLand.class;
        Field[] declared = privateClazz.getDeclaredFields();
        String input = scanner.nextLine();

        while (!input.equals("HARVEST")) {
            for (Field s :declared) {
                String modifier = Modifier.toString(s.getModifiers());
                if (modifier.equals(input) || input.equals("all")) {
                    System.out.println(modifier + " " + s.getType().getSimpleName() + " " + s.getName());
                }
            }

            input = scanner.nextLine();
        }
    }
}
