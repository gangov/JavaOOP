package animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            try {
                throw new IllegalArgumentException("Invalid input!");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input!");
            }
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            try {
                throw new IllegalArgumentException("Invalid input!");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input!");
            }
        }
        this.age = age;
    }

    public void setGender(String gender) {
        if (gender.isEmpty()) {
            try {
                throw new IllegalArgumentException("Invalid input!");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input!");
            }
        }
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    public String produceSound() {
        return "The sound of the animal";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName().trim());
        sb.append(System.lineSeparator());
        sb.append(this.getName() + " " + this.getAge() + " " + this.gender).trimToSize();
        sb.append(System.lineSeparator());
        sb.append(this.produceSound()).trimToSize();
        sb.trimToSize();

        return sb.toString().trim();
    }
}
