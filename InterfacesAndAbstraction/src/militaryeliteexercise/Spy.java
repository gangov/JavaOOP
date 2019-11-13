package militaryeliteexercise;

public class Spy implements Soldier {
    private int id;
    private String firstName;
    private String lastName;
    private String codeNumber;

    public Spy(int id, String firstName, String lastName, String codeNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.codeNumber = codeNumber;
    }

    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %d", this.firstName, this.lastName, this.id)).append(System.lineSeparator());
        sb.append("Code Number: " + this.codeNumber).append(System.lineSeparator());
        return sb.toString().trim();
    }
}
