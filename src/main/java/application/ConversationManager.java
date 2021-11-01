package application;

import application.conversationInteractors.*;
import entities.Conversation;

import javax.print.attribute.standard.RequestingUserName;

/**
 * An object representing a ConversationManager of the application.
 */
public class ConversationManager {

    /**
     * Creates a conversation using request
     * @param request the filled in RequestModel
     */
    public void createConversation(RequestModel request){
        CreateConversation createConversation = new CreateConversation();
        createConversation.request(request);
    }

    /**
     * Changes the status of a conversation specified by request
     * @param request the filled in RequestModel
     */
    public void changeConversationStatus(RequestModel request) {
        ChangeConversationStatus changeConversationStatus = new ChangeConversationStatus();
        changeConversationStatus.request(request);
    }

    /**
     * Adds the user specified by request to the conversation
     * @param request the filled in RequestModel
     */
    public void addUser(RequestModel request){
        ConversationAddUser conversationAddUser = new ConversationAddUser();
        conversationAddUser.request(request);
    }

    // TODO: Implement this with the method properly
    /**
     *
     * @param request the filled in RequestModel
     */
    public void getUserList(RequestModel request){
        ConversationGetUserList conversationGetUserList= new ConversationGetUserList();
        conversationGetUserList.request(request);
    }

    /**
     * Removes the user specified by request to the conversation
     * @param request the filled in RequestModel
     */
    public void removeUser(RequestModel request){
        ConversationRemoveUser conversationRemoveUser = new ConversationRemoveUser();
        conversationRemoveUser.request(request);
    }

    //TODO: Whatever needs to be done with regards to the conversationqueue stuff
}