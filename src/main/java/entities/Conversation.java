package entities;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A class representing a conversation
 */
public class Conversation {
    private String title;
    private String location;
    private int rating;
    private int maxUsers;
    private String closingTime;
    private String status;
    private ArrayList<Message> messages;
    private ArrayList<User> users;

    public Conversation(String conversationTitle, String conversationLocation,
                        int conversationRating, int conversationMaxUsers,
                        String conversationClosingTime, String conversationStatus,
                        ArrayList<Message> conversationMessages,
                        ArrayList<User> conversationUsers) {
        this.title = conversationTitle;
        this.location = conversationLocation;
        this.rating = conversationRating;
        this.maxUsers = conversationMaxUsers;
        this.closingTime = conversationClosingTime;
        this.status = conversationStatus;
        this.messages = conversationMessages;
        this.users = conversationUsers;
    }

    public Conversation(String conversationTitle) {
        this.title = conversationTitle;
        this.location = "";
        this.rating = 0;
        this.maxUsers = 0;
        this.closingTime = "";
        this.status = "Open";
        this.messages = new ArrayList<Message>();
        this.users = new ArrayList<User>();
    }

    /**
     * Return the title of the conversation.
     * @return a string representing the title
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * Return the location of the conversation.
     * @return a string representing the location
     */
    public String getLocation(){
        return this.location;
    }

    /**
     * Return the rating of the conversation.
     * @return an int representing the rating of the conversation
     */
    public int getRating(){
        return this.rating;
    }

    /**
     * Return the maximum number of users in the conversation.
     * @return an int representing the max number of users
     */
    public int getMaxUsers(){
        return this.maxUsers;
    }

    /**
     * Return the time the conversation closes.
     * @return a string representing the closing time of the conversation
     */
    public String getClosingTime(){
        return this.closingTime;
    }

    /**
     * Return the status of the conversation.
     * @return a string representing the status of the conversation
     */
    public String getStatus(){
        return this.status;
    }

    /**
     * Return the messages in the conversation.
     * @return an ArrayList containing messages
     */
    public ArrayList<Message> getMessages(){
        return this.messages;
    }

    /**
     * Return the users in the conversation.
     * @return an ArrayList containing users
     */
    public ArrayList<User> getUsers(){
        return this.users;
    }

    /**
     * Set a title for the conversation.
     * @param title the title to be set
     */
    public void setTitle(String title){ this.title = title; }

    /**
     * Set a location for the conversation.
     * @param location the location to be set
     */
    public void setLocation(String location){ this.location = location; }

    /**
     * Set a rating for the conversation.
     * @param rating the rating to be set
     */
    public void setRating(int rating){ this.rating = rating; }

    /**
     * Set the max number of users in the conversation.
     * @param maxUsers the max number of users to be set
     */
    public void setMaxUsers(int maxUsers){ this.maxUsers = maxUsers; }

    /**
     * Set the closing time for the conversation.
     * @param closingTime the closing time to be set
     */
    public void setClosingTime(String closingTime){ this.closingTime = closingTime; }

    /**
     * Set the status of the conversation.
     * @param status the status to be set
     */
    public void setStatus(String status){ this.status = status; }

    /**
     * Set the messages in the conversation.
     * @param messages the list of messages to be set
     */
    public void setMessages(ArrayList<Message> messages){ this.messages = messages; }

    /**
     * Set the users in the conversation.
     * @param users the list of users to be set
     */
    public void setUsers(ArrayList<User> users){ this.users = users; }
}
