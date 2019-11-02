package RandomArrayListLab;
/*
Create a RandomArrayList class that has all the functionality of an ArrayList.
Add additional function that returns and removes a random element from the list.
Public method: getRandomElement(): Object
 */
public class Main {
    public static void main(String[] args) {
        RandomArrayList<Integer> array = new RandomArrayList<>();

        System.out.println(array.size());
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);

        System.out.println(array.getRandomElement());
        System.out.println(array.size());
    }
}
