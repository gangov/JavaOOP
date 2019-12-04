package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.Collection;

public class AstronautRepository implements Repository {
    private Collection<Astronaut> astronauts;


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
