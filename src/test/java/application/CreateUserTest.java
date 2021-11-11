package application;

import adapters.TestPresenter;
import application.user.CreateUser;
import entities.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CreateUserTest {
    CreateUser l;

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
        l = new CreateUser();
    }

    /**
     * Tests the request method
     */
    @Test
    public void requestTest() {
        TestPresenter tp = new TestPresenter();
        RequestModel r = new RequestModel(new CreateUserTest.TestOutput());
        ArrayList<String> interests = new ArrayList<>();
        interests.add("Sports");
        interests.add("Music");
        interests.add("Fitness");
        DataBase.addUser(new User("Sample User", "1234", interests, 1));

        r.fill(RequestField.USERNAME, "Sample User");
        r.fill(RequestField.PASSWORD, "1234");
        l.request(r);
        assertEquals(l.getUser().getUsername(), "Sample User");

        ArrayList<String> test_interests = new ArrayList<>();
        test_interests.add("Sports");
        test_interests.add("Music");
        test_interests.add("Fitness");
        assertEquals(l.getUser().getInterests(), test_interests);
    }
}