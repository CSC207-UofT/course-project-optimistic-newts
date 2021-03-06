package application.message;
import application.InputBoundary;
import entities.Message;

/**
 * An abstract MessageInteractor object. Generally to be extended as a specific Message usecase.
 * Requires simply that an implementing class stores a Message object and handles requests.
 */
public abstract class MessageInteractor implements InputBoundary {
    private Message m;
}
