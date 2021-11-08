package application;


import adapters.TestPresenter;
import application.conversationInteractors.GetRelevantConversations;
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
        g = new GetRelevantConversations();
    }

    /**
     * Tests the request method
     */
    @Test
    public void testRequest() {
        TestPresenter presenter = new TestPresenter();
        RequestModel request = new RequestModel(presenter);

        ArrayList<String> interests = new ArrayList<String>();
        interests.add("Sports");
        interests.add("Music");
        interests.add("Fitness");

        request.fill(RequestField.LOCATION, "SampleLocation");
        request.fill(RequestField.LOCATION_RADIUS, 3);
        request.fill(RequestField.INTERESTS, interests);
        g.request(request);

        assertEquals(3, g.getConversationQueue().getLocationRadius());
    }
}