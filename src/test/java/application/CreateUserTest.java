package application;

import adapters.TestPresenter;
import cli.CliDriver;
import adapters.CliPresenter;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CreateUserTest {

    //TODO: Implement new test for new request model

//    /**
//     * Setting up a test User
//     */
//    @Before
//    public void setUp() {
//        c = new CreateUser();
//    }
//
//    /**
//     * Tests the getRequestModel method
//     */
//    @Test
////    public void testGetRequestModel() {
////
////        assertNotNull(c.getRequestModel());
//    }
//
////    @Test
////    public void testRequest() {
////        TestPresenter tp = new TestPresenter();
////        CreateUser.CreateUserRequest r = c.getRequestModel();
////        ArrayList<String> interests = new ArrayList<String>();
////        interests.add("Sports");
////        interests.add("Music");
////        interests.add("Fitness");
////        r.fillRequest(tp, 1, "Sample User", "", "", interests);
////        c.request(r);
////        assertEquals("Sample User", c.getUser().getUsername());
////    }
}