package GreedyTimesExercise;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/*
Finally, you have unlocked the safe and reached the treasure! Inside there are all kinds of gems, cash in different
currencies and gold bullions. Next to you there is a bag which unfortunately has a limited space. You don’t have much
time so you need to take as much wealth as possible! But in order to get a bigger amount of the most valuable items, you
need to keep the following rules:
The gold amount in your bag should always be more than or equal to the gem amount at any time
The gem amount should always be more than or equal to the cash amount at any time
If you read an item which breaks one of these rules you should not put it in the bag. You should always be careful not
to exceed the overall bag’s capacity, because it will tear down and you will lose everything! You will receive the
content of the safe on a single line in the format "item quantity" pairs, separated by whitespace. You need to gather
only three types of items:
Cash - All three letter items
Gem - All items which end on “Gem” (at least 4 symbols)
Gold - this type has only one item with the name - “Gold”
Each item which does not fall in one of the above categories is useless and you should skip it. Reading item’s names
should be CASE-INSENSITIVE. You should aggregate item’s quantities which have the same name.
If you’ve kept the rules you should escape successfully with a bag full of wealth. Now it’s time to review what you have
managed to get out of the safe. Print all the types ordered by total amount in descending order. Inside a type, order
the items first alphabetically in descending order and then by their amount in ascending order. Use the format described
below for each type.


Input
On the first line, you will receive a number which represents the capacity of the bag
On the second line, you will receive a sequence of item and quantity pairs


Output
Print only the types from which you have items in the bag ordered by Total Amount descending. Inside a type order the
items first alphabetically in descending order and then by amount in ascending order. Use the following format for each
type:
"<{type}> ${total amount}"
"##{item} - {amount}" - each item on new line


Constraints
Bag’s max capacity will always be a positive number
All quantities will be positive integer in the range [0 … 2100000000]
Each item of type gem will have a name - at least 4 symbols
Time limit: 0.1 sec. Memory limit: 16 MB
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] safeContent = scanner.nextLine().split("\\s+");

        var bag = new LinkedHashMap<String, LinkedHashMap<String, Long>>();
        long gold = 0;
        long gems = 0;
        long cash = 0;

        for (int i = 0; i < safeContent.length; i += 2) {
            String itemType = safeContent[i];
            long amount = Long.parseLong(safeContent[i + 1]);

            String currentItem = "";

            if (itemType.length() == 3) {
                currentItem = "Cash";
            } else if (itemType.toLowerCase().endsWith("gem")) {
                currentItem = "Gem";
            } else if (itemType.toLowerCase().equals("gold")) {
                currentItem = "Gold";
            }

            if (currentItem.equals("")) {
                continue;
            } else if (bagCapacity < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + amount) {
                continue;
            }

            switch (currentItem) {
                case "Gem":
                    if (!bag.containsKey(currentItem)) {
                        if (bag.containsKey("Gold")) {
                            if (amount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(currentItem).values().stream().mapToLong(e -> e).sum() + amount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(currentItem)) {
                        if (bag.containsKey("Gem")) {
                            if (amount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(currentItem).values().stream().mapToLong(e -> e).sum() + amount > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!bag.containsKey(currentItem)) {
                bag.put((currentItem), new LinkedHashMap<String, Long>());
            }

            if (!bag.get(currentItem).containsKey(itemType)) {
                bag.get(currentItem).put(itemType, 0L);
            }


            bag.get(currentItem).put(itemType, bag.get(currentItem).get(itemType) + amount);
            if (currentItem.equals("Gold")) {
                gold += amount;
            } else if (currentItem.equals("Gem")) {
                gems += amount;
            } else if (currentItem.equals("Cash")) {
                cash += amount;
            }
        }

        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }
}
