import java.util.Scanner;
/*
Create a program that reads a positive integer n as input and prints on the console a rhombus with size n:
 */
public class RhombusofStarsLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        printRow(size);
    }

    private static void printRow(int size) {

        for (int i = 1; i <= size; i++) {
            //printing empty spaces
            for (int empty = size - i; empty > 0; empty--) {
                System.out.print(" ");
            }

            //printing stars from top to middle
            for (int stars = 1; stars <= i; stars++) {
                System.out.print("* ");
            }

            System.out.println();
        }


        //printing stars from middle to end
        for (int i = size - 1; i > 0; i--) {
            for (int empty = i; empty <= size - 1; empty++) {
                System.out.print(" ");
            }

            for (int stars = i; stars > 0; stars--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
