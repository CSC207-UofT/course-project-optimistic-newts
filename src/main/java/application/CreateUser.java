package application;

import entities.Conversation;
import entities.User;
import java.util.ArrayList;

public class CreateUser extends UserInteractor {
    private User User;

    /**
     * A request to be carried out by CreateUser.
     */
    public class CreateUserRequest extends RequestModel {
        private OutputBoundary respondTo;
        private int id;
        private String username;
        private String password;
        private Object location;
        private ArrayList<String> interests;
        private float rating;
        private int numRatings;
        private boolean loginStatus;
        private ArrayList<User> friends;
        private ArrayList<Conversation> conversations;


        /**
         * Fills in this RequestModel's instance attributes.
         */
        public void fillRequest(OutputBoundary respondTo, int id, String username, String password, Object location,
                                ArrayList<String> interests, float rating, int numRatings, boolean loginStatus,
                                ArrayList<User> friends, ArrayList<Conversation> conversations) {
            this.respondTo = respondTo;
            this.id = id;
            this.username = username;
            this.password = password;
            this.location = location;
            this.interests = interests;
            this.rating = rating;
            this.numRatings = numRatings;
            this.loginStatus = loginStatus;
            this.friends = friends;
            this.conversations = conversations;
        }

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
        User = new User(request1.username, request1.password, request1.interests, request1.id);
        }
    }

