package csc143.data_structures;

/**
 * This class implements BoundedStack and therefore is a bounded stack data structure.
 * The class uses an array as the underlying structure for the stack.
 * 
 * @author Tiana Greisel
 * @version Homework Assignment 5: Stack/Queue Implementation
 *
 * @param <T> Generic type parameter
 */
public class BoundedArrayStack<T> implements BoundedStack<T>{

	//array making up BoundedArrayStack
	private T ArrayStack [];

	//maximum number of elements of BoundedStack 
	private int capacity;

	//number of elements in BoundedStack
	private int size;

	/**
	 * Constructs a BoundedArrayStack with maximum capacity of int capacity where capacity
	 * is greater than or equal to zero.  Throws IllegalArgumentException if capacity is less
	 * than zero.  Uses an array as the underlying data structure and sets the size of the 
	 * initial array to zero.  Uses a generic type array.
	 * Time complexity: O(k)
	 *   
	 * @param capacity maximum number of elements the stack can hold
	 * @throws IllegalArgumentException if capacity is less than zero (must be: 0 <= capacity)
	 */
	@SuppressWarnings("unchecked")
	public BoundedArrayStack(int capacity){

		if(capacity < 0 ){

			throw new IllegalArgumentException("capacity cannot be less than 0");
		}

		//create new array with capacity of capacity
		ArrayStack = (T[]) new Object [capacity];
		this.capacity = capacity;
		this.size = 0;
	}

	/**
	 * This method adds a generic type parameter to the top of the Stack and increases size by one.  Throws a
	 * FullStackException if the Stack is full and no more elements can be
	 * added to the Stack.
	 * Time complexity: O(k)
	 * 
	 * @param o Generic type to be added to the top of the Stack.
	 * @throws FullStackException thrown when Stack is at capacity (full) and no more elements can be added.
	 */
	public void push(T o) throws FullStackException {

		if(size >= capacity){

			throw new FullStackException("Stack is Full");
		}

		//add element at open position size
		ArrayStack[size] = o;

		//increase size by one
		size++;
	}

	/**
	 * This method removes a generic type o from the top of the Stack and decreases size by one.  Throws an
	 * EmptyStackException if the Stack is empty and there is nothing to remove.
	 * Time complexity: O(k)
	 * 
	 * @return Generic type removed from the top of the Stack.
	 * @throws EmptyStackException thrown when Stack is empty and no element can be removed.
	 */
	public T pop() throws EmptyStackException {

		if(size == 0){

			throw new EmptyStackException("Stack is Empty");

		}

		//get top element in stack
		T topObject = ArrayStack[size - 1];

		//set top element to null
		ArrayStack[size - 1] = null;  

		//decrement size
		size--;

		//return top element
		return topObject;     
	}

	/**
	 * This method returns a copy of the element at the top of the Stack.  Size does not change.  Throws an
	 * EmptyStackException if the Stack is empty and there is no element to return a 
	 * copy of.
	 * Time complexity: O(k)
	 * 
	 * @return Generic type T a copy of the element at the top of the Stack.
	 * @throws EmptyStackException thrown when Stack is empty and there is no element at the top.
	 */
	public T top() throws EmptyStackException {

		if(size == 0){
			throw new EmptyStackException("Stack is Empty");
		}

		//return top element
		return ArrayStack[size - 1];

	}

	/**
	 * This method checks to see if a Stack has space (is not at capacity).  It returns true
	 * if the Stack has more space and is not at capacity.
	 * Time complexity: O(k)
	 * 
	 * @return true when the Stack has more space (is not at capacity)
	 */
	public boolean hasSpace() {

		//if size less then capacity has space
		return size < capacity;
	}


	/**
	 * This method checks to see if a Stack has a top or not (element at the top) and therefore
	 * isn't empty.
	 * Time complexity: O(k)
	 * 
	 * @return true if the Stack has a top object and isn't empty.  
	 */
	public boolean hasTop() {

		//if size not equal to zero has a top element
		return size != 0;  

	}

	/**
	 * This method returns the number of elements currently stored in the structure (Stack).
	 * Time complexity: O(k)
	 * 
	 * @return int number of elements stored in the Stack
	 */
	public int size() {

		return size;
	}

	/**
	 * This method creates a String representation of the Stack.
	 * Time complexity: O(n)
	 * 
	 * @return String which represents the Stack
	 */
	public String toString(){

		String s = "[ " + size + " :";

		//if size zero no elements to add to string
		if(size == 0){
			s+= " ]";
		}

		//if elements in Stack
		else{

			//iterate through elements in Stack and add to string
			for(int i = 0; i < size - 1; i++){
				T value = ArrayStack[i];
				s += " " + value + ",";
			}
			//add last element to string
			T last = ArrayStack[size - 1];

			s+= " "+ last + " ]";

		}
		return s;
	}


	/**
	 * This method returns the maximum value of size for the Stack
	 * Time complexity: O(k)
	 * 
	 * @return int maximum value of size for the Stack
	 */
	public int capacity() {

		return capacity;
	}
}
