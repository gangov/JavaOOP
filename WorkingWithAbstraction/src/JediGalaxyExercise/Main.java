package JediGalaxyExercise;

import java.util.Arrays;
import java.util.Scanner;

/*
REFACTOR
Pesho is Jedi and so he starts gathering stars to grow stronger.
His galaxy is represented as a two-dimensional array. Every cell in the matrix is a star that has a value. Ivo starts at
the given col and row. He can move only on the diagonal from the lowest left to the upper right, and adds to his score
all the stars (values) from the cells he passes through. Unfortunately, there is always an Evil power that tries to
prevent his success.
Evil power starts at the given row and col and instantly destroys all stars on the opposite diagonal – From lowest right
to the upper left.
Ivo adds the values only of the stars that are not destroyed by the evil power.
You will receive two integers, separated by space, which represent the two dimensional array - the first being the rows
and the second being the columns. Then, you must fill the two dimensional array with increasing integers starting from
0, and continuing on every row, like this:  first row: 0, 1, 2… m second row: n+1, n+2, n+3… n + n.


Example:
Ivo starts with coordinates row = 5, col = -1. He must collect all stars with value [20, 16, 12, 8, 4]. Evil starts with
coordinates row = 5, col = 5. The Evil destroys all stars in range [24, 18, 12, 6, 0]. The star with value 12 is the
cross point for Ivo and The Evil, so Ivo skips the stars and collects only these who are not in the evil range.

You will also receive multiple pairs of commands in the form of 2 integers separated by a single space. The first two
integers will represent Ivo’s start coordinates. The second one will represent the Evil Power’s start coordinates.
The input ends when you receive the command "Let the Force be with you". When that happens, you must print the value of
all stars that Ivo has collected successfully.


Input
On the first line, you will receive the number N, M -> the dimensions of the matrix. You must then fill the matrix
according to these dimensions.
On the next several lines you will begin receiving 2 integers separated by a single space, which represent Ivo’s row and
col. On the next line you will receive the Evil Power’s coordinates.
There will always be at least 2 lines of input to represent at least 1 path of Ivo and the Evil force.
When you receive the command, "Let the Force be with you" the input ends.


Output
The output is simple. Print the sum of the values from all stars that Ivo has collected.


Constraints
The dimensions of the matrix will be integers in the range [5, 2000].
The given rows will be valid integers in the range [0, 2000].
The given columns will be valid integers in the range [-231 + 1, 231 - 1].
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimestions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimestions[0];
        int cols = dimestions[1];

        Matrix matrix = new Matrix(rows, cols);
        matrix.fillTheMatrix();

        String command = scanner.nextLine();
        long jediPower = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] jediStartLocation = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int jediRow = jediStartLocation[0];
            int jediCol = jediStartLocation[1];

            int[] evilStartLocation = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int evilRow = evilStartLocation[0];
            int evilCol = evilStartLocation[1];

            moveEvil(matrix, evilRow, evilCol);

            jediPower = moveJedi(matrix, jediPower, jediRow, jediCol);

            command = scanner.nextLine();
        }

        System.out.println(jediPower);

    }

    private static long moveJedi(Matrix matrix, long jediPower, int jediRow, int jediCol) {
        while (jediRow >= 0 && jediCol < matrix.getCol()) {
            if (jediRow < matrix.getRow() && jediCol >= 0 && jediCol < matrix.getCol()) {
                jediPower += matrix.returnNumber(jediRow, jediCol);
            }

            jediCol++;
            jediRow--;
        }
        return jediPower;
    }

    private static void moveEvil(Matrix matrix, int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (evilRow < matrix.getRow() && evilCol < matrix.getCol()) {
                matrix.setMatrix(evilRow, evilCol);
            }
            evilRow--;
            evilCol--;
        }
    }
}
