package csc143.data_structures;

/**
 * This interface must be implemented to be considered a BoundedStack.
 * 
 * 
  @author Tiana Greisel
 * @version Learning Activity: Stack/Queue Documentation (Grade Level:  Check)
 *
 */
public interface BoundedStack<T> {
    
	/**
	 * This method adds a generic type parameter to the top of the Stack and increases size by one.  Throws a
	 * FullStackException if the Stack is full and no more elements can be
	 * added to the Stack.
	 * 
	 * @param o Generic type to be added to the top of the Stack.
	 * @throws FullStackException thrown when Stack is at capacity (full) and no more elements can be added.
	 */
    public void push(T o) throws FullStackException;
    
    
    /**
     * This method removes a generic type o from the top of the Stack and decreases size by one.  Throws an
     * EmptyStackException if the Stack is empty and there is nothing to remove.
     * 
     * @return Generic type removed from the top of the Stack.
     * @throws EmptyStackException thrown when Stack is empty and no element can be removed.
     */
    public T pop() throws EmptyStackException;
    
    /**
     * This method returns a copy of the element at the top of the Stack.  Size does not change.  Throws an
     * EmptyStackException if the Stack is empty and there is no element to return a 
     * copy of.
     * 
     * @return Generic type T a copy of the element at the top of the Stack.
     * @throws EmptyStackException thrown when Stack is empty and there is no element at the top.
     */
    public T top() throws EmptyStackException;
    
    /**
     * This method checks to see if a Stack has space (is not at capacity).  It returns true
     * if the Stack has more space and is not at capacity.
     * 
     * @return true when the Stack has more space (is not at capacity)
     */
    public boolean hasSpace();
    
    
    /**
     * This method checks to see if a Stack has a top or not (element at the top) and therefore
     * isn't empty.
     * 
     * @return true if the Stack has a top object and isn't empty.  
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

    /**
     * This method returns the maximum value of size for the Stack
     * 
     * @return int maximum value of size for the Stack
     */
    public int capacity();
    
}