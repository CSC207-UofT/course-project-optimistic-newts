package entities;

import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * A class for testing the Conversation class.
 */
public class ConversationTest {
    Conversation c;

    @Before
    public void setUp() throws Exception {
        c = new Conversation("Sample Conversation");
    }

    @Test(timeout = 50)
    public void TestGetTitle() {
        assertEquals("Sample Conversation", c.getTitle());
    }

    @Test(timeout = 50)
    public void TestGetLocation() {
        assertEquals("", c.getLocation());
    }

    @Test(timeout = 50)
    public void TestGetRating() {
        assertEquals(0, c.getRating());
    }

    @Test(timeout = 50)
    public void TestGetMaxUsers() {
        assertEquals(0, c.getMaxUsers());
    }

    @Test(timeout = 50)
    public void TestGetClosingTime() {
        assertEquals("", c.getClosingTime());
    }

    @Test(timeout = 50)
    public void TestGetStatus() {
        assertEquals("Open", c.getStatus());
    }

    @Test(timeout = 50)
    public void TestGetMessages() {
        assertEquals(new ArrayList<Message>(), c.getMessages());
    }

    @Test(timeout = 50)
    public void TestGetUsers() {
        assertEquals(new ArrayList<User>(), c.getUsers());
    }

    @Test(timeout = 50)
    public void TestSetTitle() {
        c.setTitle("New Title");
        assertEquals("New Title", c.getTitle());
    }
    @Test(timeout = 50)
    public void TestSetLocation() {
        c.setLocation("New Location");
        assertEquals("New Location", c.getLocation());
    }
    @Test(timeout = 50)
    public void TestSetRating() {
        c.setRating(5);
        assertEquals(5, c.getRating());
    }

    @Test(timeout = 50)
    public void TestSetMaxUsers() {
        c.setMaxUsers(10);
        assertEquals(10, c.getMaxUsers());
    }

    @Test(timeout = 50)
    public void TestSetClosingTime() {
        c.setClosingTime("10:00");
        assertEquals("10:00", c.getClosingTime());
    }

    @Test(timeout = 50)
    public void TestSetStatus() {
        c.setStatus("Closed");
        assertEquals("Closed", c.getStatus());
    }

    @Test(timeout = 50)
    public void TestSetMessages() {
        ArrayList<Message> testMessageList = new ArrayList<Message>();
        c.setMessages(testMessageList);
        assertEquals(testMessageList, c.getMessages());
    }

    @Test(timeout = 50)
    public void TestSetUsers() {
        ArrayList<User> testUserList = new ArrayList<User>();
        c.setUsers(testUserList);
        assertEquals(testUserList, c.getUsers());
    }
}
