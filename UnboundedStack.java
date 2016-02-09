package csc143.data_structures;


/**
 * This interface must be implemented to be considered a UnboundedStack.
 * 
 * @author Tiana Greisel
 * @version Learning Activity: Stack/Queue Documentation (Grade Level:  Check)
 *
 */
public interface UnboundedStack<T> {
    
	/**
	 * This method adds a generic type element o to the top of the Stack thereby increasing the size by one.  
	 * 
	 * @param o Generic type element to be added to the top of the Stack.
	 */
    public void push(T o);
    
    /**
     * This method removes a generic type element o from the top of the Stack decreasing the size by one.  Throws an
     * EmptyStackException if the Stack is empty and there is nothing to remove.
     * 
     * @return Generic type T removed from the top of the Stack.
     * @throws EmptyStackException thrown when Stack is empty and no element can be removed.
     */
    public T pop() throws EmptyStackException;
    
    /**
     * This method returns a copy of the element at the top of the Stack.  Size does not change. Throws an
     * EmptyStackException if the Stack is empty and there is no element to return a 
     * copy of.
     * 
     * @return Generic type T a copy of the element at the top of the Stack.
     * @throws EmptyStackException thrown when Stack is empty and there is no element at the top.
     */
    public T top() throws EmptyStackException;
    
    /**
     * This method checks to see if a Stack has a top or not (element at the top) and therefore
     * isn't empty.
     * 
     * @return true if the Stack has a top element and isn't empty.  
     */
    public boolean hasTop();
    
    /**
     * This method returns the number of elements currently stored in the structure (Stack).
     * 
     * @return int number of elements stored in the Stack
     */
    public int size();

    /**
     * This method creates a String representation of the Stack.
     * 
     * @return String which represents the Stack
     */
    public String toString();
    
}