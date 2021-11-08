package application;

import application.conversationInteractors.ChangeConversationStatus;
import entities.Conversation;
import gateways.ResponseValueReader;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ChangeConversationStatusTest {
    ChangeConversationStatus c;
    ResponseValueReader r;

    private static class TestOutput implements OutputBoundary {

        @Override
        public void respond(ResponseModel response) {
        }
    }

    /**
     *  Setting up a test conversation
     */
    @Before
    public void setUp() throws IOException, ParseException {
        c = new ChangeConversationStatus();
        r = new ResponseValueReader();
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

        c.request(request, r);

        assertTrue(DataBase.getConversation("Sample Conversation").getIsOpen());
    }
}
