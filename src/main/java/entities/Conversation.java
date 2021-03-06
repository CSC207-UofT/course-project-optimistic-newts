package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a conversation
 */
public class Conversation {
    private final String id;
    private String title;
    private final List<String> topics;
    private String location;
    private final int locationRadius;
    private int minRating;
    private int maxSize;
    private String closingTime;
    private boolean isOpen;
    private final List<Message> messages;
    private final List<User> users;

    public Conversation(String id, String title,
                        List<String> topics, String location,
                        int locationRadius,
                        int minRating, int maxSize,
                        String closingTime, boolean isOpen,
                        ArrayList<Message> messages,
                        ArrayList<User> users) {
        this.id = id;
        this.title = title;
        this.topics = topics;
        this.location = location;
        this.locationRadius = locationRadius;
        this.minRating = minRating;
        this.maxSize = maxSize;
        this.closingTime = closingTime;
        this.isOpen = isOpen;
        this.messages = messages;
        this.users = users;
    }

    public Conversation() {
        this.id = "";
        this.title = "";
        this.topics = new ArrayList<>();
        this.location = "";
        this.locationRadius = 0;
        this.minRating = 0;
        this.maxSize = 0;
        this.closingTime = "";
        this.isOpen = false;
        this.messages = new ArrayList<Message>();
        this.users = new ArrayList<User>();
    }


    /**
     * Return the id of the conversation.
     * @return a string representing the id
     */
    public String getId(){ return this.id; }

    /**
     * Return the title of the conversation.
     * @return a string representing the title
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * Return the topic of the conversation.
     * @return a string representing the topic of the conversation
     */
    public List<String> getTopics() { return this.topics; }

    /**
     * Return the location of the conversation.
     * @return a string representing the location
     */
    public String getLocation(){
        return this.location;
    }

    /**
     * Return the radius of the location.
     * @return an int representing the location radius
     */
    public int getLocationRadius(){ return this.locationRadius; }

    /**
     * Return the minimum rating of the conversation.
     * @return an int representing the minimum rating of the conversation
     */
    public int getMinRating(){
        return this.minRating;
    }

    /**
     * Return the maximum number of users in the conversation.
     * @return an int representing the max number of users
     */
    public int getMaxSize(){
        return this.maxSize;
    }

    /**
     * Return the time the conversation closes.
     * @return a string representing the closing time of the conversation
     */
    public String getClosingTime(){
        return this.closingTime;
    }

    /**
     * Return if the conversation is open.
     * @return true if the conversation is open
     */
    public boolean getIsOpen(){
        return this.isOpen;
    }

    /**
     * Return the messages in the conversation.
     * @return an ArrayList containing messages
     */
    public List<Message> getMessages(){
        return this.messages;
    }

    /**
     * Return the users in the conversation.
     * @return an ArrayList containing users
     */
    public List<User> getUsers(){
        return this.users;
    }

    /**
     * Set a title for the conversation.
     * @param title the title to be set
     */
    public void setTitle(String title){ this.title = title; }

    /**
     * Add a topic to this conversation.
     * @param topic the topic to be added
     */
    public void addTopic(String topic) {
        topics.add(topic);
    }

    /**
     * Remove a topic from this conversation, if this topic is in this conversations topics.
     * @param topic     Topic to remove
     */
    public void removeTopic(String topic) {
        topics.remove(topic);
    }

    /**
     * Set a location for the conversation.
     * @param location the location to be set
     */
    public void setLocation(String location){ this.location = location; }

    /**
     * Set a rating for the conversation.
     * @param minRating the rating to be set
     */
    public void setMinRating(int minRating){ this.minRating = minRating; }

    /**
     * Set the max number of users in the conversation.
     * @param maxSize the max number of users to be set
     */
    public void setMaxSize(int maxSize){ this.maxSize = maxSize; }

    /**
     * Set the closing time for the conversation.
     * @param closingTime the closing time to be set
     */
    public void setClosingTime(String closingTime){ this.closingTime = closingTime; }

    /**
     * Set the status of the conversation.
     */
    public void toggleIsOpen(){ this.isOpen = !this.isOpen; }

    /**
     * Add a message to the conversation.
     * @param message the message to be added
     */
    public void addMessage(Message message){ this.messages.add(message); }

    /**
     * Add a user to the conversation.
     * @param user a user to be added
     * @return true if the user was added
     */
    public boolean addUser(User user){
        if (this.users.size() < this.maxSize){
            this.users.add(user);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the number of Users in a Conversation
     * @return Number of users
     */
    public int getNumUsers(){
        return users.size();
    }

    /**
     * Remove a user from a conversation.
     * @param user a user to be removed
     * @return true if the user was removed
     */
    public boolean removeUser(User user) {
        if (this.users.contains(user)){
            this.users.remove(user);
            return true;
        } else {
            return false;
        }
    }
}
