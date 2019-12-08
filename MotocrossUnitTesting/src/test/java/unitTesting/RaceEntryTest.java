package unitTesting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

public class RaceEntryTest {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS RaceEntry

    private RaceEntry raceEntry;
    private UnitMotorcycle bike;
    private UnitRider rider;

    @Before
    public void createBasicContructor() {
        raceEntry = new RaceEntry();
        bike = new UnitMotorcycle("Kavazaki", 200, 600.00);
        rider = new UnitRider("Ivan", bike);

    }

    @Test
    public void testingConstructor() {
        RaceEntry test = new RaceEntry();
        Collection<UnitRider> riders = test.getRiders();
        Assert.assertEquals(0, riders.size());
    }

    @Test(expected = NullPointerException.class)
    public void addingNullRiderTest() {
        raceEntry.addRider(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addingDuplicateTest() {
        raceEntry.addRider(rider);
        raceEntry.addRider(rider);
    }

    @Test
    public void addingRiderShouldIncreaseSize() {
        raceEntry.addRider(rider);
        int size = raceEntry.getRiders().size();
        Assert.assertEquals(1, size);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateAverageHorsePowerLessThanTwo() {
        raceEntry.addRider(rider);
        raceEntry.calculateAverageHorsePower();
    }

    @Test
    public void calculateAverageHorsePower() {
        raceEntry.addRider(rider);
        raceEntry.addRider(new UnitRider("Pesho", new UnitMotorcycle("Yamaha", 90, 350.00)));
        double averageHorsePower = raceEntry.calculateAverageHorsePower();
        Assert.assertEquals(145.00, averageHorsePower, 0.00001);
    }

    @Test
    public void getRidersTest() {
        LinkedHashMap<String, UnitRider> alltheRiders = new LinkedHashMap<>();

        UnitRider two = new UnitRider("Pesho", new UnitMotorcycle("Yamaha", 90, 350.00));
        UnitRider three = new UnitRider("Misho", new UnitMotorcycle("Suzuki", 145, 1800.00));

        alltheRiders.put(rider.getName(), rider);
        alltheRiders.put(two.getName(), two);
        alltheRiders.put(three.getName(), three);


        raceEntry.addRider(rider);
        raceEntry.addRider(two);
        raceEntry.addRider(three);

        Assert.assertFalse(alltheRiders.values().equals(raceEntry.getRiders()));
    }

    @Test
    public void checkForUnmodifiable() {
        Assert.assertTrue(raceEntry.getRiders().getClass().getSimpleName().equals("UnmodifiableCollection"));
    }
}
