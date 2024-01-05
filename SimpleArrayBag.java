package game;
import bag.SimpleBagInterface;
import student.TestableRandom;

//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept 
//the actions of those who do.
//-- Stephen Ye (stepheny)

/**
 * Creates and sets the rules with methods for 
 * SimpleArrayBag objects
 * 
 * 
 * 
 * @author Stephen Ye (stepheny)
 * @version 2022.10.04
 * @param <T> the object that is used in this class
 */
public class SimpleArrayBag<T> implements SimpleBagInterface<T> {
    
    private T[] bag;
    private static final int MAX = 18;
    private int numberOfEntries;
    
    /**
     * instantiates the SimpleArrayBag fields
     */
    public SimpleArrayBag()
    {
        @SuppressWarnings("unchecked")
        T[] tempbag = (T[]) new Object[18];
        bag = tempbag;
        numberOfEntries = 0;
    }

    /**
     * Adds a new entry to this bag.
     * @param obj the object being added
     * @return boolean whether or not the element was added
     */
    @Override
    public boolean add(T obj) {

        if (obj == null) {
            return false;
        }
        if ( numberOfEntries < MAX) {
            bag[numberOfEntries] = obj;
            numberOfEntries++;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Removes one unspecified entry from this bag, if possible.
     * @return int the current size
     */
    @Override
    public int getCurrentSize() {

        return numberOfEntries;
    }


    /**
     * Sees whether this bag is empty.
     * @return boolean whether or not the bag is empty
     */
    @Override
    public boolean isEmpty() {

        return numberOfEntries == 0;
    }



    /**
    * Removes one occurrence of a given entry from this bag.
    * @param obj the object being removed
    * @return boolean whether or not the element was removed
    */
    @Override
    public boolean remove(T obj) {

        int index = getIndexOf(obj);
        if (index == -1) {
            return false;
        }
        bag[index] = bag[numberOfEntries - 1];
        bag[numberOfEntries - 1] = null;
        numberOfEntries--;
        return true;
    }


    /**
     * Randomly selects an object
     * @return T the random object that was selected
     * 
     */
    public T pick()
    {
        
        if ( isEmpty()) {
            return null;
        }
        else {
            TestableRandom generator = new TestableRandom(); 
            int index = generator.nextInt(numberOfEntries);
            return bag[index];
        }

    }

    /**
    * Finds the index that a certain "T" object occurred.
    * @param obj the object you are searching for in the bag
    * @return int the index that the object was found
    */
    private int getIndexOf(T obj)
    {
        int index = -1;
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(obj)) {
                index = i;
            }
        }
        return index;
        
    }
}

   
