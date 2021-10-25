package application;

import entities.Conversation;
import entities.Message;
import entities.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ChangeConversationTest {
    ChangeConversationStatus c;

    /**
     *  Setting up a test conversation
     */
    @Before
    public void setUp(){ c = new ChangeConversationStatus();}

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
        DataBase.addConversation(new Conversation("Sample Conversation", "", "", "", 0, 0, 0,
                "", false, new ArrayList<Message>(), new ArrayList<User>()));
        ChangeConversationStatus.ChangeConversationRequest r = c.getRequestModel();
        r.fillRequest(null, "Sample Conversation");
        c.request(r);
        assertTrue(DataBase.getConversation("Sample Conversation").getIsOpen());
    }
}
