package gateways;

import entities.EntityExceptions;
import entities.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test suite for CliDriver class.
 */
public class TempUsersTest {
    TempUsers tempUsers;

    /**
     * Create a new TempUsers object before each test case.
     */
    @Before
    public void setUp() {
        tempUsers = new TempUsers();
    }

    /**
     * Test that TempUsers.insert() is able to serialize and save a User object as expected.
     */
    @Test
    public void insertRetrieveTest() {
        User user = new User();
        user.setUsername("testuser");
        try {
            user.setPassword("password");
        } catch (EntityExceptions entityExceptions) {
            entityExceptions.printStackTrace();
        }
        user.setLocation("Toronto");
        int idNum = 0;
        String id = "testuser#" + idNum;
        user.setId(id);
        while (!tempUsers.insert(user)) {
            idNum++;
            id = "testuser#" + idNum;
            user.setId(id);
        }
        try {
            Assert.assertEquals(user.getUsername(), tempUsers.get(id).getUsername());
        } catch (Exception e) {
            Assert.assertFalse(false);
        }
        tempUsers.delete(id); // delete created user so testing user is not persisting in data store.
    }

    /**
     * Test that TempUsers.delete() is able to delete a User with a given id from the data store.
     */
    @Test
    public void insertDeleteTest() {
        User user = new User();
        user.setUsername("testuser");
        try {
            user.setPassword("password");
        } catch (EntityExceptions entityExceptions) {
            entityExceptions.printStackTrace();
        }
        user.setLocation("Toronto");
        int idNum = 0;
        String id = "testuser#" + idNum;
        user.setId(id);
        while (!tempUsers.insert(user)) {
            idNum++;
            id = "testuser#" + idNum;
            user.setId(id);
        }
        Assert.assertTrue(tempUsers.delete(id));
        String finalId = id;
        Assert.assertThrows(Exception.class, () -> tempUsers.get(finalId));
    }
}
