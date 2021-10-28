package application;

/**
 * Exception messages for use in the application module.
 */
public class ApplicationExceptions{
    public static final String NoSuchUserError = "No such user exists";
    public static final String NoSuchConversationError = "No such conversation exists";
    public static final String ConversationFullError = "The conversation is already at maximum capacity.";
    public static final String BelowMinimumRatingError = "The user has lower than the necessary rating to join this " +
            "conversation";
}
