package application;

;
import entities.Conversation;
import entities.ConversationQueue;
import entities.Message;
import entities.User;

import java.util.ArrayList;
import java.util.HashMap;

public class GetRelevantConversations extends UserInteractor{
    private User user;
    private ConversationQueue conversationQueue;

    /**
     * Initialize a new GetRelevantConversations.
     */
    GetRelevantConversations(User user){
        this.user = user;

    }

    /**
     * A request to be carried out by GetRelevantConversations.
     */
    public class GetRelevantConversationsRequest extends RequestModel{
        private OutputBoundary respondTo;
        private int locationRadius;

        /**
         * Fills in this RequestModel's instance attributes.
         */
        public void fillRequest(OutputBoundary respondTo, int locationRadius) {

            this.respondTo = respondTo;
            this.locationRadius = locationRadius;
        }
    }

    /**
     * @return  A request model to be filled in by caller
     */
    public GetRelevantConversationsRequest getRequestModel(){

        return new GetRelevantConversationsRequest();
    }

    /**
     * Accepts a request.
     * @param request   a request stored as a RequestModel
     */
    @Override
    public void request(RequestModel request) {

        GetRelevantConversationsRequest grc_request = (GetRelevantConversationsRequest) request;

        conversationQueue = new ConversationQueue(user.getLocation(), grc_request.locationRadius,
                user.getInterests());

        if (grc_request.respondTo != null){                 // if statement added for testing
            conversationQueue.addAll(DataBase.getConversationList());
            HashMap<String, Object> h_map = new HashMap<>();
            h_map.put("RelevantConversations", conversationQueue.toArray());

            grc_request.respondTo.response(new ResponseModel(h_map));
        }
    }

    /**
     * Getter method for GetRelevantConversation's conversationQueue.
     * @return Returns GetRelevantConversation's conversationQueue.
     */
    public ConversationQueue getConversationQueue(){

        return this.conversationQueue;
    }
}