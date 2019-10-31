package PointInRectangleLab;

import java.util.Arrays;
import java.util.Scanner;

/*
Create a class Point and a class Rectangle. The Point should hold coordinates X and Y and the Rectangle should hold 2
Points – its bottom left and top right corners. In the Rectangle class, you should implement a contains(Point point)
method that returns true or false, based on whether the Point given as attribute is inside or outside of the Rectangle
object. Points on the side of a Square are considered inside.


Input
On the first line read the coordinates of the bottom left and top right corner of the Rectangle in the format:
“<bottomLeftX> <bottomLeftY> <topRightX> <topRightY>”.
On the second line, read an integer N and on the next N lines, read the coordinates of points.


Output
For each point, print out the result of the Contains() method.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Point bottomLeft = new Point(input[0], input[1]);
        Point topRight = new Point(input[2], input[3]);
        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            int[] compare = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int currentX = compare[0];
            int currentY = compare[1];
            Point toCheck = new Point(currentX, currentY);
            System.out.println(rectangle.contains(toCheck));
        }
    }
}
