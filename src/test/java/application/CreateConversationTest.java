package application;

import application.CreateConversation;

import entities.Message;
import entities.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CreateConversationTest {
    CreateConversation c;

    /**
     * Setting up a test User
     */
    @Before
    public void setUp() {
        c = new CreateConversation();
    }

    /**
     * Tests the getRequestModel method
     */
    @Test
    public void testGetRequestModel() {

        assertNotNull(c.getRequestModel());
    }

    /**
     * Tests the request method
     */
    @Test
    public void testRequest() {
        CreateConversation.CreateConversationRequest r = c.getRequestModel();
        r.fillRequest(null, "", "Sample Conversation", "", "", 0, 0,
                0, "", true, new ArrayList<Message>(), new ArrayList<User>());
        c.request(r);
        assertEquals("Sample Conversation", c.getConversation().getTitle());
    }
}