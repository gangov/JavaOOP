package motocrossWorldChampionship.models.race;

import motocrossWorldChampionship.common.ExceptionMessages;
import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.entities.interfaces.Rider;

import java.util.ArrayList;
import java.util.Collection;

public class RaceImpl implements Race {

    private static final int RACE_NAME_SIZE_LIMIT = 5;

    private String name;
    private int laps;
    private Collection<Rider> riders;

    public RaceImpl(String name, int laps) {
        this.setName(name);
        this.setLaps(laps);
        this.riders = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.length() < RACE_NAME_SIZE_LIMIT || name.trim().isEmpty()) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NAME, name, RACE_NAME_SIZE_LIMIT));
        }
        this.name = name;
    }

    private void setLaps(int laps) {
        if (laps < 1) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_LAPS);
        }
        this.laps = laps;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    @Override
    public Collection<Rider> getRiders() {
        return this.riders;
    }

    @Override
    public void addRider(Rider rider) {
        if (rider == null) {
            throw new NullPointerException(ExceptionMessages.RIDER_INVALID);
        }
        if (!rider.getCanParticipate()) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RIDER_NOT_PARTICIPATE, rider.getName()));
        }
        if (riders.contains(rider)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RIDER_ALREADY_ADDED, rider.getName(), this.name));
        }

        this.riders.add(rider);
    }
}
