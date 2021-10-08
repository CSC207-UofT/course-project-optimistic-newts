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
        c = new Conversation("", "SampleConversation", "", "", 0, 0, 0, "", true,
                new ArrayList<Message>(), new ArrayList<User>());
    }

    @Test(timeout = 50)
    public void TestGetId() { assertEquals( "", c.getId()); }

    @Test(timeout = 50)
    public void TestGetTitle() {
        assertEquals("Sample Conversation", c.getTitle());
    }

    @Test(timeout = 50)
    public void TestGetTopic() { assertEquals("", c.getTopic()); }

    @Test(timeout = 50)
    public void TestGetLocation() {
        assertEquals("", c.getLocation());
    }

    @Test(timeout = 50)
    public void TestGetLocationRadius() { assertEquals(0, c.getLocationRadius());}

    @Test(timeout = 50)
    public void TestGetMinRating() {
        assertEquals(0, c.getMinRating());
    }

    @Test(timeout = 50)
    public void TestGetMaxUsers() {
        assertEquals(0, c.getMaxSize());
    }

    @Test(timeout = 50)
    public void TestGetClosingTime() {
        assertEquals("", c.getClosingTime());
    }

    @Test(timeout = 50)
    public void TestGetStatus() {
        assertEquals(true, c.getIsOpen());
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
    public void TestSetMinRating() {
        c.setMinRating(5);
        assertEquals(5, c.getMinRating());
    }

    @Test(timeout = 50)
    public void TestSetMaxUsers() {
        c.setMaxSize(2);
        assertEquals(2, c.getMaxSize());
    }

    @Test(timeout = 50)
    public void TestSetClosingTime() {
        c.setClosingTime("10:00");
        assertEquals("10:00", c.getClosingTime());
    }

    @Test(timeout = 50)
    public void TestSetStatus() {
        c.setIsOpen(false);
        assertEquals(false, c.getIsOpen());
    }

    @Test(timeout = 50)
    public void TestAddMessage() {
        Message m = new Message();
        c.addMessage(m);
        assertTrue(m == c.getMessages().get(c.getMessages().size() - 1));
    }

    @Test(timeout = 50)
    public void TestAddUser() {
        User u = new User();
        c.addUser(u);
        assertTrue(u == c.getUsers().get(c.getUsers().size() - 1));
    }

    @Test(timeout = 50)
    public void TestAddUserBelowMax() {
        User u1 = new User();
        assertTrue(c.addUser(u1));
    }

    @Test(timeout = 50)
    public void TestAddUserAtMax() {
        User u2 = new User();
        assertFalse(c.addUser(u2));
    }
}
