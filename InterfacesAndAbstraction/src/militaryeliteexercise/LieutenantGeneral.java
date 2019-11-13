package militaryeliteexercise;

import java.util.ArrayList;
import java.util.List;

public class LieutenantGeneral extends PrivateImpl{
    private List<Private> soldiersToCommand;

    public LieutenantGeneral(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.soldiersToCommand = new ArrayList<>();
    }

    public void add(Private priv) {
        this.soldiersToCommand.add(priv);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Name: %s %s Id: %d Salary: %.2f", this.getFirstName(), this.getLastName(), this.getId(), this.getSalary()))
                .append(System.lineSeparator());
        sb.append("Privates:").append(System.lineSeparator());
        for (Private aPrivate : this.soldiersToCommand) {
            sb.append(aPrivate.toString()).append(System.lineSeparator());
        }

        return super.toString().trim();
    }
}
