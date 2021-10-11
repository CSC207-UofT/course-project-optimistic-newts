package entities;

import java.util.List;

/**
 * A KeyedConversation. Used to pair a conversation with an integer key representing the relevance to
 * a ConversationQueue's ordering.
 */
public class KeyedConversation {
    private Conversation conversation;
    private int key = 0;

    /**
     * Create a new KeyedConversation, where key is the number of topic matches.
     * @param conversation  Conversation to pair key to
     * @param params        Relevance parameters
     */
    public KeyedConversation(Conversation conversation, String[] params) {
        this.conversation = conversation;
        key = 0;
        for (String param : params) {
            if (conversation.getTopic().equals(param)) {
                key += 1;
            }
        }
    }

    /**
     * @return  The key associated with this KeyedConversation.
     */
    public int getKey() {
        return key;
    }
}
