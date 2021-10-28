package application;

import entities.Conversation;
import entities.Message;
import entities.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

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
    public void setUp(){
        c = new ChangeConversationStatus();
    }

    /**
     * Tests the request method
     */
    @Test
    public void testRequest() {
        RequestModel request = new RequestModel(new TestOutput());
        DataBase.addConversation(new Conversation("Sample Conversation", "", "", "", 0, 0, 0,
                "", false, new ArrayList<Message>(), new ArrayList<User>()));
        request.fill(RequestField.ID, "Sample Conversation");

        c.request(request);

        assertTrue(DataBase.getConversation("Sample Conversation").getIsOpen());
    }
}
