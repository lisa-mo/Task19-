import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.CombinableMatcher.either;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;
import static org.junit.runners.Parameterized.*;

//assertSame, assertEquals, assertTrue, timeout, after class, parameters

@RunWith(Parameterized.class)
public class PricesTest{
    private final Integer inputNum;
    private final Boolean expectedResult;
    private Prices price;

    @Before
            public void initialize() {
        price = new Prices();
    }

    public PricesTest(Integer inputNum, Boolean expectedResult) {
        this.inputNum = inputNum;
        this.expectedResult = expectedResult;
    }

    @Parameters
            public static Collection cardNumbers() {
        return Arrays.asList(new Object[][] {{2, true}, {6, false}, {19, true}, {22, false}, {23, true}});
    }

    @Test
    public void testCardChecker() {
        System.out.println("We parameterized this numbers: " + inputNum);
        assertEquals(expectedResult, price.checkCard(inputNum));
    }


    @Test(timeout = 10)
    public void putMessageTest() {
        String actualValue = price.putMessage();
        String expectedValue = "We do not have promotions at the moment.";
        assertSame("Should be same.", expectedValue, actualValue);
    }

    @Test(timeout = 300)
    public void putMessageWordTest() {
        assertThat(price.putMessage(), either(containsString("promotions")).or(containsString("discounts")));
    }

//    @Test
//    public void fullPriceTest() {
//        String actualValue = price.fullPrice(65, "CAN",12);
//        String expectedValue = "65 CAN this is the price, and the current tax is 12%";
//        assertThat(actualValue, is(expectedValue));
//    }

    @Test(timeout = 300)
    public void fullPriceWordTest() {
        assertThat(price.fullPrice(361, "USD", 4), either(containsString("CAN")).or(containsString("USD")));
    }

    @Test(timeout = 300)
    public void fullNewPrice() {
        assertThat(price.fullPrice(776, "UAH",0), is(not("361 USD this is the price, and the current tax is 4%")));
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Here is after class annotation.");
    }

}