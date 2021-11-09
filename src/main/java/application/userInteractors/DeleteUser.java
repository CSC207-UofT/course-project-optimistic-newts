package application.userInteractors;

import application.*;
import entities.User;

public class DeleteUser extends UserInteractor {
    private User user;
    private String Password;


    @Override
    public void request(RequestModel request) throws Exception {
        ResponseModel response = new ResponseModel();
        ConfigReader config = (ConfigReader) request.get(RequestField.CONFIG);

        String ID = (String) request.get(RequestField.ID);

        if (DataBase.containsUserID(ID) == Boolean.TRUE) {
            DataBase.deleteUser(ID);
            response.fill(ResponseField.SUCCESS, config.get("deletedUser"));
        } else {
            response.fill(ResponseField.FAILURE, config.get("InvalidID"));
        }
        // send response through provided output boundary
        request.getOutput().respond(response);
    }
}