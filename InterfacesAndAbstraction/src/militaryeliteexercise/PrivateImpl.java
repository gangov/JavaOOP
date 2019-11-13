package militaryeliteexercise;

public class PrivateImpl extends SoldierImpl implements Private, Soldier {
    private double salary;


    public PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public int getId() {
        return this.getId();
    }

    @Override
    public String getFirstName() {
        return this.getFirstName();
    }

    @Override
    public String getLastName() {
        return this.getLastName();
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d Salary: %.2f", this.getFirstName(), this.getLastName(),this.getId(), this.getSalary());
    }
}
