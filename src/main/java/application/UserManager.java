package application;
import application.CreateUser;
import application.LoginUser;
import entities.User;

import java.util.ArrayList;

/**
 * An object representing a UserManager of the application.
 */
public class UserManager {

    /**
     * creates and returns a new user with the given arguments.
     * @param respondTo the OutputBoundary to receive the return
     * @param username the username of the new user
     * @param password the password of the new user
     * @param location the location of the new user
     * @param interests the interests of the new user
     * @return returns the new created user
     */
    public User CreateUser(OutputBoundary respondTo, String username, String password, String location,
                           ArrayList<String> interests){
        CreateUser createUser = new CreateUser();
        CreateUser.CreateUserRequest request = createUser.getRequestModel();
        request.fillRequest(respondTo, 1, username, password, location, interests);
        createUser.request(request);
        return createUser.getUser();
    }

    /**
     * creates and returns a new user with the given arguments.
     * @param respondTo the OutputBoundary to receive the return
     * @param username the username of the user
     * @param password the password of the user
     * @return returns the new created user
     */
    public User LoginUser(OutputBoundary respondTo, String username, String password){
        LoginUser loginUser = new LoginUser();
        LoginUser.LoginUserRequest request = loginUser.getRequestModel();
        request.fillRequest(respondTo, username, password);
        loginUser.request(request);
        return loginUser.getUser();
    }
}
