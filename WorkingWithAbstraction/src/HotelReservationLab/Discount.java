package HotelReservationLab;

public enum Discount {
    VIP(0.8),
    SecondVisit(0.9),
    None(1);

    private double percent;

    Discount(double percent) {
        this.percent = percent;
    }

    public double getDiscount() {
        return this.percent;
    }
}

