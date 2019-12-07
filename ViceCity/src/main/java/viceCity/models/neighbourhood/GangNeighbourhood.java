package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        //main player shooting
//        for (Player civilPlayer : civilPlayers) {
//            for (Gun weapon : mainPlayer.getGunRepository().getModels()) {
//                while (civilPlayer.isAlive() && weapon.canFire()) {
//                    civilPlayer.takeLifePoints(weapon.fire());
//                }
//
//                if (!civilPlayer.isAlive()) {
//                    break;
//                }
//            }
//        }
//
//        for (Player npc : civilPlayers) {
//            if (!npc.isAlive()) {
//                continue;
//            }
//
//            for (Gun weapon : npc.getGunRepository().getModels()) {
//                while (mainPlayer.isAlive() && weapon.canFire()) {
//                    mainPlayer.takeLifePoints(weapon.fire());
//                }
//
//                if (!mainPlayer.isAlive()) {
//                    break;
//                }
//            }
//
//            if (!mainPlayer.isAlive()) {
//                break;
//            }
//        }
    }
}
