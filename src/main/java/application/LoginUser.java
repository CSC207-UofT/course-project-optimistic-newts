package application;

import entities.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LoginUser extends UserInteractor {
    private User user;
    private String password;

    /**
     * A request to be carried out by LoginUser.
     */
    public class LoginUserRequest extends RequestModel {
        private OutputBoundary respondTo;
        private String username;
        private String password;

        /**
         * Fills in this RequestModel's instance attributes.
         */
        public void fillRequest(OutputBoundary respondTo, String username, String password) {
            this.respondTo = respondTo;
            this.username = username;
            this.password = password;
        }

    }

    /**
     * @return  A request model to be filled in by caller
     */
    public LoginUserRequest getRequestModel() {
        return new LoginUserRequest();
    }

    /**
     * Accepts a request.
     * @param request   a request stored as a RequestModel
     */
    @Override
    public void request(RequestModel request) {
        LoginUserRequest loginRequest = (LoginUserRequest) request;
        User toLogIn = DataBase.getUser(loginRequest.username);
        if (toLogIn.getUsername() == null) {
            // Output an error because there is no such user with username
            Map<String, Object> responseMap = new HashMap<>();
            responseMap.put("Failure", new Exception(ApplicationExceptions.NoSuchUserError).getMessage());
            ResponseModel response = new ResponseModel(responseMap);
            loginRequest.respondTo.response(response);
        } else if (Objects.equals(toLogIn.getPassword(), loginRequest.password)) {
            // Login the user and send the user as response
            toLogIn.logIn();
            Map<String, Object> responseMap = new HashMap<>();
            String s = loginRequest.username + " logged in";
            responseMap.put("Success", s);
            ResponseModel response = new ResponseModel(responseMap);
            loginRequest.respondTo.response(response);
            this.user = toLogIn;
        } else {
            // Output that there was a failure because the input password was incorrect.
            Map<String, Object> responseMap = new HashMap<>();
            responseMap.put("Error", new Exception(ApplicationExceptions.IncorrectPasswordError).getMessage());
            ResponseModel response = new ResponseModel(responseMap);
            loginRequest.respondTo.response(response);
        }
    }

    /**
     * Returns the User that has been logged in by this interactor, or null otherwise.
     * @return  logged in User or null if no user has been logged in.
     */
    public User getUser() {
        return user;
    }
}


