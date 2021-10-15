package application;

import entities.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//TODO: Check that username is not already in use before creating.

public class CreateUser extends UserInteractor {
    private User user;

    /**
     * A request to be carried out by CreateUser.
     */
    public class CreateUserRequest extends RequestModel {
        private OutputBoundary respondTo;
        private int id;
        private String username;
        private String password;
        private String location;
        private ArrayList<String> interests;


        /**
         * Fills in this RequestModel's instance attributes.
         */
        public void fillRequest(OutputBoundary respondTo, int id, String username, String password, String location,
                                ArrayList<String> interests) {
            this.respondTo = respondTo;
            this.id = id;
            this.username = username;
            this.password = password;
            this.location = location;
            this.interests = interests;
        }

    }

    /**
     * @return  the User created by this CreateUser request, or null if no such user exists.
     */
    public User getUser() {
        return user;
    }

    /**
     * @return  A request model to be filled in by caller
     */
    public CreateUserRequest getRequestModel() {
        return new CreateUserRequest();
    }

    /**
     * Accepts a request.
     * @param request   a request stored as a RequestModel
     */
    @Override
    public void request(RequestModel request) {
        CreateUserRequest request1 = (CreateUserRequest) request;
        user = new User(request1.username, request1.password, request1.interests, request1.id);
        // output that user creation was successful
        Map<String, Object> responseMap = new HashMap<>();
        String s = request1.username + " successfully created!";
        responseMap.put("Success", s);
        ResponseModel response = new ResponseModel(responseMap);
        request1.respondTo.response(response);
        DataBase.addUser(user);
        }
    }

