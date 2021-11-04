package application.conversationInteractors;

import application.*;
import application.userInteractors.UserInteractor;
import entities.ConversationQueue;
import entities.User;


import java.util.ArrayList;

public class GetRelevantConversations extends UserInteractor {
    private ConversationQueue conversationQueue;
    private User user;

    /**
     * Accepts a request.
     *
     * @param request a request stored as a RequestModel
     */
    @Override
    public void request(RequestModel request) {
        // Fetching User to generate ConversationQueue for
        user = DataBase.getUser((String) request.get(RequestField.USERNAME));

        // Create a ConversationQueue with desired settings
        conversationQueue = new ConversationQueue((String) request.get(RequestField.LOCATION),
                (int) request.get(RequestField.LOCATION_RADIUS),
                (ArrayList<String>) request.get(RequestField.INTERESTS));
        ResponseModel response = new ResponseModel();

        //Get all the conversations in DataBase
        conversationQueue.addAll(DataBase.getConversationList());
        response.fill(ResponseField.VALUE, conversationQueue.toArray());
        // send response through provided output boundary
        request.getOutput().respond(response);
    }
    /**
     * Getter method for GetRelevantConversation's conversationQueue.
     * @return Returns GetRelevantConversation's conversationQueue.
     */
    public ConversationQueue getConversationQueue(){

        return this.conversationQueue;
    }

    /**
     * Getter method for GetRelevantConversation's user.
     * @return Returns GetRelevantConversation's user.
     */
    public User getUser(){

        return this.user;
    }
}