package militaryeliteexercise;

public enum Corps {
    AIRFORCES("Airforces"),
    MARINES("Marines");

    private String value;

    Corps(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
