package entities;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * A class for testing the Conversation class.
 */
public class ConversationTest {
    Conversation c;

    @Before
    public void setUp() throws Exception {
        c = new Conversation("", "Sample Conversation", List.of(""), "", 0, 0, 0, "", true,
                new ArrayList<>(), new ArrayList<>());
    }

    @Test(timeout = 50)
    public void TestGetId() { assertEquals( "", c.getId()); }

    @Test(timeout = 50)
    public void TestGetTitle() {
        assertEquals("Sample Conversation", c.getTitle());
    }

    @Test(timeout = 50)
    public void TestGetTopic() { assertEquals("", c.getTopics().get(0)); }

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
        assertTrue(c.getIsOpen());
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
    public void TestToggleStatus() {
        c.toggleIsOpen();
        assertFalse(c.getIsOpen());
    }

    @Test(timeout = 50)
    public void TestAddMessage() {
        User u = new User("Joe", "pass", new ArrayList<String>(), 0);
        Message m = new Message("1", "Hello!", u);
        c.addMessage(m);
        assertSame(m, c.getMessages().get(c.getMessages().size() - 1));
    }

    @Test(timeout = 50)
    public void TestAddUser() {
        c.setMaxSize(1);
        ArrayList<String> interests = new ArrayList<>(List.of(new String[]{"Golf", "Painting"}));
        User u = new User("testuser", "password", interests, 0);
        c.addUser(u);
        assertSame(u, c.getUsers().get(c.getUsers().size() - 1));
    }

    @Test(timeout = 50)
    public void TestAddUserAtMax() {
        ArrayList<String> interests = new ArrayList<>(List.of(new String[]{"Golf", "Painting"}));
        User u = new User("testuser", "password", interests, 0);
        assertFalse(c.addUser(u));
    }

    @Test(timeout = 50)
    public void TestAddUserBelowMax() {
        c.setMaxSize(1);
        ArrayList<String> interests = new ArrayList<>(List.of(new String[]{"Golf", "Painting"}));
        User u = new User("testuser", "password", interests, 0);
        assertTrue(c.addUser(u));
    }

    @Test(timeout = 50)
    public void TestRemoveUser() {
        User u = new User();
        c.addUser(u);
        assertTrue(c.removeUser(u));
    }

    @Test(timeout = 50)
    public void TestRemoveUserNotInConversation() {
        User u = new User();
        assertFalse(c.removeUser(u));
    }
}
