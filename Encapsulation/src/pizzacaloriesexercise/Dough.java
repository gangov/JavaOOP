package pizzacaloriesexercise;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    // TODO: 7.11.19 validate if dough and backing technique is there
    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    public String getFlourType() {
        return flourType;
    }

    private void setFlourType(String flourType) {
        if (flourType == null || flourType.trim().isEmpty() || !checkFlourBakingValidity(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    public String getBakingTechnique() {
        return bakingTechnique;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (bakingTechnique == null || bakingTechnique.trim().isEmpty() || !checkFlourBakingValidity(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private boolean checkFlourBakingValidity(String flourType) {
        boolean isThere = false;
        for (DoughModifiers Flour : DoughModifiers.values()) {
            if (Flour.name().equals(flourType)) {
                isThere = true;
            }
        }
        return isThere;
    }

    public double getWeight() {
        return weight;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return (2 * this.getWeight()) * DoughModifiers.valueOf(this.getFlourType()).getValue() *
                DoughModifiers.valueOf(this.getBakingTechnique()).getValue();
    }
}
