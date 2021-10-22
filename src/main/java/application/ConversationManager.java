package application;
import application.CreateConversation;
import entities.Conversation;
import entities.User;
import entities.Message;


import java.util.ArrayList;

/**
 * An object representing a ConversationManager of the application.
 */
public class ConversationManager {
    private CreateConversation createConversation;
    private ChangeConversationStatus changeConversationStatus;

    public ConversationManager(){
        createConversation = new CreateConversation();
        changeConversationStatus = new ChangeConversationStatus();
    }

    /**
     * creates and returns a new user with the given arguments
     * @return returns the new created user
     * TODO: implement CreateConversation() using 'CreateConversation' based on the code in 'CliController'.
     */
    public Conversation CreateConversation(){
        return createConversation.getConversation();
    }


    /**
     * Changes the status of the conversation with the given id
     */
    public void ChangeConversationStatus() { changeConversationStatus.changeStatus();}
}