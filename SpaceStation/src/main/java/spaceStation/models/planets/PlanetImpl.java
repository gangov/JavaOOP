package spaceStation.models.planets;

import java.util.Collection;

public class PlanetImpl implements Planet {
    private String name;
    private Collection<String> items;

    public PlanetImpl(String name) {
        this.name = name;
    }

    @Override
    public Collection<String> getItems() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
