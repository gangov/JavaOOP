package wildfarmexercise;

import java.text.DecimalFormat;

public class Tiger extends Felime {
    private String livingRegion;
    private boolean canEat = true;

    public Tiger(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (!food.getClass().getSimpleName().equals("Meat")) {
            canEat = false;
            this.setFoodEaten(0);
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        StringBuilder sb = new StringBuilder();
        if (!canEat) {
            sb.append("Tigers are not eating that type of food!").append(System.lineSeparator());
        }
        sb.append(String.format("%s[%s, %s, %s, %s]",
                super.getAnimalType(),
                super.getAnimalName(),
                df.format(super.getAnimalWeight()),
                super.getLivingRegion(),
                super.getFoodEaten()));

        return sb.toString().trim();
    }
}
