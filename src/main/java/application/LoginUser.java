package application;

import entities.User;

import java.util.Objects;

public class LoginUser extends UserInteractor {
    private User User;
    private String Password;

    /**
     * A request to be carried out by LoginUser.
     */
    public class LoginUserRequest extends RequestModel {
        private OutputBoundary respondTo;
        private User User;
        private String Password;

        /**
         * Fills in this RequestModel's instance attributes.
         */
        public void fillRequest(User user, String Password) {
            this.User = user;
            this.Password = Password;
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
        LoginUserRequest request1 = (LoginUserRequest) request;
        if (request1.Password == this.User.getPassword()) {
            request1.User.logIn();
        }
    }
}


