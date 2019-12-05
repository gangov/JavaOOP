package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.factories.AstronautFactory;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private Repository<Astronaut> astronautRepository;
    private Repository<Planet> planetRepository;
    private Mission mission;
    private int exploredPlanets = 0;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
        this.mission = new MissionImpl();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut = AstronautFactory.createAstronaut(type, astronautName);

        if (astronaut == null) {
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }

        this.astronautRepository.add(astronaut);

        return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        String[] inputItems = items;
        for (String inputItem : inputItems) {
            planet.getItems().add(inputItem);
        }

        this.planetRepository.add(planet);

        return String.format(ConstantMessages.PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = this.astronautRepository.findByName(astronautName);

        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        } else {
            this.astronautRepository.remove(astronaut);
        }

        return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        List<Astronaut> missionReady = this.astronautRepository.getModels()
                .stream()
                .filter(a -> a.getOxygen() > 60)
                .collect(Collectors.toCollection(ArrayList::new));

        if (missionReady.size() == 0) {
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        Planet planet = this.planetRepository.findByName(planetName);
        this.mission.explore(planet, missionReady);
        this.exploredPlanets++;
        long deadAstronauts = missionReady.stream().filter(a -> a.getOxygen() == 0).count();
        return String.format(ConstantMessages.PLANET_EXPLORED, planetName, deadAstronauts);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.REPORT_PLANET_EXPLORED, exploredPlanets)).append(System.lineSeparator());
        sb.append(ConstantMessages.REPORT_ASTRONAUT_INFO).append(System.lineSeparator());
        for (Astronaut astronaut : this.astronautRepository.getModels()) {
            sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME, astronaut.getName()))
                    .append(System.lineSeparator());
            sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN, astronaut.getOxygen()))
                    .append(System.lineSeparator());
            if (astronaut.getBag().getItems().size() == 0) {
                sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, "none"))
                        .append(System.lineSeparator());
            } else {
                for (String item : astronaut.getBag().getItems()) {
                    int count = 0;
                    if (count == astronaut.getBag().getItems().size()) {
                        sb.append(item);
                    } else {
                        sb.append(item).append(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER);
                    }
                }
            }
        }
        return sb.toString().trim();
    }
}
