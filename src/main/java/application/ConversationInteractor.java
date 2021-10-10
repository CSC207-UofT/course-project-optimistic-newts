package application;
import entities.Conversation;

/**
 * An abstract ConversationInteractor object. Generally to be extended as a specific Conversation usecase.
 * Requires simply that an implementing class stores a Conversation object and accepts requests.
 */
public abstract class ConversationInteractor implements InputBoundary{
    private Conversation conversation;

    /**
     * Construct a new ConversationInteractor object to interact with a Conversation.
     */
    public ConversationInteractor() {}
}
