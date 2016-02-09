package csc143.data_structures;

/**
 * This class implements BoundedStack and therefore is a bounded stack data structure.
 * The class uses a Link List as the underlying structure for the stack.
 * 
 * @author Tiana Greisel
 * @version Homework Assignment 5: Stack/Queue Implementation
 *
 * @param <T> Generic type parameter
 */
public class BoundedLinkedListStack<T> implements BoundedStack<T>{

	//underlying LinkList that makes up BoundedStack
	private LinkList<T> BoundedStack;

	//maximum number of elements of BoundedStack
	private int capacity;


	/**
	 * Constructs a BoundedLinkedListStack with maximum capacity of int capacity where capacity
	 * is greater than or equal to zero.  Throws IllegalArgumentException if capacity is less
	 * than zero.  Uses a Link List as the underlying data structure.  Size set to zero in
	 * the constructor of Link List. 
	 * Time complexity:  O(k)
	 *   
	 * @param capacity maximum number of elements the stack can hold
	 * @throws IllegalArgumentException if capacity is less than zero (must be: 0 <= capacity)
	 */
	public BoundedLinkedListStack(int capacity){

		if(capacity < 0 ){

			throw new IllegalArgumentException("capacity cannot be less than 0");
		}

		//create new LinkList that makes up BoundedStack
		BoundedStack = new LinkList<T>();
		this.capacity = capacity;

	}
	/**
	 * This method adds a generic type parameter to the top of the Stack and increases size by one.  Throws a
	 * FullStackException if the Stack is full and no more elements can be
	 * added to the Stack.  Uses add method from LinkList.
	 * Time complexity: O(k)
	 * 
	 * @param o Generic type to be added to the top of the Stack.
	 * @throws FullStackException thrown when Stack is at capacity (full) and no more elements can be added.
	 */
	public void push(T o) throws FullStackException {

		if(size() >= capacity){  

			throw new FullStackException("Stack is Full");
		}

		//uses LinkList add method to add element to LinkList
		BoundedStack.add(o);

	}

	/**
	 * This method removes a generic type o from the top of the Stack and decreases size by one.  Throws an
	 * EmptyStackException if the Stack is empty and there is nothing to remove.  Uses removeLastLinkItem()
	 * method from LinkList.
	 * Time complexity: O(n) because helper method in LinkList is O(n) otherwise O(k).
	 * 
	 * @return Generic type removed from the top of the Stack.
	 * @throws EmptyStackException thrown when Stack is empty and no element can be removed.
	 */
	public T pop() throws EmptyStackException {

		if(size() == 0){

			throw new EmptyStackException("Stack is Empty");
		}

		//uses LinkList method to remove element from Last Link of LinkList
		return BoundedStack.removeLastLinkItem();
	}

	/**
	 * This method returns a copy of the element at the top of the Stack.  Size does not change.  Throws an
	 * EmptyStackException if the Stack is empty and there is no element to return a 
	 * copy of.  Uses getLinkItemAtPos() method from LinkList.
	 * Time complexity:  O(n) because helper class in LinkList is O(n) otherwise O(k).
	 * 
	 * @return Generic type T a copy of the element at the top of the Stack.
	 * @throws EmptyStackException thrown when Stack is empty and there is no element at the top.
	 */
	public T top() throws EmptyStackException {

		if(size() == 0){

			throw new EmptyStackException("Stack is Empty");

		}

		//uses LinkList method to get element in last Link of LinkList
		return BoundedStack.getLinkItemAtPos(size());
	}

	/**
	 * This method checks to see if a Stack has space (is not at capacity).  It returns true
	 * if the Stack has more space and is not at capacity.
	 * Time complexity: O(k)
	 * 
	 * @return true when the Stack has more space (is not at capacity)
	 */
	public boolean hasSpace() {

		return size() < capacity;  
	}

	/**
	 * This method checks to see if a Stack has a top or not (element at the top) and therefore
	 * isn't empty.
	 * Time complexity: O(k)
	 * 
	 * @return true if the Stack has a top object and isn't empty.  
	 */
	public boolean hasTop() {

		return size() != 0;
	}

	/**
	 * This method returns the number of elements currently stored in the structure (Stack).
	 * Uses LinkList method to return number of elements in LinkList
	 * Time complexity: O(k)
	 * 
	 * @return int number of elements stored in the Stack
	 */
	public int size() {

		//uses LinkList method to return number of elements in LinkList
		return BoundedStack.size();
	}

	/**
	 * This method creates a String representation of the Stack.
	 * Time complexity: O(n)
	 * 
	 * @return String which represents the Stack
	 */
	public String toString(){

		//number of elements in LinkList
		int size = size();

		String s = "[ " + size + " :";

		//if no elements in LinkList
		if(size == 0){
			s+= " ]";
		}

		//if elements in LinkList
		else{

			//iterate through elements in LinkList and add to string
			for(int i = 1; i < size; i++){

				T value = BoundedStack.getLinkItemAtPos(i);
				s += " " + value + ",";
			}
			//add last element to string
			T last = BoundedStack.getLinkItemAtPos(size);
			s+= " "+ last + " ]";

		}
		return s;
	}

	/**
	 * This method returns the maximum value of size for the Stack
	 * Time complexity:  O(k)
	 * 
	 * @return int maximum value of size for the Stack
	 */
	public int capacity() {

		return capacity;
	}
}
