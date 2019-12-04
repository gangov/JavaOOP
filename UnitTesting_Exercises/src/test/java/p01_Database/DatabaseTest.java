package p01_Database;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    @Test
    public void testingArraySizeToBeExactlySixteenIntegersLong() throws OperationNotSupportedException {
        Database database = new Database(1, 23, 4);
    }

    @Test
    public void addShouldAddNewElement() throws OperationNotSupportedException {
        Database database = new Database(1, 3, 4);
        database.add(4);
        int count = 0;
        Integer[] elements = database.getElements();
        for (Integer element : elements) {
            count++;
        }
        Assert.assertEquals(4, count);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void ifAddedElementIsNullThrowAnException() throws OperationNotSupportedException {
        Database database = new Database(1, 3, 4);

        database.add(null);
    }
}
