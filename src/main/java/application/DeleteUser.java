package application;

import entities.Conversation;
import entities.User;

public class DeleteUser extends UserInteractor {
    private User user;
    private String Password;


    @Override
    public void request(RequestModel request) {
        user = DataBase.getUser((String) request.get(RequestField.USER));
        ResponseModel response = new ResponseModel();
        // First, check that User user exists.
        if (user.getUsername() == null) {
            // Output an error because no such user exists with such username
            response.fill(ResponseField.EXCEPTION, new Exception(ApplicationExceptions.NoSuchConversationError));
        } else if (user.getPassword() == request.get(RequestField.PASSWORD)) {
            // Delete the user.
            DataBase.deleteUser(user);
            response.fill(ResponseField.SUCCESS, user.getUsername() + ResponseValues.DeletedUser);
        } else {
            // inputted password was incorrect
            response.fill(ResponseField.FAILURE, ResponseValues.IncorrectPassword);
        }

        // send response through provided output boundary
        request.getOutput().respond(response);

    }

    /**
     * Returns the User that was sucesfually deleted by this interactor, or null otherwise.
     * @return deleted User or null if no user has been deleted.
     */
    public User getDeletedUser() {
        return user;
    }

}