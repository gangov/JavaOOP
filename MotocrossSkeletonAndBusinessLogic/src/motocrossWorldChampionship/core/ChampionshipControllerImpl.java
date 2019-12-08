package motocrossWorldChampionship.core;

import motocrossWorldChampionship.common.ExceptionMessages;
import motocrossWorldChampionship.common.OutputMessages;
import motocrossWorldChampionship.core.interfaces.ChampionshipController;
import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.models.motorcycles.MotorcycleImpl;
import motocrossWorldChampionship.models.motorcycles.PowerMotorcycle;
import motocrossWorldChampionship.models.motorcycles.SpeedMotorcycle;
import motocrossWorldChampionship.models.race.RaceImpl;
import motocrossWorldChampionship.models.rider.RiderImpl;
import motocrossWorldChampionship.repositories.interfaces.MotorcycleRepo;
import motocrossWorldChampionship.repositories.interfaces.RaceRepo;
import motocrossWorldChampionship.repositories.interfaces.RiderRepo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChampionshipControllerImpl implements ChampionshipController {
    private static final int MINIMUM_PARTICIPANTS = 3;
    private RiderRepo riderRepo;
    private MotorcycleRepo motorcycleRepo;
    private RaceRepo raceRepo;

    public ChampionshipControllerImpl() {
        this.riderRepo = new RiderRepo();
        this.motorcycleRepo = new MotorcycleRepo();
        this.raceRepo = new RaceRepo();
    }

    @Override
    public String createRider(String riderName) {
        RiderImpl rider = new RiderImpl(riderName);
        if (!checkRiderExists(riderName, this.riderRepo)) {
            this.riderRepo.add(rider);
            return String.format(OutputMessages.RIDER_CREATED, riderName);
        } else {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RIDER_EXISTS, riderName));
        }
    }

    @Override
    public String createMotorcycle(String type, String model, int horsePower) {
        MotorcycleImpl bike;
        switch (type) {
            case "Speed":
                bike = new SpeedMotorcycle(model, horsePower);
                break;
            case "Power":
                bike = new PowerMotorcycle(model, horsePower);
                break;
            default:
                bike = null;
                break;
        }

        if (!checkMotorcycleExists(model, this.motorcycleRepo)) {
            this.motorcycleRepo.add(bike);
            return String.format(OutputMessages.MOTORCYCLE_CREATED, type + "Motorcycle", model);
        } else {
            throw new IllegalArgumentException(String.format(ExceptionMessages.MOTORCYCLE_EXISTS, model));
        }
    }

    @Override
    public String addMotorcycleToRider(String riderName, String motorcycleModel) {
        boolean riderHere = checkRiderExists(riderName, this.riderRepo);
        boolean motorcycleHere = checkMotorcycleExists(motorcycleModel, this.motorcycleRepo);

        if (!riderHere) {
            throw new NullPointerException(String.format(ExceptionMessages.RIDER_NOT_FOUND, riderName));
        }

        if (!motorcycleHere) {
            throw new NullPointerException(String.format(ExceptionMessages.MOTORCYCLE_NOT_FOUND, motorcycleModel));
        }

        MotorcycleImpl bikeToAdd = this.motorcycleRepo.getByName(motorcycleModel);

        this.riderRepo.getByName(riderName).addMotorcycle(bikeToAdd);

        return String.format(OutputMessages.MOTORCYCLE_ADDED, riderName, motorcycleModel);
    }

    private boolean checkMotorcycleExists(String motorcycleModel, MotorcycleRepo motorcycleRepo) {
        return motorcycleRepo.getAll().stream().anyMatch(m -> m.getModel().equals(motorcycleModel));
    }

    private boolean checkRiderExists(String riderName, RiderRepo riderRepo) {
        return riderRepo.getAll().stream().anyMatch(r -> r.getName().equals(riderName));
    }

    private boolean checkRaceExists(String raceName, RaceRepo raceRepo) {
        return raceRepo.getAll().stream().anyMatch(race -> race.getName().equals(raceName));
    }

    @Override
    public String addRiderToRace(String raceName, String riderName) {
        boolean raceHere = checkRaceExists(raceName, this.raceRepo);
        boolean riderHere = checkRiderExists(riderName, this.riderRepo);
        if (!raceHere) {
            throw new NullPointerException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }

        if (!riderHere) {
            throw new NullPointerException(String.format(ExceptionMessages.RIDER_NOT_FOUND, riderName));
        }

        RiderImpl riderToAdd = this.riderRepo.getByName(riderName);
        this.raceRepo.getByName(raceName).addRider(riderToAdd);
        return String.format(OutputMessages.RIDER_ADDED, riderName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        boolean raceHere = checkRaceExists(raceName, this.raceRepo);
        if (!raceHere) {
            throw new NullPointerException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }

        if (this.raceRepo.getByName(raceName).getRiders().size() < MINIMUM_PARTICIPANTS) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_INVALID, raceName, MINIMUM_PARTICIPANTS));
        }

        RaceImpl raceToRemove = this.raceRepo.getAll().stream().filter(race -> race.getName().equals(raceName)).findFirst().orElse(null);
        this.raceRepo.remove(raceToRemove);

        List<Rider> sorted = raceToRemove.getRiders().stream().sorted((r1, r2) -> r2.getNumberOfWins() - r1.getNumberOfWins()).collect(Collectors.toList());

        Rider winner = sorted.get(0);
        Rider second = sorted.get(1);
        Rider third = sorted.get(2);


        StringBuilder sb = new StringBuilder();
        sb.append(String.format(OutputMessages.RIDER_FIRST_POSITION, winner.getName(), raceName)).append(System.lineSeparator());
        sb.append(String.format(OutputMessages.RIDER_SECOND_POSITION, second.getName(), raceName)).append(System.lineSeparator());
        sb.append(String.format(OutputMessages.RIDER_THIRD_POSITION, third.getName(), raceName)).append(System.lineSeparator());

        return sb.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {
        boolean raceHere = checkRaceExists(name, this.raceRepo);
        if (raceHere) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_EXISTS, name));
        }

        RaceImpl raceToAdd = new RaceImpl(name, laps);

        this.raceRepo.add(raceToAdd);
        return String.format(OutputMessages.RACE_CREATED, name);
    }

}
