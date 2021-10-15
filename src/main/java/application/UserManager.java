package application;
import application.CreateUser;
import application.LoginUser;
import entities.User;

import java.util.ArrayList;

/**
 * An object representing a UserManager of the application.
 */
public class UserManager {
    private CreateUser createUser;
    private LoginUser loginUser;

    public UserManager() {
        createUser = new CreateUser();
        loginUser = new LoginUser();
    }

    /**
     * creates and returns a new user with the given arguments.
     * @return returns the new created user
     */
    public User CreateUser(OutputBoundary respondTo, String username, String password, String location,
                           ArrayList<String> interests){
        CreateUser.CreateUserRequest request = createUser.getRequestModel();
        request.fillRequest(respondTo, 1, username, password, location, interests);
        createUser.request(request);
        return createUser.getUser();
    }

    /**
     * creates and returns a new user with the given arguments.
     * @param
     * @return returns the new created user
     */
    public User LoginUser(OutputBoundary respondTo, String username, String password){
        LoginUser.LoginUserRequest request = loginUser.getRequestModel();
        request.fillRequest(respondTo, username, password);
        loginUser.request(request);
        return loginUser.getUser();
    }
}
