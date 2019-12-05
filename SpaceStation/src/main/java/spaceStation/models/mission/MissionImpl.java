package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.Collection;

public class MissionImpl implements Mission {
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        for (Astronaut astronaut : astronauts) {
            if (astronaut.canBreath()) {
                Collection<String> items = planet.getItems();
                for (String item : items) {
                    astronaut.getBag().getItems().add(item);
                    planet.getItems().remove(item);
                    astronaut.breath();

                    if (!astronaut.canBreath()) {
                        break;
                    }
                }
            }
        }
    }
}
