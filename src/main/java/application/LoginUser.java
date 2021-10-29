package application;

import entities.User;

public class LoginUser extends UserInteractor {
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
            response.fill(ResponseField.EXCEPTION, new Exception(ApplicationExceptions.NoSuchUserError));
        } else if (user.getPassword() == request.get(RequestField.PASSWORD)) {
            // Login the user
            user.logIn();
            response.fill(ResponseField.SUCCESS, user.getUsername() + ResponseValues.loggedIn);
        } else {
            // Input password was incorrect.
            response.fill(ResponseField.FAILURE, ResponseValues.incorrectPassword);
        }
        // send response through provided output boundary
        request.getOutput().respond(response);
    }

    /**
     * Returns the User that has been logged in by this interactor, or null otherwise.
     * @return  logged in User or null if no user has been logged in.
     */
    public User getUser() {
        return user;
    }
}


