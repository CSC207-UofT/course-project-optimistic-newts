package entities;

import org.junit.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * A class that the test the Message class
 */
public class MessageTest {
    Message m;

    @Before
    public void setUp() throws Exception {
        ArrayList<String> interests = new ArrayList<>();
        interests.add("darkside");
        User u = new User("Darth Vader", "deathstar", interests, 123);
        m = new Message("Luke, I am your father", u);
    }

    @Test(timeout = 50)
    public void TestGetBody() {
        assertEquals("Luke, I am your father", m.getBody());
    }

    @Test(timeout = 50)
    public void TestGetAuthor() {
        assertEquals("Darth Vader", m.getAuthor());
    }

    @Test(timeout = 50)
    public void TestGetWrittenAT() {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String testDate = LocalDateTime.now().format(date);
        assertEquals(testDate, m.getWrittenAt());
    }

    @Test(timeout = 50)
    public void TestGetLastUpdatedAt_and_TestSetBody() {
        m.setBody("May the force be with you");
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String testDate = LocalDateTime.now().format(date);
        assertEquals(testDate, m.getLastUpdatedAt());
        assertEquals("May the force be with you", m.getBody());
    }
}
