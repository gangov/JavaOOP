package militaryeliteexercise;

public abstract class SpecialisedSoldierImpl extends PrivateImpl {
    private Corps corps;
    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    public Corps getCorps() {
        return this.corps;
    }
}
