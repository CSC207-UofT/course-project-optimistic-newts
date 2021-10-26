package application;

import adapters.TestPresenter;
import entities.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class LoginUserTest {
    LoginUser l;

    /**
     * Setting up a test LoginUser
     */
    @Before
    public void setUp() {
        l = new LoginUser();
    }

    /**
     * Tests the getRequestModel method
     */
    @Test
    public void testGetRequestModel() {

        assertNotNull(l.getRequestModel());
    }

    /**
     * Tests the request method
     */
    @Test
    public void testRequest() {
        TestPresenter tp = new TestPresenter();
        LoginUser.LoginUserRequest r = l.getRequestModel();
        ArrayList<String> interests = new ArrayList<String>();
        interests.add("Sports");
        interests.add("Music");
        interests.add("Fitness");

        DataBase.addUser(new User("SampleUser", "1234", interests, "SampleUser#0"));
        r.fillRequest(tp, "SampleUser", "1234");
        l.request(r);
        assertTrue(l.getUser().getLoginStatus());
    }
}