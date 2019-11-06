package pizzacaloriesexercise;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    public String getToppingType() {
        return toppingType;
    }

    private void setToppingType(String toppingType) {
        if (!checkTopping(toppingType)) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.",
                    toppingType));
        }
        this.toppingType = toppingType;
    }

    private boolean checkTopping(String toppingType) {
        for (ToppingModifiers topping : ToppingModifiers.values()) {
            if (toppingType.equals(topping.name())) {
                return true;
            }
        }

        return false;
    }

    public double getWeight() {
        return weight;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].",
                    this.toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return (2 * this.getWeight()) *
                ToppingModifiers.valueOf(this.getToppingType()).getValue();

    }
}
