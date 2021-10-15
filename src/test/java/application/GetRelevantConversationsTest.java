package application;


import entities.ConversationQueue;
import entities.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GetRelevantConversationsTest {
    GetRelevantConversations g;

    /**
     * Setting up a test User
     */
    @Before
    public void setUp() {
        ArrayList<String> interests = new ArrayList<String>();
        interests.add("Sports");
        interests.add("Music");
        interests.add("Fitness");
        g = new GetRelevantConversations();
    }

    /**
     * Tests the getRequestModel method
     */
    @Test
    public void testGetRequestModel() {

        assertNotNull(g.getRequestModel());
    }

    /**
     * Tests the request method
     */
    @Test
    public void testRequest() {
        GetRelevantConversations.GetRelevantConversationsRequest r = g.getRequestModel();

        ArrayList<String> interests = new ArrayList<String>();
        interests.add("Sports");
        interests.add("Music");
        interests.add("Fitness");

        r.fillRequest(null, "SampleLocation", 3, interests);
        g.request(r);
        assertEquals(3, g.getConversationQueue().getLocationRadius());
    }
}