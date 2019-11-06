package pizzacaloriesexercise;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.toppings = new ArrayList<>(numberOfToppings);
    }

    private void setToppings(int num) {
        if (num < 0 || num > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = toppings;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return this.name;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        double totalToppingCalories = 0;
        for (Topping topping : toppings) {
            totalToppingCalories += topping.calculateCalories();
        }
        return dough.calculateCalories() + totalToppingCalories;
    }
}
