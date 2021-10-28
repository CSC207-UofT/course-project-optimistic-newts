package application;

import entities.EntityExceptions;
import entities.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CreateUser extends UserInteractor {
    private User user;

    @Override
    public void request(RequestModel request) {
        ResponseModel response = new ResponseModel();
        user.setUsername((String) request.get(RequestField.USERNAME));

        // Check if this username is already taken
        if (DataBase.checkForUser(user)) {
            response.fill(ResponseField.FAILURE, ResponseValues.UsernameTaken);
        }

        try {
            user.setPassword((String) request.get(RequestField.PASSWORD));

            // All conditions met. create this user.
            user.setLocation((String) request.get(RequestField.LOCATION));
            user.addInterests((String) request.get(RequestField.INTERESTS));

            DataBase.addUser(user);
            response.fill(ResponseField.SUCCESS, user.getUsername() + ResponseValues.CreateUser);

        } catch (EntityExceptions e) {
            e.printStackTrace();
            response.fill(ResponseField.FAILURE, ResponseValues.InvalidPassword);
            }

        // send response through provided output boundary
        request.getOutput().respond(response);
    }

    /**
     * Returns the User that was sucesfually createdby this interactor, or null otherwise.
     * @return created User or null if no user has been created.
     */
    public User getCreatedUser() {
        return user;
    }

}


