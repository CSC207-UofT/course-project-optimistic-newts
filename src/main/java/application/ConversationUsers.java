package application;

import entities.Conversation;
import entities.Message;
import entities.User;

import java.util.ArrayList;
import java.util.Objects;

public class ConversationUsers extends ConversationInteractor {
    private final Conversation conversation;

    /**
     * Construct a new ConversationUser object to interact with a Conversation.
     *
     * @param conversation Conversation to interact with
     */
    public ConversationUsers(Conversation conversation) {
        this.conversation = conversation;
    }

    /**
     * A request to be carried out by ConversationUser.
     */
    public class ConversationUsersRequest extends RequestModel{
        private OutputBoundary respondTo;
        private String action;
        private User user;

        /**
         * Fills in this RequestModel's instance attributes.
         */
        public void fillRequest(OutputBoundary respondTo, String action, User user) {
            this.respondTo = respondTo;
            this.action = action;
            this.user = user;
        }
    }

    /**
     * @return  A request model to be filled in by caller
     */
    public ConversationUsersRequest getRequestModel(){
        return new ConversationUsersRequest();
    }

    /**
     * Accept a given (RequestModel) request.
     *
     * @param request1   a request stored as a RequestModel
     */
    @Override
    public void request(RequestModel request1){
        ConversationUsersRequest request = (ConversationUsersRequest) request1;
        String action = request.action;
        if (Objects.equals(action, "addUser")) {
            this.addUser(request.user);
        } else if (Objects.equals(action, "removeUser")) {
            this.removeUser(request.user);
        } else if (Objects.equals(action, "getUserlist")){
            ArrayList<User> UserList = this.getUserList();
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
     * Remove a user from the conversation.
     *
     * @param u a user to remove from the conversation.
     */
    public void removeUser(User u) {
        ArrayList<User> user_lst = this.conversation.getUsers();
        user_lst.remove(u);
    }

    /**
     * Return the users in a conversation.
     *
     * @return an ArrayList containing the users in a conversation
     */
    public ArrayList<User> getUserList() {
        return this.conversation.getUsers();
    }
}
