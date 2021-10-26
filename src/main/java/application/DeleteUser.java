package application;

import entities.Conversation;
import entities.User;

import java.util.ArrayList;
import java.util.Objects;

public class DeleteUser extends UserInteractor {
    private User User;
    private String Password;

    /**
     * A DeleteUserRequest to be carried out by LoginUser.
     */
    public class DeleteUserRequest extends RequestModel { //TODO: adjust to fit new RequestModel
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
    public DeleteUser.DeleteUserRequest getRequestModel() {
        return new DeleteUser.DeleteUserRequest();
    }

    /**
     * Accepts a DeleteUserRequest.
     * @param request   a request stored as a RequestModel
     */
    @Override
    public void request(RequestModel request) {
        DeleteUser.DeleteUserRequest request1 = (DeleteUser.DeleteUserRequest) request;
        if (request1.Password.equals(this.User.getPassword())) DataBase.deleteUser(request1.User);
    }
}