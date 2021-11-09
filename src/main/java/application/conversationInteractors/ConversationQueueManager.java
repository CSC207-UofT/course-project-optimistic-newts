package application.conversationInteractors;

import application.conversationInteractors.GetRelevantConversations;
import entities.ConversationQueue;


/**
 * An object representing a ConversationQueueManager of the application.
 */
public class ConversationQueueManager {
    /**
     * creates and returns a new ConversationQueue with the given arguments
     * @return returns the new created user
     * TODO: implement GetRelevantConversations() using 'GetRelevantConversations' based on the code in 'CliController'.
     */
    public ConversationQueue getRelevantConversations(){
        GetRelevantConversations getRelevantConversations = new GetRelevantConversations();
        return getRelevantConversations.getConversationQueue();
    }
}