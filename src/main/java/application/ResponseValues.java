package application;

/**
 * General response messages to include as a value in a ResponseModel.
 */
public class ResponseValues {
    public static final String LoggedIn = " Logged In";
    public static final String IncorrectPassword = "Incorrect password";
    public static final String InvalidPassword = " Please choose a password with at least 6 characters. ";
    public static final String Created = " has been created ";
    public static final String DeletedUser = " has been deleted ";
    public static final String ChangedConversationStatus = "Changed Status of conversation with ID";
    public static final String InvalidConversation = "There is no conversation with ID ";
    public static final String InvalidConversationID = "Conversation ID must not be empty";
    public static final String userJoinedConversation = "has joined";
    public static final String conversationFull = "This conversation is already full.";
    public static final String belowMinimumRating = "You have a user rating below the minimum rating threshold for" +
            "this conversation.";
}
