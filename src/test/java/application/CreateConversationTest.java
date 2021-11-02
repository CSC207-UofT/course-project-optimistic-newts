package application;

import application.conversationInteractors.CreateConversation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateConversationTest {
    CreateConversation c;

    private static class TestOutput implements OutputBoundary {

        @Override
        public void respond(ResponseModel response) {
        }
    }

    /**
     * Setting up a test User
     */
    @Before
    public void setUp() {
        c = new CreateConversation();
    }

    /**
     * Tests the request method
     */
    @Test
    public void testRequest() {
        RequestModel r = new RequestModel(new TestOutput());
        r.fill(RequestField.ID, "Sample Conversation");
        r.fill(RequestField.TITLE, "Sample Conversation");
        r.fill(RequestField.TOPIC, "Sample Conversation");
        r.fill(RequestField.LOCATION, "Sample Conversation");
        r.fill(RequestField.LOCATION_RADIUS, 1);
        r.fill(RequestField.MIN_RATING, 1);
        r.fill(RequestField.MAX_SIZE, 1);
        r.fill(RequestField.CLOSING_TIME, "");
        r.fill(RequestField.IS_OPEN, false);

        c.request(r);

        assertEquals("Sample Conversation", c.getConversation().getTitle());
    }
}