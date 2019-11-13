package militaryeliteexercise;

public class Mission {
    private String codeName;
    private State state;

    public Mission(String codeName, State state) {
        this.codeName = codeName;
        this.state = state;
    }

    public String getCodeName() {
        return this.codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public State getState() {
        return this.state;
    }

    public void completeMission() {
        this.state = State.finished;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Code Name: " + this.codeName + " State: " + this.state;
    }
}
