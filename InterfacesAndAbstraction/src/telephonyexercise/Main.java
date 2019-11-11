package telephonyexercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
You have a business - manufacturing cell phones. But you have no software developers, so you call your friends and ask
them to help you create a cell phone software. They agree and you start working on the project. The project consists of
one main model - a Smartphone. Each of your smartphones should have functionalities of calling other phones and browsing
in the world wide web.
Your friends are very busy, so you decide to write the code on your own. Here is the mandatory assignment:
You should have a model - Smartphone and two separate functionalities which your smartphone has - to call other phones
and to browse in the world wide web. You should end up with one class and two interfaces.

 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> nums = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        List<String> sites = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Smartphone smartphone = new Smartphone(nums, sites);
        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }
}
