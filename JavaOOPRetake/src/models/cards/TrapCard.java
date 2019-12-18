package models.cards.interfaces;

public class TrapCard extends BaseCard {
    private static final int defaultDamagePoints = 5;
    private static final int defaultHealthPoints = 80;


    public TrapCard(String name) {
        super(name, defaultDamagePoints, defaultHealthPoints);
    }
}
