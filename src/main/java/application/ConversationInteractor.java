package application;
import entities.Conversation;

/**
 * An abstract ConversationInteractor object. Generally to be extended as a specific Conversation usecase.
 * Requires simply that an implementing class stores a Conversation object and accepts requests.
 */
public abstract class ConversationInteractor implements InputBoundary{
    private final Conversation conversation;

    /**
     * Construct a new ConversationInteractor object to interact with a Conversation.
     * @param conversation  Conversation to interact with
     */
    public ConversationInteractor(Conversation conversation) {
        this.conversation = conversation;
    };

    /**
     * Accept a given (RequestModel) request.
     * @param request   a request stored as a RequestModel
     */
    @Override
    public void request(RequestModel request) {

    }
}
