package application;

import adapters.TestPresenter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
        TestPresenter tp = new TestPresenter();
        CreateUser.CreateUserRequest r = c.getRequestModel();
        ArrayList<String> interests = new ArrayList<String>();
        interests.add("Sports");
        interests.add("Music");
        interests.add("Fitness");
        r.fillRequest(tp, "SampleUser#0", "SampleUser", "", "", interests);
        c.request(r);
        assertEquals("SampleUser", c.getUser().getUsername());
    }
}