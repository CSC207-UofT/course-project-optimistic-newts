package application;

import entities.Conversation;
import entities.Message;
import entities.User;

import java.util.ArrayList;
import java.util.HashMap;

public class CreateConversation extends ConversationInteractor {
    private Conversation conversation;

    /**
     * A request to be carried out by CreateConversation.
     */
    public class CreateConversationRequest extends RequestModel{
        private OutputBoundary respondTo;
        private String id;
        private String title;
        private String topic;
        private String location;
        private int locationRadius;
        private int minRating;
        private int maxSize;
        private String closingTime;
        private boolean isOpen;
        private ArrayList<Message> messages;
        private ArrayList<User> users;

        /**
         * Fills in this RequestModel's instance attributes.
         */
        public void fillRequest(OutputBoundary respondTo, String id, String title, String topic,
                                String location, int locationRadius, int minRating, int maxSize,
                                String closingTime, boolean isOpen, ArrayList<Message> messages,
                                ArrayList<User> users) {
            this.respondTo = respondTo;
            this.id = id;
            this.title = title;
            this.topic = topic;
            this.location = location;
            this.locationRadius = locationRadius;
            this.minRating = minRating;
            this.maxSize = maxSize;
            this.closingTime = closingTime;
            this.isOpen = isOpen;
            this.messages = messages;
            this.users = users;
        }
    }

    /**
     * @return  A request model to be filled in by caller
     */
    public CreateConversationRequest getRequestModel(){

        return new CreateConversationRequest();
    }

    /**
     * Accepts a request.
     * @param request   a request stored as a RequestModel
     */
    @Override
    public void request(RequestModel request) {

        CreateConversationRequest cc_request = (CreateConversationRequest) request;

        conversation = new Conversation(cc_request.id, cc_request.title, cc_request.topic, cc_request.location,
                cc_request.locationRadius, cc_request.minRating, cc_request.maxSize,
                cc_request.closingTime, cc_request.isOpen, cc_request.messages,
                cc_request.users);

        if (cc_request.respondTo != null) {                   //if statement for testing purposes
            HashMap<String, Object> h_map = new HashMap<>();
            h_map.put(cc_request.title, conversation);
            cc_request.respondTo.response(new ResponseModel(h_map));
        }
    }

    /**
     * Getter method for CreateConversation's conversation.
     * @return Returns CreateConversation's conversation.
     */
    public Conversation getConversation(){
        return this.conversation;
    }
}
