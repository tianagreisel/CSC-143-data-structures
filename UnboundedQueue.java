package csc143.data_structures;

/**
 * This interface must be implemented to be considered a UnboundedQueue.
 * 
 * @author Tiana Greisel
 * @version Learning Activity: Stack/Queue Documentation (Grade Level:  Check)
 *
 */
public interface UnboundedQueue<T> {
    
	/**
	 * This method inserts a generic type element to the back of the Queue, increasing the
	 * size by one.  
	 * 
	 * @param o Generic type to be added to the back of the Queue.
	 */
    public void insert(T o);
    
    /**
     * This method removes a generic type element from the front of the Queue thereby decreasing the
     * size by one.  Throws an EmptyQueueException if the Queue is empty and there is no
     * element to remove.
     * 
     * @return Object removed from the front of the Queue
     * @throws EmptyQueueException if Queue is empty and there is no object to remove
     */
    public T remove() throws EmptyQueueException;
    
    /**
     * This method makes a copy of the element at the front of the Queue.  Size stays the same.
     * 
     * @return copy of the element at the front of the Queue.
     * @throws EmptyQueueException thrown if the Queue is empty and there is no elment at the front
     */
    public T front() throws EmptyQueueException;
    
    /**
     * This method returns true if the Queue has a front element and therefore is 
     * not empty.
     * 
     * @return true if the Queue has a front element
     */
    public boolean hasFront();
    
    /**
     * This method returns the number of elements currently stored in the structure (Queue).
     * 
     * 
     * @return int number of elements stored in the Queue
     */
    public int size();

    /**
     * This method creates a String representation of the Queue.
     * 
     * @return String which represents the Queue
     */
    public String toString();
    
}
