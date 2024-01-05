package game;
import bag.SimpleBagInterface;
import bag.Node;
import student.TestableRandom;

//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
//-- Stephen Ye (stepheny)

/**
*
* A class of bags whose entries are stored in a chain of linked nodes.
* 
* 
* @author Stephen Ye (stepheny)
* @version 2022.10.04
* @param <T> the object that is used in this class
*/
public class SimpleLinkedBag<T> implements SimpleBagInterface<T> {
    
    private Node<T> firstNode;
    private int numberOfEntries;


    /**
     * Creates an empty bag.
     */
    public SimpleLinkedBag()
    {
        firstNode = null;
        numberOfEntries = 0;
    }

    /**
     * Adds a new entry to this bag.
     * @param obj the object being added if possible
     * @return boolean whether it not the object was added
     */
    @Override
    public boolean add(T obj) {
        // TODO Auto-generated method stub
        Node<T> newNode = new Node<T>(obj);
        if (obj == null) {
            return false;
        }
        else
        {
            newNode.setNext(firstNode);
            firstNode = newNode;
            numberOfEntries++;
            return true;
        }
        
    }


    /**
     * Finds the size of the bag.
     * @return int the current size of the bag
     */
    @Override
    public int getCurrentSize() {
        // TODO Auto-generated method stub
        return numberOfEntries;
    }



    /**
     * Sees whether this bag is empty.
     * @return boolean true if the bag is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return numberOfEntries == 0;
    }

    /**
     * Picks a random object and returns it
     * @return T the object that was generated
     */
    public T pick()
    {
       
        if ( isEmpty()) {
            return null;
        }
        else {
            TestableRandom generator = new TestableRandom(); 
            int index = generator.nextInt(numberOfEntries);
            Node<T> currentNode = firstNode;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNext();
            }
            return currentNode.getData();
        }

    }



    /**
     * Removes one unspecified entry from this bag, if possible.
     * @param obj the object that you want to remove
     * @return boolean whether or not the bag was empty
     */
    @Override
    public boolean remove(T obj) {
        // TODO Auto-generated method stub
        
        if (obj == null) {
            return false;
        }
        else if (this.isEmpty())
        {
            return false;
        }
        Node<T> nowNode = getReferenceTo(obj);
        if (nowNode ==  null)
        {
            return false;
        }
        nowNode.setData(firstNode.getData());
        firstNode = firstNode.getNext();
        numberOfEntries--;
        return true; 
        
    }


    /**
     * Finds the node where a certain object is located
     * @param obj the object that you are searching for
     * @return Node<T> the node where that object was found
     */
    private Node<T> getReferenceTo(T obj) {

        boolean found = false;
        Node<T> currentNode = firstNode;
        while (!found && (currentNode != null)) {
            if (obj.equals(currentNode.getData())) {
                found = true;
            } 
            else {
                currentNode = currentNode.getNext();
            }
        }
        return currentNode;

    }


}
