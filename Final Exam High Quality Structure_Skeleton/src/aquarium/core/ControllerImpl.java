package aquarium.core;

import aquarium.common.ConstantMessages;
import aquarium.common.ExceptionMessages;
import aquarium.models.aquariums.Aquarium;
import aquarium.models.aquariums.FreshwaterAquarium;
import aquarium.models.aquariums.SaltwaterAquarium;
import aquarium.models.decorations.Decoration;
import aquarium.models.decorations.Ornament;
import aquarium.models.decorations.Plant;
import aquarium.models.fish.Fish;
import aquarium.models.fish.FreshwaterFish;
import aquarium.models.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class ControllerImpl implements Controller {

    private DecorationRepository decorations;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;

        switch (aquariumType) {
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                break;
            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                break;
            default:
                aquarium = null;
                break;
        }

        if (aquarium == null) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_AQUARIUM_TYPE);
        }

        this.aquariums.add(aquarium);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AQUARIUM_TYPE,
                aquarium.getClass().getSimpleName());
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;

        switch (type) {
            case "Ornament":
                decoration = new Ornament();
                break;
            case "Plant":
                decoration = new Plant();
                break;
            default:
                decoration = null;
                break;
        }

        if (decoration == null) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_DECORATION_TYPE);
        }

        this.decorations.add(decoration);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_TYPE,
                decoration.getClass().getSimpleName());
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {

        Decoration decorationToAdd = this.decorations.findByType(decorationType);

        if (decorationToAdd == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_DECORATION_FOUND, decorationType));
        }

        Aquarium aquariumToTakeDecoration = this.aquariums.stream().filter(aquarium -> aquarium.getName().equals(aquariumName)).findFirst().orElse(null);

        aquariumToTakeDecoration.addDecoration(decorationToAdd);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName,
                          String fishType, String fishName,
                          String fishSpecies, double price) {

        Fish fishToAdd;

        switch (fishType) {
            case "FreshwaterFish":
                fishToAdd = new FreshwaterFish(fishName, fishSpecies, price);
                break;
            case "SaltwaterFish":
                fishToAdd = new SaltwaterFish(fishName, fishSpecies, price);
                break;
            default:
                fishToAdd = null;
                break;
        }

        if (fishToAdd == null) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FISH_TYPE);
        }

        Aquarium aquariumToTakeFish = this.aquariums.stream().filter(aquarium -> aquarium.getName().equals(aquariumName)).findFirst().orElse(null);

        if (fishToAdd.getClass().getSimpleName().equals("FreshwaterFish") &&
                aquariumToTakeFish.getClass().getSimpleName().equals("FreshwaterAquarium")) {
            aquariumToTakeFish.addFish(fishToAdd);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM,
                    fishType, aquariumName);
        } else if (fishToAdd.getClass().getSimpleName().equals("SaltwaterFish") &&
                aquariumToTakeFish.getClass().getSimpleName().equals("SaltwaterAquarium")) {
            aquariumToTakeFish.addFish(fishToAdd);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM,
                    fishType, aquariumName);
        }

        return ConstantMessages.WATER_NOT_SUITABLE;
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquariumToFeedFish = this.aquariums.stream().filter(aquarium -> aquarium.getName().equals(aquariumName)).findFirst().orElse(null);

        aquariumToFeedFish.getFish().forEach(Fish::eat);

        return String.format(ConstantMessages.FISH_FED, aquariumToFeedFish.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquariumToGetValue = this.aquariums.stream().filter(aquarium -> aquarium.getName().equals(aquariumName)).findFirst().orElse(null);

        double price = 0;

        price += aquariumToGetValue.getFish().stream().mapToDouble(Fish::getPrice).sum();
        price += aquariumToGetValue.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();

        return String.format(ConstantMessages.VALUE_AQUARIUM, aquariumName, price);
    }

    @Override
    public String report() {

        StringBuilder sb = new StringBuilder();

        for (Aquarium aquarium : aquariums) {
            sb.append(aquarium.getInfo()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
