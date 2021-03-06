package application.conversation;

import application.*;
import entities.Conversation;

public class ChangeConversationStatus extends ConversationInteractor {
    /**
     * Changes the status of the conversation with the id in the request
     *
     * @param request a request stored as a RequestModel
     */
    @Override
    public void request(RequestModel request) {
        ResponseModel response = new ResponseModel();

        String conversationId = (String) request.get(RequestField.ID);
        Conversation selectedConversation = DataBase.getConversation(conversationId);
        ConfigReader config = (ConfigReader) request.get(RequestField.CONFIG);

        if (selectedConversation.getId().equals("")) {
            // Output an error because there is no such conversation with the id
            response.fill(ResponseField.FAILURE, config.get("invalidConversation") + conversationId);
        } else {
            // Change the status of the conversation
            selectedConversation.toggleIsOpen();
            if (selectedConversation.getIsOpen()) {
                response.fill(ResponseField.SUCCESS, config.get("changedConversationStatus") +
                        conversationId + " to open");
            } else {
                response.fill(ResponseField.SUCCESS, config.get("changedConversationStatus") +
                        conversationId + " to closed");
            }
            request.getOutput().respond(response);
        }
    }
}
