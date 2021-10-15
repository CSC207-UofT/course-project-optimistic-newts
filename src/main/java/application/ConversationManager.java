package application;
import application.CreateConversation;
import entities.Conversation;
import entities.Message;
import entities.User;

import java.util.ArrayList;

/**
 * An object representing a ConversationManager of the application.
 */
public class ConversationManager {
    private CreateConversation createConversation;

    public ConversationManager(){
        createConversation = new CreateConversation();
    }

    /**
     * creates and returns a new user with the given arguments
     * @return returns the new created user
     * TODO: implement CreateConversation() using 'CreateConversation' based on the code in 'CliController'.
     */
    public Conversation CreateConversation(){
        return createConversation.getConversation();
    }
}
