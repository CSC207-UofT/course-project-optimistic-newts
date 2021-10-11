package entities;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;;

import java.util.Iterator;
import java.util.List;

public class ConversationQueueTest {
    ConversationQueue cq;

    /**
     * Set up a test ConversationQueue before each test.
     */
    @Before
    public void setUp() {
        cq = new ConversationQueue("Toronto", 10, new String[]{"Hockey", "Math"});
    }

    /**
     * Test location getter.
     */
    @Test
    public void getLocationTest() {
        Assert.assertEquals("Toronto", cq.getLocation());
    }

    /**
     * Test location radius getter.
     */
    @Test
    public void getLocationRadiusTest() {
        Assert.assertEquals(10, cq.getLocationRadius());
    }

    /**
     * Test interests array getter.
     */
    @Test
    public void getInterestsTest() {
        Assert.assertArrayEquals(new String[]{"Hockey", "Math"}, cq.getInterests());
    }

    /**
     * Test toKeyedConversation on a conversation with 0 interest matches and a conversation with 1 interest match.
     */
    @Test
    public void toKeyedConversationTest() {
        Conversation conversation0 = new Conversation();
        conversation0.setTopic("Hockey");
        Conversation conversation1 = new Conversation();
        conversation1.setTopic("Physics");
        KeyedConversation keyedConversation0 = cq.toKeyedConversation(conversation0);
        Assert.assertEquals(1, keyedConversation0.getKey());
        KeyedConversation keyedConversation1 = cq.toKeyedConversation(conversation1);
        Assert.assertEquals(0, keyedConversation1.getKey());
    }

    /**
     * Test that size returns the expected size of ConversationQueue.
     */
    @Test
    public void sizeTest() {
        Conversation conversation0 = new Conversation();
        conversation0.setTopic("Hockey");
        Conversation conversation1 = new Conversation();
        conversation1.setTopic("Physics");

        Assert.assertEquals(0, cq.size());

        cq.add(conversation0);
        Assert.assertEquals(1, cq.size());

        cq.add(conversation1);
        Assert.assertEquals(2, cq.size());
    }

    /**
     * Test isEmpty on empty and non-empty ConversationQueue.
     */
    @Test
    public void isEmptyTest() {
        Assert.assertTrue(cq.isEmpty());
        Conversation conversation0 = new Conversation();
        conversation0.setTopic("Hockey");
        cq.add(conversation0);
        Assert.assertFalse(cq.isEmpty());
    }

    /**
     * Test contains with element and non element.
     */
    @Test
    public void containsTest() {
        Conversation conversation0 = new Conversation();
        conversation0.setTopic("Hockey");
        cq.add(conversation0);
        Conversation conversation1 = new Conversation();

        Assert.assertTrue(cq.contains(conversation0));
        Assert.assertFalse(cq.contains(conversation1));
    }

    /**
     * Test iterator returns as expected.
     */
    @Test
    public void iteratorTest() {
        Conversation conversation0 = new Conversation();
        conversation0.setTopic("Hockey");
        cq.add(conversation0);
        Conversation conversation1 = new Conversation();
        conversation0.setTopic("Toronto");
        cq.add(conversation1);

        Iterator<Conversation> iter = cq.iterator();
        Assert.assertTrue(iter.hasNext());
        Assert.assertEquals(conversation0, iter.next());
        Assert.assertEquals(conversation1, iter.next());
    }

    /**
     * Test toArray returns as expected.
     */
    @Test
    public void toArrayTest() {
        Conversation conversation0 = new Conversation();
        conversation0.setTopic("Hockey");
        cq.add(conversation0);
        Conversation conversation1 = new Conversation();
        conversation0.setTopic("Toronto");
        cq.add(conversation1);

        Conversation[] expected = new Conversation[]{conversation0, conversation1};
        Assert.assertArrayEquals(expected, cq.toArray());
    }

    /**
     * Test toArray with input array smaller than required.
     */
    @Test
    public void toArrayTestTooSmall() {
        Conversation conversation0 = new Conversation();
        conversation0.setTopic("Hockey");
        cq.add(conversation0);
        Conversation conversation1 = new Conversation();
        conversation0.setTopic("Toronto");
        cq.add(conversation1);

        Conversation[] input = new Conversation[1];
        Conversation[] expected = new Conversation[]{conversation0, conversation1};

        Assert.assertArrayEquals(expected, cq.toArray(input));
    }

