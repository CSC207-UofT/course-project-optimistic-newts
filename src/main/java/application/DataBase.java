package application;

import entities.Conversation;
import entities.ConversationQueue;
import entities.Message;
import entities.User;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class DataBase {

    private static final ArrayList<User> UserList = new ArrayList<>();
    private static final ArrayList<Conversation> ConversationList = new ArrayList<>();
    private static final ArrayList<Message> MessageList = new ArrayList<>();

    /**
     * add a Conversation to ConversationList
     * @param user Conversation to be added
     */
    public static void addUser(User user){
        UserList.add(user);
    }

    public static User getUser(String username) {
        for (User user : UserList) {
            if (Objects.equals(user.getUsername(), username)) {
                return user;
            }
        }
        return new User();
    }

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
