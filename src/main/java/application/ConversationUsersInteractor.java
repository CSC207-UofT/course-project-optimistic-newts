package application;

import entities.Conversation;
import entities.Message;
import entities.User;

import java.util.ArrayList;
import java.util.Objects;

public class ConversationUsersInteractor extends ConversationInteractor {

    private final Conversation conversation;

    /**
     * Construct a new ConversationInteractor object to interact with a Conversation.
     *
     * @param conversation Conversation to interact with
     */
    public ConversationUsersInteractor(Conversation conversation) {
        this.conversation = conversation;
    }

    /**
     * Construct a request model.
     */
    public class ConversationUsersInteractorRequest extends RequestModel{
        private String action;
        private User user;

        public ConversationUsersInteractorRequest(){
        }

        /**
         * Fills in this RequestModel's instance attributes.
         */
        public void fillRequest() {
            this.action = action;
            this.user = user;
        }
    }

    public ConversationUsersInteractorRequest getRequestModel(String action, User user){
        return new ConversationUsersInteractorRequest(action, user);
    }

    /**
     * Accept a given (RequestModel) request.
     *
     * @param request   a request stored as a RequestModel
     */
    @Override
    public void request(ConversationUsersInteractorRequest request){
        String action = request.action;
        if (Objects.equals(action, "addUser")) {
            this.addUser(request.user);
        } else if (Objects.equals(action, "removeUser")) {
            this.removeUser(request.user);
        }
    }

    /**
     * Add a user to the conversation.
     *
     * @param u a user to be added to the conversation.
     */
    public void addUser(User u) {
        this.conversation.addUser(u);
    }

    /**
     * Remove a user to the conversation.
     *
     * @param u a user to remove from the conversation.
     */
    public void removeUser(User u) {
        ArrayList<User> user_lst = this.conversation.getUsers();
        user_lst.remove(u);
    }
}

class main{
    public static void main(String[] args) {
        ArrayList<String> interests = new ArrayList<>();
        interests.add("darkside");
        User u = new User("Darth Vader", "deathstar", interests, 123);
        Conversation c = new Conversation("", "Sample Conversation", "", "", 0, 0,
                5, "", true, new ArrayList<Message>(), new ArrayList<User>());
    }
}