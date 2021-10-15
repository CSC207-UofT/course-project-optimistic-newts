package application;

import adapters.CliPresenter;
import cli.CliDriver;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CreateUserTest {
    CreateUser c;

    /**
     * Setting up a test User
     */
    @Before
    public void setUp() {
        c = new CreateUser();
    }

    /**
     * Tests the getRequestModel method
     */
    @Test
    public void testGetRequestModel() {

        assertNotNull(c.getRequestModel());
    }

    /**
     * Tests the request method
     */
    @Test
    public void testRequest() {
        CliDriver cli = new CliDriver();
        CliPresenter cp = new CliPresenter(cli);
        CreateUser.CreateUserRequest r = c.getRequestModel();
        ArrayList<String> interests = new ArrayList<String>();
        interests.add("Sports");
        interests.add("Music");
        interests.add("Fitness");
        r.fillRequest(cp, 1, "Sample User", "", "", interests);
        c.request(r);
        assertEquals("Sample User", c.getUser().getUsername());
    }
}