package HotelReservationLab;

public enum Season {
    Autumn(1),
    Spring(2),
    Winter(3),
    Summer(4);


    private int times;

    Season(int times) {
        this.times = times;
    }

    public int getSeasonMultiplier() {
        return this.times;
    }
}

