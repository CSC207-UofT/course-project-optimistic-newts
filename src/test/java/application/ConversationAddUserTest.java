package application;

import adapters.TestPresenter;
import application.conversation.ConversationAddUser;
import entities.Conversation;
import entities.Message;
import entities.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

public class ConversationAddUserTest{
    ConversationAddUser cau;

    private static class TestOutput implements OutputBoundary {

        @Override
        public void respond(ResponseModel response) {
        }
    }

    /**
     * Setting up a test UserJoinConversation
     */
    @Before
    public void setUp() {
        cau = new ConversationAddUser();
    }

    @Test
    public void testRequest() {
        TestPresenter tp = new TestPresenter();
        RequestModel r = new RequestModel(new ConversationAddUserTest.TestOutput());
        ArrayList<String> interests = new ArrayList<>();
        interests.add("Sports");
        interests.add("Music");
        interests.add("Fitness");
        DataBase.addUser(new User("Sample User", "1234", interests, "1"));
        DataBase.addConversation(new Conversation("1", "Sample Conversation", "", "",
                0, 0, 1, "", true,
                new ArrayList<Message>(), new ArrayList<User>()));
        r.fill(RequestField.USERNAME, "Sample User");
        r.fill(RequestField.CONVERSATION_ID, "1");
        cau.request(r);
        assertTrue(cau.getConversation().getUsers().contains(cau.getUser()));

    }

    @Test
    public void testGetUser() {
        assertEquals(cau.getUser(), DataBase.getUser("Sample User"));
    }

    @Test
    public void testGetConversation() {
        assertEquals(cau.getConversation(), DataBase.getConversation("1"));
    }
}