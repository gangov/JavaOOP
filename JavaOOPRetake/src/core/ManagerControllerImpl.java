package core;

import common.ConstantMessages;
import core.interfaces.ManagerController;
import models.battleFields.interfaces.BattleFieldImpl;
import models.battleFields.interfaces.Battlefield;
import models.cards.interfaces.Card;
import models.cards.interfaces.MagicCard;
import models.cards.interfaces.TrapCard;
import models.players.interfaces.Advanced;
import models.players.interfaces.BasePlayer;
import models.players.interfaces.Beginner;
import models.players.interfaces.Player;
import repositories.interfaces.CardRepository;
import repositories.interfaces.CardRepositoryImpl;
import repositories.interfaces.PlayerRepository;
import repositories.interfaces.PlayerRepositoryImpl;


public class ManagerControllerImpl implements ManagerController {
    private PlayerRepository playerRepository;
    private CardRepository cardRepository;
    private Battlefield battleField;

    public ManagerControllerImpl() {
        //TODO:IMPLEMENT ME
        this.playerRepository = new PlayerRepositoryImpl();
        this.cardRepository = new CardRepositoryImpl();
        this.battleField = new BattleFieldImpl();
    }

    @Override
    public String addPlayer(String type, String username) {
        BasePlayer player;
        switch (type) {
            case "Beginner":
                player = new Beginner(new CardRepositoryImpl(), username);
                break;
            case "Advanced":
                player = new Advanced(new CardRepositoryImpl(), username);
                break;
            default:
                player = null;
                break;
        }
        this.playerRepository.add(player);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER, type, username);
    }

    @Override
    public String addCard(String type, String name) {
        Card card;
        switch (type) {
            case "MagicCard":
                card = new MagicCard(name);
                break;
            case "TrapCard":
                card = new TrapCard(name);
                break;
            default:
                card = null;
                break;
        }

        this.cardRepository.add(card);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CARD, type, name);
    }

    @Override
    public String addPlayerCard(String username, String cardName) {
        Player receiver = this.playerRepository.find(username);
        Card cardToAdd = this.cardRepository.find(cardName);
        receiver.getCardRepository().add(cardToAdd);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_WITH_CARDS, cardName, username);
    }

    @Override
    public String fight(String attackUser, String enemyUser) {
        Player attacker = this.playerRepository.find(attackUser);
        Player enemy = this.playerRepository.find(enemyUser);
        this.battleField.fight(attacker, enemy);
        return String.format(ConstantMessages.FIGHT_INFO, attacker.getHealth(), enemy.getHealth());
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        for (Player player : this.playerRepository.getPlayers()) {
            sb.append(player.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