    /**
     * Test toArray with input array that is same size as ConversationQueue.
     */
    @Test
    public void toArrayTestSameSize() {
        Conversation conversation0 = new Conversation();
        conversation0.setTopic("Hockey");
        cq.add(conversation0);
        Conversation conversation1 = new Conversation();
        conversation0.setTopic("Toronto");
        cq.add(conversation1);

        Conversation[] input = new Conversation[2];
        Conversation[] expected = cq.toArray();

        Assert.assertArrayEquals(expected, cq.toArray(input));
    }

    /**
     * Test toArray with input array that is larger than ConversationQueue.
     */
    @Test
    public void toArrayTestLarger() {
        Conversation conversation0 = new Conversation();
        conversation0.setTopic("Hockey");
        cq.add(conversation0);
        Conversation conversation1 = new Conversation();
        conversation0.setTopic("Toronto");
        cq.add(conversation1);

        Conversation[] input = new Conversation[3];
        Conversation[] expected = new Conversation[]{conversation0, conversation1, null};

        Assert.assertArrayEquals(expected, cq.toArray(input));
    }

    /**
     * Test remove on a root node.
     */
    @Test
    public void removeTestFirst() {
        Conversation conversation0 = new Conversation();
        conversation0.setTopic("Hockey");
        cq.add(conversation0);
        Conversation conversation1 = new Conversation();
        conversation1.setTopic("Math");
        cq.add(conversation1);
        Conversation conversation2 = new Conversation();
        conversation2.setTopic("Toronto");
        cq.add(conversation2);

        Assert.assertTrue(cq.remove(conversation0));
        Conversation[] expected = new Conversation[]{conversation1, conversation2};
        Assert.assertArrayEquals(expected, cq.toArray());
    }

    /**
     * Test remove on last node.
     */
    @Test
    public void removeTestLast() {
        Conversation conversation0 = new Conversation();
        conversation0.setTopic("Hockey");
        cq.add(conversation0);
        Conversation conversation1 = new Conversation();
        conversation1.setTopic("Math");
        cq.add(conversation1);
        Conversation conversation2 = new Conversation();
        conversation2.setTopic("Toronto");
        cq.add(conversation2);

        Assert.assertTrue(cq.remove(conversation2));
        Conversation[] expected = new Conversation[]{conversation0, conversation1};
        Assert.assertArrayEquals(expected, cq.toArray());
    }

    /**
     * Test remove on middle node - one with parent and children.
     */
    @Test
    public void removeTestMiddle() {
        Conversation conversation0 = new Conversation();
        conversation0.setTopic("Hockey");
        cq.add(conversation0);
        Conversation conversation1 = new Conversation();
        conversation1.setTopic("Math");
        cq.add(conversation1);
        Conversation conversation2 = new Conversation();
        conversation2.setTopic("Toronto");
        cq.add(conversation2);
        Conversation conversation3 = new Conversation();
        conversation3.setTopic("Golf");
        cq.add(conversation3);
        Conversation conversation4 = new Conversation();
        conversation4.setTopic("Hockey");
        cq.add(conversation4);

        Assert.assertTrue(cq.remove(conversation1));
        Conversation[] expected = new Conversation[]{conversation0, conversation4, conversation2, conversation3};
        Assert.assertArrayEquals(expected, cq.toArray());
    }

    /**
     * Test contains all returns false.
     */
    @Test
    public void containsAllTestFalse() {
        Conversation conversation0 = new Conversation();
        conversation0.setTopic("Hockey");
        cq.add(conversation0);
        Conversation conversation1 = new Conversation();
        conversation1.setTopic("Math");
        cq.add(conversation1);
        Conversation conversation2 = new Conversation();
        conversation2.setTopic("Toronto");
        cq.add(conversation2);
        Conversation conversation3 = new Conversation();
        conversation2.setTopic("Fish");

        Conversation[] compare = new Conversation[]{conversation0, conversation1, conversation2, conversation3};
        Assert.assertFalse(cq.containsAll(List.of(compare)));
    }

    /**
     * Test contains all returns true.
     */
    @Test
    public void containsAllTestTrue() {
        Conversation conversation0 = new Conversation();
        conversation0.setTopic("Hockey");
        cq.add(conversation0);
        Conversation conversation1 = new Conversation();
        conversation1.setTopic("Math");
        cq.add(conversation1);
        Conversation conversation2 = new Conversation();
        conversation2.setTopic("Toronto");
        cq.add(conversation2);

        Conversation[] compare = new Conversation[]{conversation0, conversation1, conversation2};
        Assert.assertTrue(cq.containsAll(List.of(compare)));
    }


}