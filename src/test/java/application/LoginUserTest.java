package application;

import adapters.TestPresenter;
import application.user.LoginUser;
import entities.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.assertTrue;

public class LoginUserTest {
    LoginUser l;

    private static class TestOutput implements OutputBoundary {

        @Override
        public void respond(ResponseModel response) {
        }
    }

    /**
     * Setting up a test LoginUser
     */
    @Before
    public void setUp() {
        l = new LoginUser();
    }

    /**
     * Tests the request method
     */
    @Test
    public void testRequest() {
        TestPresenter tp = new TestPresenter();
        RequestModel r = new RequestModel(new TestOutput());
        ArrayList<String> interests = new ArrayList<>();
        interests.add("Sports");
        interests.add("Music");
        interests.add("Fitness");
        DataBase.addUser(new User("Sample User", "1234", interests, 1));
        r.fill(RequestField.USERNAME, "Sample User");
        r.fill(RequestField.PASSWORD, "1234");
        l.request(r);
        assertTrue(l.getUser().getLoginStatus());
    }
}