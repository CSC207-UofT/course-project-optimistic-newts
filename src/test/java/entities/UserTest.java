package entities;

import entities.User;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTest {
    User u;
    @Before
    public void setUp() {
        ArrayList<String> interests = new ArrayList<String>();
        interests.add("Sports");
        interests.add("Music");
        interests.add("Fitness");
        u = new User("test_user", "password123", interests, 1);
    }
    @Test
    public void isLoggedIn() {
        assertTrue(false);
    }

    @Test
    public void testGetId() {
        assertEquals(u.getId(), 1);
    }

    @Test
    public void testGetUsername() {assertEquals(u.getUsername(), "test_user");}

    @Test
    public void testGetPassword() {assertEquals(u.getPassword(), "password123");}

    @Test
    public void testGetLocation() {
        assertTrue(false);
    }

    @Test
    public void testGetInterests() {
        assertTrue(false);
    }

    @Test
    public void addInterests() {
        assertTrue(false);
    }

    @Test
    public void removeInterest() {
        assertTrue(false);
    }


}
