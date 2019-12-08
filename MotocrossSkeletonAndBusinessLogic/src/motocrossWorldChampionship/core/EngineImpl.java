package motocrossWorldChampionship.core;

import motocrossWorldChampionship.core.interfaces.Engine;
import motocrossWorldChampionship.io.interfaces.InputReaderImpl;
import motocrossWorldChampionship.io.interfaces.OutputWriterImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EngineImpl implements Engine {
    private ChampionshipControllerImpl championshipController;
    private BufferedReader bufferedReader;
    private OutputWriterImpl writer;
    private ChampionshipControllerImpl championshipControllerImpl;

    public EngineImpl(ChampionshipControllerImpl championshipControllerImpl) {
        this.championshipController = championshipControllerImpl;
        this.writer = new OutputWriterImpl();
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {

        while (true) {
            String outputResult = null;
            try {
                outputResult = handleInput();
                if (outputResult == null || outputResult.equals("End")) {
                    System.exit(0);
                }
            } catch (NullPointerException | IllegalArgumentException | IOException e) {
                outputResult = e.getMessage();
            }

            writer.writeLine(outputResult);
        }
    }

    private String handleInput() throws IOException {
        String result = null;
        String[] data = this.bufferedReader.readLine().split("\\s+");

        String command = data[0];
        switch (command) {
            case "CreateRider":
                String name = data[1];
                result = championshipController.createRider(name);
                break;
            case "CreateMotorcycle":
                String type = data[1];
                String model = data[2];
                int horsePower = Integer.parseInt(data[3]);
                result = championshipController.createMotorcycle(type, model, horsePower);
                break;
            case "AddMotorcycleToRider":
                String riderName = data[1];
                String bikeName = data[2];
                result = championshipController.addMotorcycleToRider(riderName, bikeName);
                break;
            case "AddRiderToRace":
                String raceName = data[1];
                String riderNameToAdd = data[2];
                result = championshipController.addRiderToRace(raceName, riderNameToAdd);
                break;
            case "CreateRace":
                String raceNameToCreate = data[1];
                int laps = Integer.parseInt(data[2]);
                result = championshipController.createRace(raceNameToCreate, laps);
                break;
            case "StartRace":
                String raceNameToStart = data[1];
                result = championshipController.startRace(raceNameToStart);
                break;
        }

        return result;
    }
}
