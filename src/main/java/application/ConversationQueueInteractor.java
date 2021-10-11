package application;
import entities.ConversationQueue;

/**
 * An abstract ConversationQueueInteractor object. Generally to be extended as a specific ConversationQueue usecase.
 * Requires simply that an implementing class stores a ConversationQueue object and handles requests.
 */
public abstract class ConversationQueueInteractor implements InputBoundary{
    private ConversationQueue ConversationQueue;
}
