package application;

import entities.User;
import adapters.CliPresenter;
import cli.CliDriver;

import org.junit.Before;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.util.ArrayList;

import static org.junit.Assert.*;

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
        CliDriver cli = new CliDriver();
        CliPresenter cp = new CliPresenter(cli);
        LoginUser.LoginUserRequest r = l.getRequestModel();

        ArrayList<String> interests = new ArrayList<String>();
        interests.add("Sports");
        interests.add("Music");
        interests.add("Fitness");

        DataBase.addUser(new User("Sample User", "1234", interests, 1));
        r.fillRequest(cp, "Sample User", "1234");
        l.request(r);
        assertTrue(l.getUser().getLoginStatus());
    }
}