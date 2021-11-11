package application;

import application.conversation.ChangeConversationStatus;
import entities.Conversation;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class ChangeConversationStatusTest {
    ChangeConversationStatus c;

    private static class TestOutput implements OutputBoundary {

        @Override
        public void respond(ResponseModel response) {
        }
    }

    /**
     *  Setting up a test conversation
     */
    @Before
    public void setUp() {
        c = new ChangeConversationStatus();
    }

    /**
     * Tests the request method
     */
    @Test
    public void testRequest() throws Exception {
        RequestModel request = new RequestModel(new TestOutput());
        DataBase.addConversation(new Conversation("Sample Conversation", "", "", "", 0, 0, 0,
                "", false, new ArrayList<>(), new ArrayList<>()));
        request.fill(RequestField.ID, "Sample Conversation");

        c.request(request);

        assertTrue(DataBase.getConversation("Sample Conversation").getIsOpen());
    }
}
