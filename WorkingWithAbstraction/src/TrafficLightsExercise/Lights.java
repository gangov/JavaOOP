package TrafficLightsExercise;

public enum Lights {
    RED, GREEN, YELLOW {
        @Override
        public Lights next() {
            return values()[0]; // see below for options for this line
        };
    };

    public Lights next() {
        // No bounds checking required here, because the last instance overrides
        return values()[ordinal() + 1];
    }
}
