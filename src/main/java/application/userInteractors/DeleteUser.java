package application.userInteractors;

import application.*;
import entities.User;

public class DeleteUser extends UserInteractor {
    private User user;
    private String Password;


    @Override
    public void request(RequestModel request) {
        String ID = (String) request.get(RequestField.ID);
        ResponseModel response = new ResponseModel();

        if (DataBase.containsUserID(ID) == Boolean.TRUE) {
            DataBase.deleteUser(ID);
            response.fill(ResponseField.SUCCESS, ResponseValues.deletedUser);
        } else {
            response.fill(ResponseField.FAILURE, ResponseValues.InvalidID);
        }
        // send response through provided output boundary
        request.getOutput().respond(response);
    }
}