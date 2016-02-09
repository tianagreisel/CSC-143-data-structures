package csc143.data_structures;


/**
 * This Stub class class implements the BoundedQueue interface so that it can
 * be tested (in JUnit assignment later in the week).  The maximum capacity of
 * the Queue is equal to capacity.
 * 
 * @author Tiana Greisel
 * @version Learning Activity: Stack/Queue Documentation (Grade Level:  Check)
 *
 */
public class BoundedQueueStub implements BoundedQueue {
	
	//maximum storage capacity of Queue
	private int capacity;
	
	
	/**
	 * Constructs a BoundedQueue with maximum size of storage equal to int capacity.
	 * 
	 * @param capacity maximum storage capacity
	 */
	public BoundedQueueStub(int capacity){
		
		this.capacity = capacity;
		
		
	}

	/**
	 * This method inserts an object to the back of the Queue, increasing the
	 * size by one.  Throws a FullQueueException if the Queue is at capacity and
	 * cannot insert another object.
	 * 
	 * @param o Object to be added to the back of the Queue.
	 * @throws FullQueueException if the Queue is at maximum capacity
	 */
   public void insert(Object o) throws FullQueueException{
	   
   }
    
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
     * This method returns true if the Queue has space for more elements and therefore 
     * is not full (at capacity).
     * 
     *  @return true if the Queue has more space and is not at capacity (size != capacity).
     */
    public boolean hasSpace(){
    	
    	return false;
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
     * This method returns the number of elements currently stored in the structure (Queue).
     * 
     * 
     * @return int number of elements stored in the Queue
     */
    public int size(){
    	return 0;
    }

    /**
     * This method creates a String representation of the Queue.
     * 
     * @return String which represents the Queue
     */
    public String toString(){
    	return "";
    	
    }

    /**
     * This method returns the maximum value of size for the Queue
     * 
     * @return int maximum value of size for the Queue
     */
    public int capacity(){
    	
    	return 0;
    }
	
}
