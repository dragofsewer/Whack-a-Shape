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
* Tests the methods in the SimpleArrayBag class
* 
* 
* 
* @author Stephen Ye (stepheny)
* @version 2022.10.04
* 
*/
public class SimpleArrayBagTest extends TestCase {

    
    private SimpleArrayBag bag;
    
    /**
     * sets up the objects needed for the tests
     */
    public void setUp()
    {
        TestableRandom.setNextInts(0);
        bag = new SimpleArrayBag();
    }

    /**
     * tests the add method
     */
    @SuppressWarnings("unchecked")
    public void testAdd()
    {
        
        bag.add("A");
        assertTrue(bag.add("A"));

        
        assertFalse(bag.add(null));
        
        for (int i = 0; i < 19; i++)
        {
            bag.add( "B");
        
        }
        bag.add("C");
        assertFalse(bag.add("C"));
        
        
        
    }
    /**
     * test the getCurrentSize method
     */
    @SuppressWarnings("unchecked")
    public void testGetCurrentSize()
    {
        assertEquals(0, bag.getCurrentSize());
        bag.add("A");
        assertEquals(1, bag.getCurrentSize());
    }
    
    /**
     * tests the isEmpty method
     */
    @SuppressWarnings("unchecked")
    public void testIsEmpty()
    {
        assertTrue(bag.isEmpty());
        bag.add("A");
        assertFalse(bag.isEmpty());
    }
    
    /**
     * test the remove method and also the 
     * getReferanceTo method
     */
    @SuppressWarnings("unchecked")
    public void testRemove()
    {
        bag.add("A");
        assertTrue(bag.remove( "A"));

        assertFalse(bag.remove("A"));

        String bad = null;
        assertFalse(bag.remove(bad));
        
        bag.add("A");
        assertFalse(bag.remove( "B"));
    }
    
    /**
     * test the pick method
     */
    @SuppressWarnings("unchecked")
    public void testPick()
    {
        assertEquals(bag.pick(), null);
        bag.add("A");
        TestableRandom.setNextInts(0);
        assertEquals(bag.pick(), "A");
        
    }
    
    
    
    

    
    
    

}
