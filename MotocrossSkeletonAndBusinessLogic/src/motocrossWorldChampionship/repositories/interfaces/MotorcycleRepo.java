package motocrossWorldChampionship.repositories.interfaces;

import motocrossWorldChampionship.models.motorcycles.MotorcycleImpl;

import java.util.*;

public class MotorcycleRepo implements Repository<MotorcycleImpl> {

    private Map<String, MotorcycleImpl> models;

    public MotorcycleRepo() {
        this.models = new LinkedHashMap<>();
    }


    @Override
    public MotorcycleImpl getByName(String name) {
        return this.models.get(name);
    }

    @Override
    public Collection<MotorcycleImpl> getAll() {
        return Collections.unmodifiableCollection(this.models.values());
    }

    @Override
    public void add(MotorcycleImpl model) {
        this.models.put(model.getModel(), model);
    }

    @Override
    public boolean remove(MotorcycleImpl model) {
        boolean result = false;
        MotorcycleImpl removed = this.models.remove(model.getModel());
        if (removed != null) {
            result = true;
        }
        return result;
    }
}
