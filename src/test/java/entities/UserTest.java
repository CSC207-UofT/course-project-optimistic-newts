package entities;

import entities.User;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTest {
    User u;

    /**
     * Setting up a test User
     */
    @Before
    public void setUp() {
        ArrayList<String> interests = new ArrayList<String>();
        interests.add("Sports");
        interests.add("Music");
        interests.add("Fitness");
        u = new User("test_user", "password123", interests, 1);
    }

    /**
     * To be implemented
     */
    @Test
    public void isLoggedIn() {
        assertTrue(false);
    }

    /**
     * Tests the getID method
     */
    @Test
    public void testGetId() {
        assertEquals(u.getId(), 1);
    }

    /**
     * Tests getUsername method
     */
    @Test
    public void testGetUsername() {assertEquals(u.getUsername(), "test_user");}

    /**
     * Tests getPassword method
     */
    @Test
    public void testGetPassword() {assertEquals(u.getPassword(), "password123");}

    /**
     * To be implemented
     */
    @Test
    public void testGetLocation() {
        assertTrue(false);
    }

    /**
     * Tests getInterests method
     */
    @Test
    public void testGetInterests() {
        assertEquals(u.getInterests().get(0), "Sports");
        assertEquals(u.getInterests().get(1), "Music");
        assertEquals(u.getInterests().get(2), "Fitness");
    }

    /**
     * Tests addInterests method
     */
    @Test
    public void addInterests() {
        u.addInterests("Stocks");
        assertEquals(u.getInterests().get(3), "Stocks");
    }

    /**
     * Tests removeInterest method
     */
    @Test
    public void removeInterest() {
        u.addInterests("Stocks");
        assertEquals(u.getInterests().get(2), "Fitness");
    }


}
