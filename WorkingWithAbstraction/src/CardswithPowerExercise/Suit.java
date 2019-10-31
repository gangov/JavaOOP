package CardswithPowerExercise;

public enum Suit {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int value;
    Suit(int value) {
        this.value = value;
    }

    public int getSuit() {
        return this.value;
    }
}
