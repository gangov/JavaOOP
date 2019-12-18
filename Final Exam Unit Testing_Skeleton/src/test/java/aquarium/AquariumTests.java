package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AquariumTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Aquarium
    private Aquarium aquarium;
    private Fish fishOne;
    private Fish fishTwo;

    @Before
    public void initiateAnAquarium() {
        aquarium = new Aquarium("Test", 10);
        fishOne = new Fish("Nemo");
        fishTwo = new Fish("Pesho");
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Test", aquarium.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameNull() {
        Aquarium test = new Aquarium(null, 1);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameEmpty() {
        Aquarium test = new Aquarium("     ", 1);
    }

    @Test
    public void testSetNameWorkingOkay() {
        Aquarium test = new Aquarium("check", 1);
        Assert.assertEquals("check", test.getName());
    }

    @Test
    public void testGetCapacity() {
        Assert.assertEquals(10, aquarium.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityLessThanZero() {
        Aquarium test = new Aquarium("Test", -1);
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(0, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addingWhenFullShouldThrowAnErro() {
        Aquarium test = new Aquarium("Test", 1);
        test.add(fishOne);
        test.add(fishTwo);
    }

    @Test
    public void addingFishShouldIncreaseCount() {
        aquarium.add(fishOne);
        Assert.assertEquals(1, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removingFishShouldThrowAnError() {
        aquarium.remove("Ivan");
    }

    @Test
    public void removingFishShouldReduceCount() {
        aquarium.add(fishOne);
        aquarium.add(fishTwo);

        aquarium.remove("Nemo");
        Assert.assertEquals(1, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void sellingFishShouldThrowAnError() {
        aquarium.sellFish("Kiro");
    }

    @Test
    public void sellingFishShouldBeOkay() {
        aquarium.add(fishOne);
        aquarium.sellFish("Nemo");

        Assert.assertFalse(aquarium.sellFish("Nemo").isAvailable());
    }

    @Test
    public void testingReport() {
        aquarium.add(fishOne);
        String actual = aquarium.report();
        String expected = "Fish available at Test: Nemo";
        Assert.assertEquals(expected, actual);
    }
}

