package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.Collection;

public class PlanetRepository implements Repository {
    private Collection<Planet> planets;

    @Override
    public Collection getModels() {
        return null;
    }

    @Override
    public void add(Object model) {

    }

    @Override
    public boolean remove(Object model) {
        return false;
    }

    @Override
    public Object findByName(String name) {
        return null;
    }
}
