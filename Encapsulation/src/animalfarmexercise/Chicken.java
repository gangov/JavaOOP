package animalfarmexercise;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private int getAge() {
        return age;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        if (this.getAge() >= 0 && this.getAge() <= 5) {
            return 2.0;
        } else if (this.getAge() >= 6 && this.getAge() <= 11) {
            return 1.0;
        } else {
            return 0.75;
        }
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %s) can produce %.2f eggs per day.",
                this.getName(),
                this.getAge(),
                this.productPerDay());
    }
}
