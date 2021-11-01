package application;

import entities.Conversation;
import entities.Message;
import entities.User;


public class AddMessage extends MessageInteractor{
    Message message;
    /**
     * Accepts a request.
     *
     * @param request a request stored as a RequestModel
     */
    @Override
    public void request(RequestModel request) {
        ResponseModel response = new ResponseModel();

        // Fetching conversation that the message is being added to and user writing message
        Conversation conversation = DataBase.getConversation((String) request.get(RequestField.CONVERSATIONID));
        User user = DataBase.getUser((String) request.get(RequestField.USERNAME));

        String messageBody = ((String) request.get(RequestField.MESSAGEBODY));

        //Checks if message is empty
        if(messageBody.isEmpty()){
            response.fill(ResponseField.FAILURE, ResponseValues.emptyMessage);
        }
        else{
            String writeTime = ((String) request.get(RequestField.WRITETIME));
            String lastUpdatedTime = ((String) request.get(RequestField.LASTUPDATEDTIME));
            String messageID = ((String) request.get(RequestField.MESSAGEID));
            message  = new Message(messageID, messageBody, user);
            DataBase.addMessage(conversation.getId(), message);
            response.fill(ResponseField.SUCCESS, ResponseValues.messageSent);
        }
        // send response through provided output boundary
        request.getOutput().respond(response);
    }

    /**
     * Returns the Message that was successfully created this interactor, or null otherwise.
     * @return created Message or null if no message has been created.
     */
    public Message getMessage(){
        return message;
    }
}
