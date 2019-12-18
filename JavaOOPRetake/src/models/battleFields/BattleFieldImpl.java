package models.battleFields;

import models.battleFields.interfaces.Battlefield;
import models.cards.interfaces.Card;
import models.players.interfaces.Player;

public class BattleFieldImpl implements Battlefield {

    @Override
    public void fight(Player attackPlayer, Player enemyPlayer) {
        if (attackPlayer.isDead() || enemyPlayer.isDead()) {
            throw new IllegalArgumentException("Player is dead!");
        }

        if (attackPlayer.getClass().getSimpleName().equals("Beginner")) {
            addHealthForBeginnerType(attackPlayer);
        }

        if (enemyPlayer.getClass().getSimpleName().equals("Beginner")) {
            addHealthForBeginnerType(enemyPlayer);
        }

        int attackPlayerHealthIncrease = increaseHeatlFromDeck(attackPlayer);
        attackPlayer.setHealth(attackPlayer.getHealth() + attackPlayerHealthIncrease);

        int enemyPlayerHealthIncrase = increaseHeatlFromDeck(enemyPlayer);
        enemyPlayer.setHealth(enemyPlayer.getHealth() + enemyPlayerHealthIncrase);

        while (true) {
            int attackerDamage = calculateDamage(attackPlayer);
            int enemyDamage = calculateDamage(enemyPlayer);

            enemyPlayer.takeDamage(attackerDamage);
            if (enemyPlayer.isDead()) {
                break;
            }


            attackPlayer.takeDamage(enemyDamage);
            if (attackPlayer.isDead()) {
                break;
            }
        }
    }

    private int calculateDamage(Player player) {
        int sum = 0;

        for (Card card : player.getCardRepository().getCards()) {
            sum += card.getDamagePoints();
        }

        return sum;
    }

    private int increaseHeatlFromDeck(Player player) {
        int sum = 0;
        for (Card card : player.getCardRepository().getCards()) {
            sum += card.getHealthPoints();
        }
        return sum;
    }

    private void addHealthForBeginnerType(Player attackPlayer) {
        attackPlayer.setHealth(attackPlayer.getHealth() + 40);
        for (Card card : attackPlayer.getCardRepository().getCards()) {
            card.setDamagePoints(card.getDamagePoints() + 30);
        }
    }
}
