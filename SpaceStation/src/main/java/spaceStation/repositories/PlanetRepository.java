package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.*;

public class PlanetRepository implements Repository<Planet> {
    private List<Planet> planets;

    public PlanetRepository() {
        this.planets = new ArrayList<>();
    }

    @Override
    public Collection<Planet> getModels() {
        return Collections.unmodifiableCollection(this.planets);
    }

    @Override
    public void add(Planet model) {
        this.planets.add(model);
    }

    @Override
    public boolean remove(Planet model) {
        return this.planets.remove(model);
    }

    @Override
    public Planet findByName(String name) {
        int index = 0;
        for (Planet planet : planets) {
            if (name.equals(planet.getName())) {
                break;
            }
            index++;
        }
        return this.planets.get(index);
    }
}
