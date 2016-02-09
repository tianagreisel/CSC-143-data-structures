package csc143.data_structures;

/**
 * This Stub class class implements the UnboundedQueue interface so that it can
 * be tested (in JUnit assignment later in the week).  The maximum capacity of
 * the Stack is equal to capacity.
 * 
 * @author Tiana Greisel
 * @version Learning Activity: Stack/Queue Documentation (Grade Level:  Check)
 *
 */
public class UnboundedQueueStub implements UnboundedQueue{
	
	/**
	 * Constructs an UnboundedQueue with unlimited capacity.
	 * 
	 */
	public UnboundedQueueStub(){
		
	}
	
	/**
	 * This method inserts an object to the back of the Queue, increasing the
	 * size by one.  
	 * 
	 * @param o Object to be added to the back of the Queue.
	 */
    public void insert(Object o){}
    
    /**
     * This method removes an Object from the front of the Queue thereby decreasing the
     * size by one.  Throws an EmptyQueueException if the Queue is empty and there is no
     * object to remove.
     * 
     * @return Object removed from the front of the Queue
     * @throws EmptyQueueException if Queue is empty and there is no object to remove
     */
    public Object remove() throws EmptyQueueException{
    	return null;
    }
    
    /**
     * This method makes a copy of the object/ element at the front of the Queue.  Size stays the same.
     * 
     * @return copy of the object or element at the front of the Queue.
     * @throws EmptyQueueException thrown if the Queue is empty and there is no object at the front
     */
    public Object front() throws EmptyQueueException{
    	return null;
    }
    
    /**
     * This method returns true if the Queue has a front object/ element and therefore is 
     * not empty.
     * 
     * @return true if the Queue has a front element
     */
    public boolean hasFront(){
    	return false;
    }
    
    /**
     * This method returns the number of elements currently stored in the structure (Stack).
     * 
     * 
     * @return int number of elements stored in the Stack
     */
    public int size(){
    	return 0;
    }

    /**
     * This method creates a String representation of the Stack.
     * 
     * @return String which represents the Stack
     */
    public String toString(){
    	return "";
    }
    
}



