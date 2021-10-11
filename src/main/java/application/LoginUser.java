package application;

import entities.User;

import java.util.Objects;

public class LoginUser extends UserInteractor {
    private User User;
    private String Password;
    /**
     * User Interactor to LogIn and LogOut a user
     * @param user User to interact with
     */
    public LoginUser(User user) {
        super(user);
    }

    public class CreateLoginRequest extends RequestModel {
        private OutputBoundary respondTo;
        private User User;
        private String Password;

        public void fillRequest(User user, String Password) {
            this.User = user;
            this.Password = Password;
        }

    }

    /**
     * @return  A request model to be filled in by caller
     */
    public CreateLoginRequest getRequestModel() {
        return new CreateLoginRequest();
    }

    /**
     * Accepts a request.
     * @param request   a request stored as a RequestModel
     */
    @Override
    public void request(RequestModel request) {
        CreateLoginRequest request1 = (CreateLoginRequest) request;
        request1.User.logIn();
    }
}


