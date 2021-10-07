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
    public void TestgetTitle() {
        assertEquals("Sample Conversation", c.getTitle());
    }

    @Test(timeout = 50)
    public void TestgetLocation() {
        assertEquals("", c.getLocation());
    }

    @Test(timeout = 50)
    public void TestgetRating() {
        assertEquals(0, c.getRating());
    }

    @Test(timeout = 50)
    public void TestgetMaxUsers() {
        assertEquals(0, c.getMaxUsers());
    }

    @Test(timeout = 50)
    public void TestgetClosingTime() {
        assertEquals("", c.getClosingTime());
    }

    @Test(timeout = 50)
    public void TestgetStatus() {
        assertEquals("Open", c.getStatus());
    }

    @Test(timeout = 50)
    public void TestgetMessages() {
        assertEquals(new ArrayList<Message>(), c.getMessages());
    }

    @Test(timeout = 50)
    public void TestgetUsers() {
        assertEquals(new ArrayList<User>(), c.getUsers());
    }

    @Test(timeout = 50)
    public void TestsetTitle() {
        c.setTitle("New Title");
        assertEquals("New Title", c.getTitle());
    }
    @Test(timeout = 50)
    public void TestsetLocation() {
        c.setLocation("New Location");
        assertEquals("New Location", c.getLocation());
    }
    @Test(timeout = 50)
    public void TestsetRating() {
        c.setRating(5);
        assertEquals(5, c.getRating());
    }

    @Test(timeout = 50)
    public void TestsetMaxUsers() {
        c.setMaxUsers(10);
        assertEquals(10, c.getMaxUsers());
    }

    @Test(timeout = 50)
    public void TestsetClosingTime() {
        c.setClosingTime("10:00");
        assertEquals("10:00", c.getClosingTime());
    }

    @Test(timeout = 50)
    public void TestsetStatus() {
        c.setStatus("Closed");
        assertEquals("Closed", c.getStatus());
    }

    @Test(timeout = 50)
    public void TestsetMessages() {
        ArrayList<Message> testMessageList = new ArrayList<Message>();
        c.setMessages(testMessageList);
        assertEquals(testMessageList, c.getMessages());
    }

    @Test(timeout = 50)
    public void TestsetUsers() {
        ArrayList<User> testUserList = new ArrayList<User>();
        c.setUsers(testUserList);
        assertEquals(testUserList, c.getUsers());
    }
    
}
