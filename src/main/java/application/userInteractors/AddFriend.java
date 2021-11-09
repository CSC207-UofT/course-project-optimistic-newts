package application.userInteractors;

import application.*;
import entities.User;

public class AddFriend extends UserInteractor {
    private User user;

    /**
     * Accepts a request.
     * @param request   a request stored as a RequestModel
     */
    @Override
    public void request(RequestModel request) {
        user = DataBase.getUser((String) request.get(RequestField.USERNAME));
        ResponseModel response = new ResponseModel();
        if (user.getUsername() == null) {
            // Output an error because there is no such user with the given username
            response.fill(ResponseField.EXCEPTION, new Exception(ApplicationExceptions.NO_SUCH_USER_ERROR));
        } else {
            // A User with the given username was found
            response.fill(ResponseField.SUCCESS, user.getUsername() + ResponseValues.friendAdded);
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
}