package csc143.data_structures;

/**
 * This interface must be implemented to be considered a BoundedQueue.
 * 
 * @author Tiana Greisel
 * @version Learning Activity: Stack/Queue Documentation (Grade Level:  Check)
 *
 */
public interface BoundedQueue<T> {
    
	/**
	 * This method inserts a generic type parameter to the back of the Queue, increasing the
	 * size by one.  Throws a FullQueueException if the Queue is at capacity and
	 * cannot insert another element.
	 * 
	 * @param o generic type parameter to be added to the back of the Queue.
	 * @throws FullQueueException if the Queue is at maximum capacity
	 */
    public void insert(T o) throws FullQueueException;
    
    /**
     * This method removes a generic type from the front of the Queue thereby decreasing the
     * size by one.  Throws an EmptyQueueException if the Queue is empty and there is no
     * element to remove.
     * 
     * @return Generic type removed from the front of the Queue
     * @throws EmptyQueueException if Queue is empty and there is no element to remove
     */
    public T remove() throws EmptyQueueException;
    
    
    /**
     * This method makes a copy of the (generic type) element at the front of the Queue.  Size stays the same.
     * 
     * @return copy of the (generic type) element at the front of the Queue.
     * @throws EmptyQueueException thrown if the Queue is empty and there is no object at the front
     */
    public T front() throws EmptyQueueException;
    
    /**
     * This method returns true if the Queue has space for more elements and therefore 
     * is not full (at capacity).
     * 
     *  @return true if the Queue has more space and is not at capacity (size != capacity).
     */
    public boolean hasSpace();
    
    /**
     * This method returns true if the Queue has a front object/ element and therefore is 
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


    /**
     * This method returns the maximum value of size for the Queue
     * 
     * @return int maximum value of size for the Queue
     */
    public int capacity();
    
}