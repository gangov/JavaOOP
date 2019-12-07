package motocrossWorldChampionship.repositories.interfaces;

import motocrossWorldChampionship.models.race.RaceImpl;
import motocrossWorldChampionship.models.rider.RiderImpl;

import java.util.*;

public class RaceRepo implements Repository<RaceImpl> {
    private Map<String, RaceImpl> models;

    public RaceRepo() {
        this.models = new LinkedHashMap<>();
    }

    @Override
    public RaceImpl getByName(String name) {
        return this.models.get(name);
    }

    @Override
    public Collection<RaceImpl> getAll() {
        return Collections.unmodifiableCollection(this.models.values());
    }

    @Override
    public void add(RaceImpl model) {
        this.models.put(model.getName(), model);
    }

    @Override
    public boolean remove(RaceImpl model) {
        boolean result = false;
        RaceImpl removed = this.models.remove(model.getName());
        if (removed != null) {
            result = true;
        }
        return result;
    }
}
