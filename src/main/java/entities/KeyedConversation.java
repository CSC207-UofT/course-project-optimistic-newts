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
     * @return  The conversation associated with this KeyedConversation.
     */
    public Conversation getConversation() {
        return conversation;
    }

    /**
     * @return  The key associated with this KeyedConversation.
     */
    public int getKey() {
        return key;
    }

    /**
     * Primarily intended for testing purposes.
     * @param key   key to set this KeyedConversation's key to.
     */
    public void setKey(int key) {this.key = key;}

    /**
     * @param other an instance of KeyedConversation
     * @return true iff the contained conversations in this and other are equal
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof KeyedConversation)) {
            return false;
        }
        return (this.conversation == ((KeyedConversation) other).getConversation());
    }
}