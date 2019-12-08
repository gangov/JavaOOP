package motocrossWorldChampionship;

import motocrossWorldChampionship.core.ChampionshipControllerImpl;
import motocrossWorldChampionship.core.EngineImpl;
import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.models.motorcycles.PowerMotorcycle;
import motocrossWorldChampionship.models.motorcycles.SpeedMotorcycle;

public class Main {
    public static void main(String[] args) {
        ChampionshipControllerImpl championshipController = new ChampionshipControllerImpl();
        EngineImpl engine = new EngineImpl(championshipController);
        engine.run();
    }
}
