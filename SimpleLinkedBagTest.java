package game;

import student.TestCase;
import student.TestableRandom;

//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept
//the actions of those who do.
//-- Stephen Ye (stepheny)

/**
* Tests the methods in the SimpleLinkedBag class
* 
* 
* @author Stephen Ye (stepheny)
* @version 2022.10.04
* 
*/
public class SimpleLinkedBagTest extends TestCase {
    
    private SimpleLinkedBag<String> bag;
    private TestableRandom generator;

    /**
     * sets up the needed objects needed for tests
     */
    public void setUp() {
        bag = new SimpleLinkedBag<String>();
        generator = new TestableRandom();
    }

    /**
     * tests the add method
     */
    public void testAdd() {
        assertTrue(bag.add("A"));
        assertFalse(bag.add(null));
        
        bag.add("B");
        bag.add("B");
        assertTrue(bag.add("C"));

    }

    /**
     * tests the getCurrentSize method
     */
    public void testGetCurrentSize() {
        assertEquals(0, bag.getCurrentSize());
        bag.add("A");
        assertEquals(1, bag.getCurrentSize());
    }
    
    /**
     * tests the isEmpty method
     */
    public void testIsEmpty() {
        assertTrue(bag.isEmpty());
        bag.add("A");
        assertFalse(bag.isEmpty());
    }
    
    /**
     * test the pick method
     */
    @SuppressWarnings("static-access")
    public void testPick()
    {
        assertEquals(null, bag.pick());

        bag.add("A");
        generator.setNextInts(0);
        assertEquals("A", bag.pick());
        
        bag.add("B");
        generator.setNextInts(1);
        assertEquals("A", bag.pick());
    }
    
    /**
     * tests the remove method while also 
     * testing the getIndexOf method
     */
    public void testRemove() {
        assertFalse(bag.remove("A"));
        bag.add("A");
        assertTrue(bag.remove("A"));

        
        assertFalse(bag.remove(null));
        bag.add("A");
        assertFalse(bag.remove("B"));
    }
    
    

}
