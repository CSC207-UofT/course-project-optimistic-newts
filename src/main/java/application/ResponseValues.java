package application;

/**
 * General response messages to include as a value in a ResponseModel.
 */
public class ResponseValues {
    public static final String loggedIn = " Logged In";
    public static final String incorrectPassword = "Incorrect password";
    public static final String invalidPassword = " Please choose a password with at least 6 characters. ";
    public static final String created = " has been created ";
    public static final String deletedUser = " has been deleted ";
    public static final String changedConversationStatus = "Changed Status of conversation with ID";
    public static final String invalidConversation = "There is no conversation with ID ";
    public static final String invalidConversationID = "Conversation ID must not be empty";
    public static final String userJoinedConversation = "has joined";
    public static final String conversationFull = "This conversation is already full.";
    public static final String belowMinimumRating = "You have a user rating below the minimum rating threshold for" +
            "this conversation.";
}
