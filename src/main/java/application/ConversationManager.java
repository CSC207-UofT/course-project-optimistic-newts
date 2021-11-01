package application;

import application.conversationInteractors.ChangeConversationStatus;
import application.conversationInteractors.CreateConversation;
import entities.Conversation;

/**
 * An object representing a ConversationManager of the application.
 */
public class ConversationManager {
    Conversation conversation;

    /**
     * Creates and returns a new user with the given arguments
     * @return returns the new created user
     * TODO: implement createConversation() using 'CreateConversation' based on the code in 'CliController'.
     */
    public void createConversation(){
        CreateConversation createConversation = new CreateConversation();
        conversation = createConversation.getConversation();
    }

    /**
     * Changes the status of the conversation with the given id
     */
    public void changeConversationStatus() {
        ChangeConversationStatus changeConversationStatus = new ChangeConversationStatus();
        changeConversationStatus.changeStatus();}
}