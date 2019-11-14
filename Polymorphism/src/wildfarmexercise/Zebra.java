package wildfarmexercise;

public class Zebra extends Mammal {
    private boolean canEat = true;
    public Zebra(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (!food.getClass().getSimpleName().equals("Vegetable")) {
            canEat = false;
            this.setFoodEaten(this.getFoodEaten() - getFoodEaten());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!canEat) {
            sb.append("Zebras are not eating that type of food!").append(System.lineSeparator());
        }
        sb.append(super.toString());

        return sb.toString().trim();
    }
}
