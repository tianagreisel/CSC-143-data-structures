package csc143.data_structures;

/**
 * This class implements UnboundedStack and therefore is an unbounded stack data structure.
 * The class uses a Link List as the underlying structure for the stack.
 * 
 * @author Tiana Greisel
 * @version Homework Assignment 5: Stack/Queue Implementation
 *
 * @param <T> Generic type parameter
 */
public class UnboundedLinkedListStack<T> implements UnboundedStack<T> {

	//underlying LinkList making up UnboundedStack
	private LinkList<T> UnboundedStack;


	/**
	 * Constructs an UnboundedLinkedListStack.  Uses a Link List as the underlying data structure.  
	 * Size set to zero in the constructor of Link List. Uses a Generic type paramerter Link List.
	 * Time complexity:  O(k)
	 *   
	 */
	public UnboundedLinkedListStack(){

		//create new LinkList for UnboundedStack
		UnboundedStack = new LinkList<T>();

	}

	/**
	 * This method adds a generic type element o to the top of the Stack thereby increasing the size by one. 
	 * Uses add() method from LinkList. 
	 * Time complexity:  O(k)
	 * 
	 * 
	 * @param o Generic type element to be added to the top of the Stack.
	 */
	public void push(T o) {

		//use LinkList method to add element 
		UnboundedStack.add(o);

	}

	/**
	 * This method removes a generic type element o from the top of the Stack decreasing the size by one.  Throws an
	 * EmptyStackException if the Stack is empty and there is nothing to remove.  Uses removeLastLinkItem() method
	 * from LinkList.
	 * Time complexity: O(n) because helper method in LinkList is O(n) otherwise O(k).
	 * 
	 * @return Generic type T removed from the top of the Stack.
	 * @throws EmptyStackException thrown when Stack is empty and no element can be removed.
	 */
	public T pop() throws EmptyStackException {

		if(size() == 0){  

			throw new EmptyStackException("Stack is Empty");
		}	
		//use LinkList method to remove element from stack
		return UnboundedStack.removeLastLinkItem();
	}

	/**
	 * This method returns a copy of the element at the top of the Stack.  Size does not change. Throws an
	 * EmptyStackException if the Stack is empty and there is no element to return a 
	 * copy of.  Uses getLinkItemAtPos() method from LinkList.
	 * Time complexity: O(n) because helper method in LinkList is O(n) otherwise O(k).
	 * 
	 * @return Generic type T a copy of the element at the top of the Stack.
	 * @throws EmptyStackException thrown when Stack is empty and there is no element at the top.
	 */
	public T top() throws EmptyStackException {

		if(size() == 0){

			throw new EmptyStackException("Stack is Empty");
		}

		//uses LinkList method to get top element
		return UnboundedStack.getLinkItemAtPos(size());
	}

	/**
	 * This method checks to see if a Stack has a top or not (element at the top) and therefore
	 * isn't empty.
	 * Time complexity:  O(k)
	 * 
	 * @return true if the Stack has a top element and isn't empty.  
	 */
	public boolean hasTop() {

		return size() != 0;  
	}

	/**
	 * This method creates a String representation of the Stack.
	 * Time complexity:  O(n)
	 * 
	 * @return String which represents the Stack
	 */
	public String toString(){

		//number of elements in stack
		int size = size();

		String s = "[ " + size + " :";

		//if no elements in stack
		if(size == 0){
			s+= " ]";
		}
		//if elements in stack
		else{

			//iterate through elements and add to string
			for(int i = 1; i < size; i++){

				T value = UnboundedStack.getLinkItemAtPos(i);
				s += " " + value + ",";
			}

			//add last element in stack to string
			T last = UnboundedStack.getLinkItemAtPos(size);

			s+= " "+ last + " ]";

		}
		return s;
	}
	/**
	 * This method returns the number of elements currently stored in the structure (Stack).
	 * Uses size() method in LinkList
	 * Time complexity:  O(k)
	 * 
	 * @return int number of elements stored in the Stack
	 */
	public int size() {

		//use LinkList method to return number of Links in stack
		return UnboundedStack.size();
	}
}
