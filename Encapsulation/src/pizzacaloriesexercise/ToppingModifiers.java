package pizzacaloriesexercise;

public enum ToppingModifiers {
    Meat(1.2),
    Veggies(0.8),
    Cheese(1.1),
    Sauce(0.9);

    private double value;

    ToppingModifiers(double v) {
        this.value = v;
    }

    public double getValue() {
        return value;
    }
}
