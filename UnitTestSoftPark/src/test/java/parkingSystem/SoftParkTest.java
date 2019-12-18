package parkingSystem;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SoftParkTest {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS SoftPark

    private SoftPark softPark;
    private Car car;

    @Before
    public void generateConstructor() {
        this.softPark = new SoftPark();
        this.car = new Car("Mercedes", "PB4748CT");
    }

    @Test
    public void getParkingTestReturnUnmodifiable() {
        Assert.assertTrue(softPark.getParking().getClass().getSimpleName().equals("UnmodifiableMap"));
    }

    @Test
    public void getParkingTestShouldReturnACollection() {
        Assert.assertEquals(12, softPark.getParking().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void parkCarParkingSpotDoesntExistTest() {
        softPark.parkCar("Z5", car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parkCarParkingSpotNotEmpty() {
        softPark.parkCar("A1", car);
        softPark.parkCar("A1", new Car("BMW", "CA 1000 CA"));
    }

    @Test(expected = IllegalStateException.class)
    public void parkCarTheCarIsAlreadyParked() {
        softPark.parkCar("A1", car);
        softPark.parkCar("A2", car);
    }

    @Test
    public void parkCarCheckIfCarIsSuccessfullyParked() {
        String actual = softPark.parkCar("A1", car);
        String expected = "Car:PB4748CT parked successfully!";
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCarSpotDoesntExists() {
        softPark.removeCar("Z5", car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCarNoSuchCarOnThatSpot() {
        softPark.removeCar("A1", car);
    }

    @Test
    public void removeCarShouldReturnCorrectString() {
        softPark.parkCar("A1", car);
        String actual = softPark.removeCar("A1", car);
        String expected = "Remove car:PB4748CT successfully!";
        Assert.assertEquals(expected, actual);
    }
}