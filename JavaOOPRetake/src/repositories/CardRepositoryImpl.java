package repositories;

import models.cards.interfaces.Card;
import repositories.interfaces.CardRepository;

import java.util.ArrayList;
import java.util.List;

public class CardRepositoryImpl implements CardRepository {
    private List<Card> cards;

    public CardRepositoryImpl() {
        this.cards = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.cards.size();
    }

    @Override
    public List<Card> getCards() {
        return this.cards;
    }

    @Override
    public void add(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }

        if (this.cards.contains(card)) {
            throw new IllegalArgumentException(String.format("Player {username} already exists!", card.getName()));
        }

        this.cards.add(card);
    }

    @Override
    public boolean remove(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
        return this.cards.remove(card);
    }

    @Override
    public Card find(String name) {
        return this.cards.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    }
}
