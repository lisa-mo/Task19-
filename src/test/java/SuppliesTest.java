import org.hamcrest.core.Is;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.List;

import static org.hamcrest.core.CombinableMatcher.either;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

//assertNull, assertTrue, timeout, category, before class

@Category(CategoryForTests.class)
public class SuppliesTest {

    Supplies supplies = new Supplies();

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Here is before class annotation.");
    }

    @Test(timeout = 10)
    public void isSupplyOnStockTrue() {
        assertTrue("We have enough supply.", supplies.isSupplyOnStock(51));
    }
    @Test(timeout = 10)
    public void isSupplyOnStockBoundary() {
        assertTrue("We have enough supply.", supplies.isSupplyOnStock(50));
    }

    @Test(timeout = 10)
    public void isSupplyOnStockFalse() {
        assertFalse("We have enough supply.", supplies.isSupplyOnStock(49));
    }

    @Test
    public void putSupplyNameNotNull() {
        assertNotNull("Shouldn`t be null.", supplies.putSupplyName("Pliers"));
    }

    @Test
    public void createTopSupplyNull() {
        assertNull("Should be null.", supplies.createTopSupply(null));
    }

    @Test
    public void createTopSupplyCommon() {
        assertThat(supplies.createTopSupply("Hub"), is("Hub"));
    }

    @Test(timeout = 300)
    public void createTopSupplyNotOld() {
        assertThat(supplies.createTopSupply(null), is(not("Hub")));
    }

    @Test(timeout = 300)
    public void putSupplyNameItem() {
        assertThat(supplies.putSupplyName("Wheel"), hasItem("Wheel"));
    }

}