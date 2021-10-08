package entities;

import org.junit.Before;
import org.junit.jupiter.api.Test;

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
    void isLoggedIn() {
        assertTrue(false);
    }

    @Test
    public void testGetId() {
        assertEquals(u.getId(), 1);
    }

    @Test
    void testGetUsername() {assertEquals(u.getUsername(), "test_user");}

    @Test
    void testGetPassword() {assertEquals(u.getPassword(), "password_123");}

    @Test
    void testGetLocation() {
        assertTrue(false);
    }

    @Test
    void testGetInterests() {
        assertTrue(false);
    }

    @Test
    void addInterests() {
        assertTrue(false);
    }

    @Test
    void removeInterest() {
        assertTrue(false);
    }


}
