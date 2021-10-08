package application;
import entities.User;

/**
 * An abstract UserInteractor object. Generally to be extended as a specific User usecase.
 * Requires simply that an implementing class stores a User object and accepts requests.
 */
public abstract class UserInteractor implements InputBoundary{
    private final User user;

    /**
     * Construct a new UserInteractor object to interact with a User.
     * @param user  User to interact with
     */
    public UserInteractor(User user) {
        this.user = user;
    }

    /**
     * Accept a given request (RequestModel).
     * @param request   a request stored as a RequestModel
     */
    @Override
    public void request(RequestModel request) {

    }
}
