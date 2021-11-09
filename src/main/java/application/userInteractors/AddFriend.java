package application.userInteractors;

import application.*;
import entities.User;

/**
 * UserInteracotor for adding a friend.
 */
public class AddFriend extends UserInteractor {
    private User user;
    private User userTwo;

    /**
     * Accepts a request.
     * @param request   a request stored as a RequestModel
     */
    @Override
    public void request(RequestModel request) throws Exception {
        ResponseModel response = new ResponseModel();
        ConfigReader config = (ConfigReader) request.get(RequestField.CONFIG);

        user = DataBase.getUser((String) request.get(RequestField.USERNAME));
        userTwo = DataBase.getUser((String) request.get(RequestField.USERNAME_TWO));

        if (user.getUsername() == null || userTwo.getUsername() == null) {
            // Output an error because there is no such user with the given username
            response.fill(ResponseField.FAILURE, new Exception(ApplicationExceptions.NO_SUCH_USER_ERROR));
        } else {
            // A User with the given username was found
            response.fill(ResponseField.SUCCESS, user.getUsername() + config.get("friendAdded"));
            user.addFriend(userTwo);
        }
        // send response through provided output boundary
        request.getOutput().respond(response);
    }

    /**
     * Returns the friend that has been found by this interactor, or null otherwise.
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
        return userTwo;
    }
}