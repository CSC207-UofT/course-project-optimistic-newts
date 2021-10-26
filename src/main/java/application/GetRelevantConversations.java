package application;

import entities.ConversationQueue;

import java.util.ArrayList;
import java.util.HashMap;

public class GetRelevantConversations extends UserInteractor{
    private ConversationQueue conversationQueue;

    /**
     * A request to be carried out by GetRelevantConversations.
     */
    public class GetRelevantConversationsRequest extends RequestModel{ //TODO: Adjust to fit new RequestModel
        private OutputBoundary respondTo;
        private String location;
        private int locationRadius;
        private ArrayList<String> interests;

        /**
         * Fills in this RequestModel's instance attributes.
         */
        public void fillRequest(OutputBoundary respondTo, String location, int locationRadius,
                                ArrayList<String> interests) {

            this.respondTo = respondTo;
            this.location = location;
            this.locationRadius = locationRadius;
            this.interests = interests;
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
     * TODO: change request() based on the code in 'CliController'.
     */
    @Override
    public void request(RequestModel request) {
        GetRelevantConversationsRequest grcRequest = (GetRelevantConversationsRequest) request;

        conversationQueue = new ConversationQueue(grcRequest.location, grcRequest.locationRadius,
                grcRequest.interests);

        if (grcRequest.respondTo != null) {                 // if statement added for testing
            conversationQueue.addAll(DataBase.getConversationList());
            HashMap<String, Object> h_map = new HashMap<>();
            h_map.put("RelevantConversations", conversationQueue.toArray());
            grcRequest.respondTo.respond(new ResponseModel(h_map));
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