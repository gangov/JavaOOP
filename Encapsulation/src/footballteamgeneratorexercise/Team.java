package footballteamgeneratorexercise;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String nameToRemove) {
        if (!checkPlayer(nameToRemove)) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", nameToRemove, this.getName()));
        }
        int index = getIndex(nameToRemove);

        this.players.remove(index);
    }

    private boolean checkPlayer(String nameToRemove) {
        boolean isHere = false;

        for (Player player : this.players) {
            if (nameToRemove.equals(player.getName())) {
                isHere = true;
                break;
            }
        }

        return isHere;
    }

    private int getIndex(String nameToRemove) {
        int index = 0;
        for (Player player : players) {
            if (player.getName().equals(nameToRemove)) {
                break;
            }
            index++;
        }
        return index;
    }

    public double getRating() {
        int playersCount = this.players.size();
        double totalRating = 0;

        for (Player player : this.players) {
            totalRating += player.overallSkillLevel();
        }

        return totalRating / playersCount;
    }
}
