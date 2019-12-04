package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {

    private static final int INITIAL_OXYGEN = 70;

    protected Biologist(String name) {
        super(name, INITIAL_OXYGEN);
    }
}
