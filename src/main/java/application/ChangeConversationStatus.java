package application;

import entities.Conversation;

import java.util.HashMap;
import java.util.Map;

public class ChangeConversationStatus extends ConversationInteractor{
    /**
     * Changes the status of the conversation with the id in the request
     * @param request   a request stored as a RequestModel
     */
    @Override
    public void request(RequestModel request){
        ResponseModel response = new ResponseModel();

        String conversationId = (String) request.get(RequestField.ID);
        Conversation selectedConversation = DataBase.getConversation(conversationId);

        if (selectedConversation.getId().equals("")){
            // Output an error because there is no such conversation with the id
            response.fill(ResponseField.ERROR, ResponseValues.InvalidConversation + conversationId);
        } else {
            // Change the status of the conversation
            selectedConversation.setIsOpen(!selectedConversation.getIsOpen());
            response.fill(ResponseField.SUCCESS, ResponseValues.ChangedConversationStatus + conversationId);
        }

        request.getOutput().respond(response);
    }
}
