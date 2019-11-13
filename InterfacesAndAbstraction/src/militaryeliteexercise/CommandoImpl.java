package militaryeliteexercise;

import java.util.ArrayList;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl {
    private List<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    public List<Mission> getMissions() {
        return this.missions;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Name: %s %s Id: %d Salary: %.2f", this.getFirstName(), this.getLastName(), this.getId(), this.getSalary()))
                .append(System.lineSeparator());
        sb.append("Corps: " + this.getCorps()).append(System.lineSeparator());
        sb.append("Missions:").append(System.lineSeparator());

        for (Mission mission : this.missions) {
            sb.append(mission.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
