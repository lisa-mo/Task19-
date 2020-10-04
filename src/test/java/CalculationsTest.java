import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import static junit.framework.Assert.assertEquals;

// assertEquals, timeout, category, before method
@Category(CategoryForTests.class)
public class CalculationsTest {
    Calculations calculations = new Calculations();

    @Before
    public void beforeMethod() {
        System.out.println("Here is before method annotation.");
    }

    @Test(timeout = 10)
    public void sumCommon() {
        int expectedValue = 66;
        assertEquals(expectedValue, calculations.sum(10, 56));
    }

    @Test
    public void sumZero() {
        int expectedValue = 34;
        assertEquals(expectedValue, calculations.sum(34, 0));

    }

    @Test
    public void sumNegative() {
        int expectedValue = -15;
        assertEquals(expectedValue, calculations.sum(150, -165));
    }

    @Test
    public void subtractCommon() {
        int expectedValue = 14;
        assertEquals(expectedValue, calculations.subtract(35, 21));
    }

    @Test
    public void subtractZero() {
        int expectedValue = 8;
        assertEquals(expectedValue, calculations.subtract(8, 0));
    }

    @Test
    public void subtractNegative() {
        int expectedValue = -19;
        assertEquals(expectedValue, calculations.subtract(-14, 5));
    }

    @Test
    public void subtractToNegative() {
        int expectedValue = -104;
        assertEquals(expectedValue, calculations.subtract(26, 130));
    }

    @Test
    public void multiplyCommon() {
        int expectedValue = 112;
        assertEquals(expectedValue, calculations.multiply(16, 7));
    }

    @Test
    public void multiplyZero() {
        int expectedValue = 0;
        assertEquals(expectedValue, calculations.multiply(123868, 0));
    }

    @Test
    public void multiplyNegative() {
        int expectedValue = -160;
        assertEquals(expectedValue, calculations.multiply(-5, 32));
    }

}