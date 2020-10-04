import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;

import static org.hamcrest.core.CombinableMatcher.either;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeNotNull;

// assertThat, timeout, assumption, category, after method

@Category(CategoryForTests.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NamesTest {

    Names names = new Names();

    @After
    public void afterMethod() {
        System.out.println("Here is after method annotation.");
    }

    @Test(timeout = 30)
    public void sayHiTest() {
        assertThat(names.sayHi(), is("Hello, what is your name?"));
    }

    @Test(timeout = 300)
    public void sayHiWordsTest() {
        assertThat(names.sayHi(), either(containsString("Hello")).or(containsString("Hi")));
    }

    @Test(timeout = 10)
    public void addSpaceNotNull() {
        assertNotNull(names.addSpace("Bill", "Andrews"));
    }

    @Test
    public void addSpaceCommon() {
        assumeNotNull(names.addSpace("Lily", "Bloom"), is("Lily Bloom"));
        assertThat(names.addSpace("Lily", "Bloom"), is("Lily Bloom"));
    }

    @Test
    public void addSpaceNewName() {
        assertThat(names.addSpace("Don", "Croob"), is(not("Lily Bloom")));
    }

    @Test
    public void addComaNotNull() {
        assertNotNull(names.addSpace("John", "Porter"));
    }

    @Test
    public void addComaCommon() {
        assumeNotNull(names.addSpace("Tory", "Kens"), is("Tory, Kens"));
        assertThat(names.addComa("Tory", "Kens"), is("Tory, Kens"));
    }

    @Test
    public void addComaNewName() {
        assertThat(names.addComa("Phil", "Collins"), is(not("Lily Bloom")));
    }

}