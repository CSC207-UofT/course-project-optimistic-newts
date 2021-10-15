package application;

import entities.Conversation;
import entities.ConversationQueue;

/**
 * An object representing a ConversationQueueManager of the application.
 */
public class ConversationQueueManager {
    private GetRelevantConversations getRelevantConversations;

    public ConversationQueueManager() {
        getRelevantConversations = new GetRelevantConversations();
    }

    /**
     * creates and returns a new ConversationQueue with the given arguments
     * @return returns the new created user
     * TODO: implement GetRelevantConversations() using 'GetRelevantConversations' based on the code in 'CliController'.
     */
    public ConversationQueue GetRelevantConversations(){

        return getRelevantConversations.getConversationQueue();
    }
}
