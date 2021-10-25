package application;

import entities.Conversation;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class ChangeConversationStatus extends ConversationInteractor{
    private Conversation conversation;

    /**
     * Fills in this RequestModel's instance attributes.
     * For this use case we need the id of the conversation
     * to change status for.
     */
    public class ChangeConversationRequest extends RequestModel{
        private OutputBoundary respondTo;
        private String id;

        public void fillRequest(OutputBoundary respondTo, String id){
            this.respondTo = respondTo;

        }
    }

    /**
     * Return a request model that is filled in by the caller
     * @return A request model to be filled in by caller
     */
    public ChangeConversationRequest getRequestModel(){
        return new ChangeConversationRequest();
    }

    /**
     * Set the conversation to the one specified by the id
     * @param request   a request stored as a RequestModel
     */
    @Override
    public void request(RequestModel request){

        ChangeConversationRequest cc_request = (ChangeConversationRequest) request;

        Conversation selectedConversation = DataBase.getConversation(cc_request.id);
        if (selectedConversation.getId().equals("")){
            // Output an error because there is no such conversation with id
            Map<String, Object> responseMap = new HashMap<>();
            responseMap.put("Failure",
                    new Exception(ApplicationExceptions.NoSuchConversationError).getMessage());
            ResponseModel response = new ResponseModel(responseMap);
            cc_request.respondTo.response(response);
        } else {
            // Set the conversation
            Map<String, Object> responseMap = new HashMap<>();
            String s = cc_request.id + " conversation selected";
            responseMap.put("Success", s);
            ResponseModel response = new ResponseModel(responseMap);
            cc_request.respondTo.response(response);
            this.conversation = selectedConversation;
        }
    }

    /**
     * Changes the status of the conversation specified by the request
     */
    public void changeStatus(){
        // Closes the conversation if it is open and vice versa
        conversation.setIsOpen(!conversation.getIsOpen());
    }
}
