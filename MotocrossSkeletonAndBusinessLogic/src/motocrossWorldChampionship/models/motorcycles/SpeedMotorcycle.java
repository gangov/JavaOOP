package motocrossWorldChampionship.models.motorcycles;

public class SpeedMotorcycle extends MotorcycleImpl {
    private static final double CUBIC_CENTIMETERS = 125;
    private static final int MODEL_HORSE_POWER_LOWER_LIMIT = 50;
    private static final int MODEL_HORSE_POWER_UPPER_LIMIT = 69;

    public SpeedMotorcycle(String model, int horsePower) {
        super(model, horsePower, CUBIC_CENTIMETERS);
        this.setHorsePower(horsePower, MODEL_HORSE_POWER_LOWER_LIMIT, MODEL_HORSE_POWER_UPPER_LIMIT);
    }

    @Override
    public void setHorsePower(int horsePower, int MODEL_HORSE_POWER_LOWER_LIMIT, int MODEL_HORSE_POWER_UPPER_LIMIT) {
        super.setHorsePower(horsePower, this.MODEL_HORSE_POWER_LOWER_LIMIT, this.MODEL_HORSE_POWER_UPPER_LIMIT);
    }
}
