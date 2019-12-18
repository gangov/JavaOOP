package aquarium.models.decorations;

public class Plant extends BaseDecoration {
    private static final int FINAL_COMFORT = 5;
    private static final double FINAL_PRICE = 10;

    public Plant() {
        super(FINAL_COMFORT, FINAL_PRICE);
    }
}
