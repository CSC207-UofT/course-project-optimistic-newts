package entities;

import java.util.ArrayList;

/**
 * An object representing a User of the application.
 */
public class User {
    private int id;
    private String username;
    private String password;
    private Object location;
    private ArrayList<String> interests;
    private float rating;
    private int numRatings;
    private boolean loginStatus;
    private ArrayList<User> friends;
    private ArrayList<Conversation> conversations;

    /**
     *
     * @param username The user's username.
     * @param password The user's password.
     * @param interests An ArrayList of the user's initial specified interests.
     */
    public User(String username,
                String password,
                ArrayList<String> interests,
                int id){
        this.username = username;
        this.password = password;
        this.interests = interests;
        this.id = id;
    }

    /**
     * Getter methods for the login status of the user
     * @return Returns loginStatus of user.
     */
    public boolean getLoginStatus(){
        return loginStatus;
    }

    /**
     * Getter method for user's ID.
     * @return Returns user ID.
     */
    public int getId(){
        return id;
    }

    /**
     * Getter method for user's username.
     * @return Returns user's username.
     */
    public String getUsername(){
        return username;
    }

    /**
     * Setter method for username
     * @param username Username to be set
     */
    public void setUsername(String username) {this.username = username;}

    /**
     * Getter method for user's password.
     * NOTE: This is probably a bad idea to have.
     * @return Returns user's password
     */
    public String getPassword(){
        return password;
    }
    /**
     * Getter method for user's last updated location.
     * NOTE: Wasn't sure what type the location data would be,
     * using type Object for now, to be changed later.
     * @return Returns user's last updated location.
     */
    public Object getLocation(){
        return location;
    }

    /**
     * Setter method for the user's password
     * @param password Password to be set
     */

    public void setPassword(String password) throws EntityExceptions {
        if(password.length() >= 6) {
            this.password = password;
            }
        else throw new EntityExceptions("Please choose a password with at least 6 characters.");
        }

    /**
     * Setter method for user's location.
     * @param location Location of user (Type to be changed)
     */
    public void setLocation(Object location){
        this.location = location;
    }

    /**
     * Getter method for ArrayList of user interest.
     * @return Returns ArrayList of user interests.
     */
    public ArrayList<String> getInterests() {
        return interests;
    }

    /**
     * Adds supplied interest to user's interests ArrayList
     * @param interest New interest to be added
     */
    public void addInterests(String interest){
        interests.add(interest);
    }

    /**
     * Removes specified interest from user's interests
     * @param interest Interest to be removed
     */
    public void removeInterest (String interest) throws EntityExceptions {
        int index = interests.indexOf(interest);
        if (index != -1)
            interests.remove(index);
        else
            throw new EntityExceptions("Interest not in interest list.");
    }

    /**
     * Getter method which returns the user's average rating
     * @return User's average rating
     */
    public float getRating() {
        return rating/numRatings;
    }

    /**
     * Adds rating to user's total rating and increases
     * The number of ratings by one.
     * @param rating Rating to be added
     */
    public void addRating(float rating){
        this.rating += rating;
        numRatings ++;
    }

    /**
     * Sets user loginStatus to True
     */
    public void logIn(){
        loginStatus = true;
    }

    /**
     * Sets user loginStatus to false
     */
    public void logOut(){
        loginStatus = false;
    }

    /**
     * Adds specified user to user's friendslist
     * @param friend User to be added as friend
     */
    public void addFriend(User friend) {
        friends.add(friend);
    }

    /**
     * Removes specified user from user's friendslist
     * @param friend User to be removed
     */
    public void removeFriend(User friend) throws EntityExceptions{
        int index = friends.indexOf(friend);
        if (index != -1)
            friends.remove(index);
        else
            throw new EntityExceptions("User not in friend's list.");
    }

    /**
     * Getter method which returns user's friendslist
     * @return Returns user's friendslist which is an ArrayList of users
     */
    public ArrayList<User> getFriends(){
        return friends;
    }

    /**
     * Adds specified conversation object to user's list of active conversations
     * @param conversation Conversation to be added
     */
    public void addConversation(Conversation conversation){
        conversations.add(conversation);
    }

    /**
     * Removes specified conversation from user's list
     * of active conversations.
     * @param conversation Conversation to be removed
     */
    public void removeConversation(Conversation conversation) throws EntityExceptions{
        int index = conversations.indexOf(conversation);
        if(index != -1)
            conversations.remove(conversation);
        else
            throw new EntityExceptions("Conversation not in conversation list.");
    }

    /**
     * Returns list of user's active conversations.
     * @return ArrayList of user's active conversations.
     */
    public ArrayList<Conversation> getConversations(){
        return conversations;
    }

}

