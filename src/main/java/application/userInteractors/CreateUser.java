package application.userInteractors;

import application.*;
import entities.User;
import java.util.ArrayList;


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
            String ID = (String) request.get(RequestField.ID); //TODO adjust for new data access object
            User user = new User(Username, Password, Interests, ID);

            DataBase.addUser(user);
            response.fill(ResponseField.SUCCESS, user.getUsername() + ResponseValues.created);
        }
        else {
            response.fill(ResponseField.FAILURE, ResponseValues.invalidPassword);
        }

        // send response through provided output boundary
        request.getOutput().respond(response);
    }

    /**
     * Returns the User that was successfully created this interactor, or null otherwise.
     * @return created User or null if no user has been created.
     */
    public User getUser() {
        return user;
    }

}
