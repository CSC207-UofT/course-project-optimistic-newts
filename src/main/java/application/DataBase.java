package application;

import entities.Conversation;
import entities.ConversationQueue;
import entities.Message;
import entities.User;

import java.util.ArrayList;

public class DataBase {

    private static ArrayList<User> UserList;
    private static ArrayList<Conversation> ConversationList;
    private static ArrayList<Message> MessageList;

    /**
     * add a Conversation to ConversationList
     * @param user Conversation to be added
     */
    public static void addUser(User user){
        UserList.add(user);
    }


    public static void deleteUser(User user) {UserList.remove(user); }


    /**
     * add a Conversation to ConversationList
     * @param conversation Conversation to be added
     */
    public static void addConversation(Conversation conversation){
        ConversationList.add(conversation);
    }

    /**
     * return the ConversationList
     * @return  returns ConversationList
     */
    public static ArrayList<Conversation> getConversationList(){
        return (ArrayList<Conversation>) ConversationList.clone();
    }
}
