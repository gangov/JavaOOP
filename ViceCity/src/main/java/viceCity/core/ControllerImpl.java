package viceCity.core;

import viceCity.common.ConstantMessages;
import viceCity.common.ExceptionMessages;
import viceCity.core.interfaces.Controller;
import viceCity.factories.GunFactory;
import viceCity.models.guns.Gun;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {
    private Player mainPlayer;
    private CivilPlayer npc;
    private List<Player> civilPlayers;
    private List<Gun> allWeapons;
    private static int INDEX = 0;
    private GangNeighbourhood gangNeighbourhood;

    public ControllerImpl() {
        mainPlayer = new MainPlayer();
        this.civilPlayers = new ArrayList<>();
        this.allWeapons = new ArrayList<>();
        this.gangNeighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        npc = new CivilPlayer(name);
        civilPlayers.add(npc);
        return String.format(ConstantMessages.PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun = GunFactory.createGun(type, name);
        if (gun == null) {
            return ConstantMessages.GUN_TYPE_INVALID;
        }
        allWeapons.add(gun);
        return String.format(ConstantMessages.GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        if (allWeapons.size() == 0) {
            return ConstantMessages.GUN_QUEUE_IS_EMPTY;
        }

        Gun weapon = allWeapons.remove(0);

        if (name.equals("Vercetti")) {
            mainPlayer.getGunRepository().add(weapon);
            return String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER, weapon.getName(), mainPlayer.getName());
        }

        if (!hasNPSWithGivenName(name)) {
            return ConstantMessages.CIVIL_PLAYER_DOES_NOT_EXIST;
        }

        civilPlayers.get(INDEX).getGunRepository().add(weapon);

        return String.format(ConstantMessages.GUN_ADDED_TO_CIVIL_PLAYER, name, civilPlayers.get(INDEX).getName());
    }

    private boolean hasNPSWithGivenName(String name) {
        for (Player civilPlayer : civilPlayers) {
            if (civilPlayer.getName().equals(name)) {
                return true;
            }
            INDEX++;
        }
        return false;
    }

    @Override
    public String fight() {
        StringBuilder sb = new StringBuilder();
        gangNeighbourhood.action(mainPlayer, civilPlayers);
        long killed = civilPlayers.stream().filter(player -> player.getLifePoints() == 0).count();
        long alive = civilPlayers.stream().filter(player -> player.getLifePoints() > 0).count();
        if (mainPlayer.getLifePoints() == 100 && allNPCNoDamage(civilPlayers)) {
            sb.append(ConstantMessages.FIGHT_HOT_HAPPENED);
        } else {
            sb.append(ConstantMessages.FIGHT_HAPPENED).append(System.lineSeparator());
            sb.append(String.format(ConstantMessages.MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints()))
                    .append(System.lineSeparator());
            sb.append(String.format(ConstantMessages.MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, killed))
                    .append(System.lineSeparator());
            sb.append(String.format(ConstantMessages.CIVIL_PLAYERS_LEFT_MESSAGE, alive));
        }
        return sb.toString().trim();
    }

    private boolean allNPCNoDamage(List<Player> civilPlayers) {
        long count = civilPlayers.stream().filter(p -> p.getLifePoints() == 50).count();
        return count == civilPlayers.size();
    }
}
