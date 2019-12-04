package spaceStation.models.astronauts;

import spaceStation.models.bags.Bag;

public class BaseAstronaut implements Astronaut {

    private String name;
    private double oxygen;
    private Bag bag;

    protected BaseAstronaut(String name, double oxygen) {
        this.name = name;
        this.oxygen = oxygen;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getOxygen() {
        return 0;
    }

    @Override
    public boolean canBreath() {
        return false;
    }

    @Override
    public Bag getBag() {
        return null;
    }

    @Override
    public void breath() {

    }
}
