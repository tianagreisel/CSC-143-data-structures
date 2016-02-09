package csc143.data_structures;

/**
 * This Stub class class implements the BoundedStack interface so that it can
 * be tested (in JUnit assignment later in the week).  The maximum capacity of
 * the Stack is equal to capacity.
 * 
 * @author Tiana Greisel
 * @version Learning Activity: Stack/Queue Documentation (Grade Level:  Check)
 *
 */
public class BoundedStackStub implements BoundedStack {
	
	//maximum storage capacity of the Stack
	int capacity;
	
	
	/**
	 * Constructs a BoundedStack with maximum size of storage equal to int capacity.
	 * 
	 * @param capacity maximum size of BoundedStack
	 */
	public BoundedStackStub(int capacity){
		
		this.capacity =  capacity;
	}
	
	
	/**
	 * This method adds an Object o to the top of the Stack.  Throws a
	 * FullStackException if the Stack is full and no more objects can be
	 * added to the Stack.
	 * 
	 * @param o Object to be added to the top of the Stack.
	 * @throws FullStackException thrown when Stack is at capacity (full) and no more objects can be added.
	 */
    public void push(Object o) throws FullStackException{
    	
    	
    }
    
    
    /**
     * This method removes an Object o from the top of the Stack.  Throws an
     * EmptyStackException if the Stack is empty and there is nothing to remove.
     * 
     * @return Object removed from the top of the Stack.
     * @throws EmptyStackException thrown when Stack is empty and no object can be removed.
     */
    public Object pop() throws EmptyStackException{
    	return null;
    }
    
    /**
     * This method returns a copy of the object at the top of the Stack.  Throws an
     * EmptyStackException if the Stack is empty and there is no object to return a 
     * copy of.
     * 
     * @return Object a copy of the object at the top of the Stack.
     * @throws EmptyStackException thrown when Stack is empty and there is no object at the top.
     */
    public Object top() throws EmptyStackException{
    	return null;
    }
    
    /**
     * This method checks to see if a Stack has space (is not at capacity).  It returns true
     * if the Stack has more space and is not at capacity.
     * 
     * @return true when the Stack has more space (is not at capacity)
     */
    public boolean hasSpace(){
    	return false;
    }
    
    
    /**
     * This method checks to see if a Stack has a top or not (object at the top) and therefore
     * isn't empty.
     * 
     * @return true if the Stack has a top object and isn't empty.  
     */
    public boolean hasTop(){
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

    /**
     * This method returns the maximum value of size for the Stack
     * 
     * @return int maximum value of size for the Stack
     */
    public int capacity(){
    	return 0;
    }
    
}
	
	
	


