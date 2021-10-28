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

        // check that password is strong enough before creating User
        if (((String) request.get(RequestField.PASSWORD)).length() >= 6) {

            String Username = ((String) request.get(RequestField.USERNAME));
            String Password = (String) request.get(RequestField.PASSWORD);
            ArrayList<String> Interests = new ArrayList<>();
            Interests.add((String) request.get(RequestField.INTERESTS));
            int ID = (int) request.get(RequestField.ID); //TODO adjust for new data access object
            User user = new User(Username, Password, Interests, ID);

            DataBase.addUser(user);
            response.fill(ResponseField.SUCCESS, user.getUsername() + ResponseValues.CreateUser);
        }
        else {
            response.fill(ResponseField.FAILURE, ResponseValues.InvalidPassword);
        }

        // send response through provided output boundary
        request.getOutput().respond(response);
    }

    /**
     * Returns the User that was sucesfually createdby this interactor, or null otherwise.
     * @return created User or null if no user has been created.
     */
    public User getUser() {
        return user;
    }

}


