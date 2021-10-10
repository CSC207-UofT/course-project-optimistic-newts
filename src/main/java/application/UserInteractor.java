package application;
import entities.User;

/**
 * An abstract UserInteractor object. Generally to be extended as a specific User usecase.
 * Requires simply that an implementing class stores a User object and accepts requests.
 */
public abstract class UserInteractor implements InputBoundary{
    private User user;

    /**
     * Construct a new UserInteractor object to interact with a User.
     */
    public UserInteractor() {}
}
