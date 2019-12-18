package motocrossWorldChampionship.models.motorcycles;

import motocrossWorldChampionship.common.ExceptionMessages;
import motocrossWorldChampionship.entities.interfaces.Motorcycle;

public abstract class MotorcycleImpl implements Motorcycle {
    private static final int MODEL_NAME_SIZE_LIMIT = 4;
    private static int MODEL_HORSE_POWER_LOWER_LIMIT;
    private static int MODEL_HORSE_POWER_UPPER_LIMIT;


    private String model;
    private int horsePower;
    private double cubicCentimeters;

    protected MotorcycleImpl(String model, int horsePower, double cubicCentimeters) {
        this.setModel(model);
        this.setHorsePower(horsePower, MODEL_HORSE_POWER_LOWER_LIMIT, MODEL_HORSE_POWER_UPPER_LIMIT);
        this.setCubicCentimeters(cubicCentimeters);
    }

    public void setModel(String model) {
        if (model == null || model.length() < MODEL_NAME_SIZE_LIMIT  || model.trim().isEmpty()) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_MODEL, model, MODEL_NAME_SIZE_LIMIT));
        }
        this.model = model;
    }

    public void setHorsePower(int horsePower, int MODEL_HORSE_POWER_LOWER_LIMIT, int MODEL_HORSE_POWER_UPPER_LIMIT) {
        if (horsePower < MODEL_HORSE_POWER_LOWER_LIMIT || horsePower > MODEL_HORSE_POWER_UPPER_LIMIT) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER, horsePower));
        }
        this.horsePower = horsePower;
    }

    public void setCubicCentimeters(double cubicCentimeters) {
        this.cubicCentimeters = cubicCentimeters;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return this.cubicCentimeters / (this.horsePower * laps);
    }
}
