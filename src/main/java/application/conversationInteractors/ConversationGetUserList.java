package application.conversationInteractors;

import application.*;
import entities.Conversation;

import java.util.ArrayList;

public class ConversationGetUserList extends ConversationInteractor {
    private Conversation conversation;

    /**
     * Accepts a request.
     *
     * @param request a request stored as a RequestModel
     */
    @Override
    public void request(RequestModel request) throws Exception {
        // Fetching the conversation from which to get the user list
        conversation = DataBase.getConversation((String) request.get(RequestField.CONVERSATION_ID));
        ResponseModel response = new ResponseModel();
        ConfigReader config = (ConfigReader) request.get(RequestField.CONFIG);

        // Check if conversation is empty
        if (conversation.getNumUsers() == 0) {
            // Output empty conversation message
            response.fill(ResponseField.SUCCESS, config.get("emptyConversation"));
        } else {
            ArrayList<String> usernames = new ArrayList<>();
            // Get the username of the users
            // TODO: Change how Conversation store users
            for (String userId: conversation.getUsers()){
                // Retrieve username from DataBase and add it to userList
                usernames.add(DataBase.getUser(userId).getUsername());
            }
            // Get rid of the last space and comma and output users in a conversation
            response.fill(ResponseField.SUCCESS, usernames + config.get("inConversation"));
        }
        // send response through provided output boundary
        request.getOutput().respond(response);
    }

    /**
     * Returns the conversation from which to get the user list or null otherwise.
     * @return the conversation from which to get the user list.
     */
    public Conversation getConversation() {
        return conversation;
    }
}
