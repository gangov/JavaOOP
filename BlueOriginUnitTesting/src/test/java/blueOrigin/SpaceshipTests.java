package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Spaceship
    private Spaceship spaceship;

    @Before
    public void createSpaceShipInstance() {
        spaceship = new Spaceship("Voyager", 1000);
    }

    @Test(expected = NullPointerException.class)
    public void setNameWithNullMethodShouldThrowException() {
        Spaceship test = new Spaceship(null, 100);
    }

    @Test(expected = NullPointerException.class)
    public void setNameWithEmptyMethodShouldThrowException() {
        Spaceship test = new Spaceship("    ", 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setCapacityWithLessThanZero() {
        Spaceship test = new Spaceship("Test", -1);
    }

    @Test
    public void testGetCountMethod() {
        int count = spaceship.getCount();
        Assert.assertEquals(0, count);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Voyager", spaceship.getName());
    }

    @Test
    public void testGetCapacity() {
        int capacity = spaceship.getCapacity();
        Assert.assertEquals(1000, capacity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addingToFullSpaceShipShouldThrowError() {
        Spaceship spaceship = new Spaceship("Test", 1);
        Astronaut astronaut = new Astronaut("Pesho", 100);
        Astronaut astronaut1 = new Astronaut("Ivan", 100);

        spaceship.add(astronaut);
        spaceship.add(astronaut1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cantAddDuplicateAstronauts() {
        Spaceship spaceship = new Spaceship("Test", 2);
        Astronaut astronaut = new Astronaut("Pesho", 100);
        Astronaut astronaut1 = new Astronaut("Pesho", 100);

        spaceship.add(astronaut);
        spaceship.add(astronaut1);
    }

    @Test
    public void addingAstronautShouldIncreaseCount() {
        Spaceship spaceship = new Spaceship("Test", 4);
        Astronaut astronaut = new Astronaut("Pesho", 100);
        Astronaut astronaut1 = new Astronaut("Ivan", 100);

        spaceship.add(astronaut);
        spaceship.add(astronaut1);
        int count = spaceship.getCount();
        Assert.assertEquals(2, count);
    }

    @Test
    public void removingNonExistingAustronautShouldReturnFalse() {
        boolean result = spaceship.remove("Ivan");
        Assert.assertFalse(result);
    }

    @Test
    public void removingExistingAustronautShouldReturnTrue() {
        spaceship.add(new Astronaut("Misho", 100));
        boolean result = spaceship.remove("Misho");
        Assert.assertTrue(result);
    }
}
