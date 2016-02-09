package csc143.data_structures;

/**
 * This Stub class class implements the UnboundedStack interface so that it can
 * be tested (in JUnit assignment later in the week).  The maximum capacity of
 * the Stack is equal to capacity.
 * 
 * @author Tiana Greisel
 * @version Learning Activity: Stack/Queue Documentation (Grade Level:  Check)
 *
 */
public class UnboundedStackStub implements UnboundedStack{



	/**
	 * Constructs an UnboundedStack of unlimited capacity.
	 */
	public UnboundedStackStub(){

	}


	/**
	 * This method adds an Object o to the top of the Stack thereby increasing the size by one.  
	 * 
	 * @param o Object to be added to the top of the Stack.
	 */
	public void push(Object o){}

	/**
	 * This method removes an Object o from the top of the Stack decreasing the size by one.  Throws an
	 * EmptyStackException if the Stack is empty and there is nothing to remove.
	 * 
	 * @return Object removed from the top of the Stack.
	 * @throws EmptyStackException thrown when Stack is empty and no object can be removed.
	 */
	public Object pop() throws EmptyStackException{
		return null;
	}

	/**
	 * This method returns a copy of the object at the top of the Stack.  Size does not change. Throws an
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
	 * This method checks to see if a Stack has a top or not (object at the top) and therefore
	 * isn't empty.
	 * 
	 * @return True if the Stack has a top object and isn't empty.  
	 */
	public boolean hasTop(){
		return false;
	}

	/**
	 * This method returns the number of elements currently stored in the structure (Stack).
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