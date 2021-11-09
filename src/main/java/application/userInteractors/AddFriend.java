package application.userInteractors;

import application.*;
import entities.User;

/**
 * An object representing a AddFriend user interactor of the application.
 */
public class AddFriend extends UserInteractor {
    private User user;
    private User user_two;

    /**
     * Accepts a request.
     * @param request   a request stored as a RequestModel
     */
    @Override
    public void request(RequestModel request) throws Exception {
        ResponseModel response = new ResponseModel();

        user = DataBase.getUser((String) request.get(RequestField.USERNAME));
        user_two = DataBase.getUser((String) request.get(RequestField.USERNAME_TWO));
        ConfigReader config = (ConfigReader) request.get(RequestField.CONFIG);

        if (user_two.getUsername() == null) {
            // Output an error because there is no such user with the given username
            response.fill(ResponseField.FAILURE, new Exception(ApplicationExceptions.NO_SUCH_USER_ERROR));
        } else {
            // A User with the given username was found
            user.addFriend(user_two);
            response.fill(ResponseField.SUCCESS, user.getUsername() + config.get("friendAdded"));

        }
        // send response through provided output boundary
        request.getOutput().respond(response);
    }

    /**
     * Returns the user that has been found by this interactor, or null otherwise.
     * @return  the searched User or null if no user has been logged in.
     */
    public User getUser() {
        return user;
    }

    /**
     * Returns the friend that has been found by this interactor, or null otherwise.
     * @return  the searched User or null if no user has been logged in.
     */
    public User getUserTwo() {
        return user_two;
    }
}