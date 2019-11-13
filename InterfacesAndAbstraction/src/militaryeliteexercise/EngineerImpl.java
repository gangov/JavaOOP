package militaryeliteexercise;

import java.util.ArrayList;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl {
    private List<Repair> repairs;
    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    public List<Repair> getRepairs() {
        return this.repairs;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Name: %s %s Id: %d Salary: %.2f", this.getFirstName(), this.getLastName(), this.getId(), this.getSalary()))
                .append(System.lineSeparator());
        sb.append("Corps: " + this.getCorps()).append(System.lineSeparator());
        sb.append("Repairs:").append(System.lineSeparator());
        for (Repair repair : this.repairs) {
            sb.append(repair.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
