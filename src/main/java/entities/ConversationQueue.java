package entities;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.*;

/**
 * A Conversation Queue. A Max Priority Queue used to filter conversations by relevance to present to a user.
 */
public class ConversationQueue implements Queue<KeyedConversation> {
    private ArrayList<KeyedConversation> conversations;
    private int size;

    /**
     * Initialize a new, empty ConversationQueue.
     */
    public ConversationQueue() {
        conversations = new ArrayList<>();
        conversations.add(null); // item at index 0 will never be used, due to Array representation of binary heap.
        size = 0;
    }

    /**
     * @return  Size of this ConversationQueue
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @return  true iff this ConversationQueue is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param o Object to search for
     * @return  true iff o is in this ConversationQueue
     */
    @Override
    public boolean contains(Object o) {
        return conversations.contains(o);
    }

    /**
     * Returns an iterator over the elements in this ConversationQueue- in non-increasing order.
     * @return  Iterator over the elements in this ConversationQueue
     */
    @Override
    public Iterator<KeyedConversation> iterator() {
        KeyedConversation[] array = (KeyedConversation[]) toArray();
        return Arrays.stream(array).iterator();
    }

    /**
     * Returns an array containing the elements in this ConversationQueue- in non-increasing order.
     * @return  sorted array
     */
    @Override
    public Object[] toArray() {
        ArrayList<KeyedConversation> temp = (ArrayList<KeyedConversation>) conversations.clone();
        int tempSize = size;
        ArrayList<KeyedConversation> toReturn = new ArrayList<>();
        while (!this.isEmpty()) {
            toReturn.add(poll());
        }
        conversations = temp;
        size = tempSize;
        return toReturn.toArray();
    }

    /**
     * Returns an array containing the elements in this ConversationQueue- in non-increasing order. If contents
     * of this ConversationQueue will fit in provided array, then return the provided array with these elements inserted
     * followed by null.
     * @return  sorted array
     */
    @Override
    public <T> T[] toArray(T[] a) {
        if (!(a instanceof KeyedConversation[])) {
            return a;
        }
        if (a.length == size) {
            ArrayList<KeyedConversation> temp = (ArrayList<KeyedConversation>) conversations.clone();
            int tempSize = size;
            int i = 0;
            while (!this.isEmpty()) {
                a[i] = (T) poll();
                i ++;
            }
            conversations = temp;
            size = tempSize;
            return a;
        } else if (a.length > size) {
            ArrayList<KeyedConversation> temp = (ArrayList<KeyedConversation>) conversations.clone();
            int tempSize = size;
            int i = 0;
            while (!this.isEmpty()) {
                a[i] = (T) poll();
                i ++;
            }
            a[i] = null;
            conversations = temp;
            size = tempSize;
            return a;
        } else {
            return (T[]) toArray();
        }
    }

    /**
     * Removes given object from this ConversationQueue, provided object is in ConversationQueue.
     * @param o object to remove from ConversationQueue
     * @return true iff object was successfully removed
     */
    @Override
    public boolean remove(Object o) {
        if (o == null) {
            return false;
        }
        int i = conversations.indexOf(o);
        if (i == -1) {
            return false;
        }
        conversations.set(i, conversations.get(size));
        size -= 1;
        heapify(i);
        return true;
    }

    /**
     *
     * @param c Collection to check whether this ConversationQueue contains
     * @return  true iff this contains all items in c
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object object : c) {
            if (!contains(object)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param c Collection of objects to add to this ConversationQueue
     * @return true iff this ConversationQueue was modified during this call
     */
    @Override
    public boolean addAll(Collection<? extends KeyedConversation> c) {
        boolean toReturn = false;
        for (KeyedConversation object : c) {
            add(object);
            toReturn = true;
        }
        return toReturn;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean toReturn = false;
        for (Object object : c) {
            if (remove(object)) {
                toReturn = true;
            }
        }
        return toReturn;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        conversations = new ArrayList<>();
        conversations.add(null); // item at index 0 will never be used, due to Array representation of binary heap.
        size = 0;
    }

    @Override
    public boolean add(KeyedConversation toAdd) {
        insert(toAdd);
        return true;
    }

    @Override
    public boolean offer(KeyedConversation toAdd) {
        insert(toAdd);
        return true;
    }

    @Override
    public KeyedConversation remove() {
        KeyedConversation max = conversations.get(1);
        conversations.set(1, conversations.get(size));
        size -= 1;
        heapify(1);
        return max;
    }

    @Override
    public KeyedConversation poll() {
        if (this.isEmpty()) {
            return null;
        }
        KeyedConversation max = conversations.get(1);
        conversations.set(1, conversations.get(size));
        size -= 1;
        heapify(1);
        return max;
    }

    @Override
    public KeyedConversation element() {
        return conversations.get(1);
    }

    @Override
    public KeyedConversation peek() {
        if (this.isEmpty()) {
            return null;
        }
        return conversations.get(1);
    }

    /**
     * Inserts the given element into a valid location in the ConversationQueue.
     * @param toInsert  KeyedConversation to insert
     */
    private void insert(KeyedConversation toInsert) {
        size += 1;
        int i = size;
        conversations.set(i, toInsert);

        while (i > 1 && conversations.get(parent(i)).getKey() < conversations.get(i).getKey()) {
            KeyedConversation temp = conversations.get(parent(i));
            conversations.set(parent(i), conversations.get(i));
            conversations.set(i, temp);
            i = parent(i);
        }
    }

    /**
     * Modifies the node order of the tree rooted at node with index i such that the tree is a valid max-heap.
     *
     * Precondition: trees rooted at left(i) and right(i) are valid max-heaps.
     *
     * @param i Index of root of tree to heapify in conversations ArrayList.
     */
    private void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int largest;

        if (l <= size && conversations.get(l).getKey() > conversations.get(i).getKey()) {
            largest = l;
        } else {
            largest = i;
        }

        if (r <= size && conversations.get(r).getKey() > conversations.get(largest).getKey()) {
            largest = r;
        }

        if (largest != i) {
            KeyedConversation temp = conversations.get(largest);
            conversations.set(largest, conversations.get(i));
            conversations.set(i, temp);
            heapify(largest);
        }

    }

    /**
     * Returns the index of the node at index i's left child.
     * @param i     index of this node
     * @return      index of left child
     */
    private static int left(int i) {
        return 2 * i;
    }

    /**
     * Returns the index of the node at index i's right child.
     * @param i     index of this node
     * @return      index of right child
     */
    private static int right(int i) {
        return (2 * i) + 1;
    }

    /**
     * Returns the index of the node at index i's parent node.
     * @param i     index of this node
     * @return      index of parent
     */
    private static int parent(int i) {
        return i / 2;
    }
}
