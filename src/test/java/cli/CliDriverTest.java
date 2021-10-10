package cli;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Test suite for CliDriver class.
 */
public class CliDriverTest {
    CliDriver cli;

    /**
     * Create a new CliDriver object before each test case.
     */
    @Before
    public void setUp() {
        cli = new CliDriver();
    }

    /**
     * Test output sending to cli.
     */
    @Test
    public void outputTest() {
        cli.sendOutput("hello");
        System.out.println("Does the line above say 'hello'? if so, this CliDriver outputTest has passed!");
        assertTrue(true);
    }
}
