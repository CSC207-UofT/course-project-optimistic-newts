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

        DataBase.deleteUser(user);
        response.fill(ResponseField.SUCCESS, user.getId() + ResponseValues.DeletedUser);

        // send response through provided output boundary
        request.getOutput().respond(response);

    }
}