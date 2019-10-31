package HotelReservationLab;

public class PriceCalculator {

    public static double totalCost(double getDailyPrice, int getDuration, Season season, Discount discount) {
        return getDailyPrice
                * getDuration
                * season.getSeasonMultiplier()
                * discount.getDiscount();
    }
}
