package pizzacaloriesexercise;

public enum DoughModifiers {
    White(1.5),
    Wholegrain(1.0),
    Crispy(0.9),
    Chewy(1.1),
    Homemade(1.0);

    private double value;

    DoughModifiers(double v) {
        this.value = v;
    }

    public double getValue() {
        return value;
    }
}
