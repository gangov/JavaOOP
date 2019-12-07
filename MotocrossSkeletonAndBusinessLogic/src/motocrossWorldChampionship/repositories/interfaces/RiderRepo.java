package motocrossWorldChampionship.repositories.interfaces;

import motocrossWorldChampionship.models.motorcycles.MotorcycleImpl;
import motocrossWorldChampionship.models.rider.RiderImpl;

import java.util.*;

public class RiderRepo implements Repository<RiderImpl> {

    private Map<String, RiderImpl> models;

    public RiderRepo() {
        this.models = new LinkedHashMap<>();
    }

    @Override
    public RiderImpl getByName(String name) {
        return this.models.get(name);
    }

    @Override
    public Collection<RiderImpl> getAll() {
        return Collections.unmodifiableCollection(this.models.values());
    }

    @Override
    public void add(RiderImpl model) {
        this.models.put(model.getName(), model);
    }

    @Override
    public boolean remove(RiderImpl model) {
        boolean result = false;
        RiderImpl removed = this.models.remove(model.getName());
        if (removed != null) {
            result = true;
        }
        return result;
    }
}
