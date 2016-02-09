package csc143.data_structures;

/**
 * This class implements UnboundedStack and therefore is an unbounded stack data structure.
 * The class uses an array as the underlying structure for the stack.  Uses a bounded array
 * and appears unbounded by copying elements over into an array that doubles as needed.
 * 
 * @author Tiana Greisel
 * @version Homework Assignment 5: Stack/Queue Implementation
 *
 * @param <T> Generic type parameter
 */
public class UnboundedArrayStack<T> implements UnboundedStack<T>{

	//underlying array that makes up UnboundedStack
	private T ArrayStack [];

	//number of elements in UnboundedStack
	private int size;

	//maximum number of elements of array (keeps track so can grow as needed)
	private int capacity;

	//array that will double capacity of current array as needed
	private T ArrayStackForGrowth[];


	@SuppressWarnings("unchecked")
	/**
	 * Constructs an UnboundedArrayStack.  Uses an array as the underlying data structure and sets the size of the 
	 * initial array to zero.  Uses a generic type array.  Array constructed with initial capacity of 10 but
	 * will appear unbounded because push() method doubles capacity as needed.
	 * Time complexity: O(k)
	 *   
	 */
	public UnboundedArrayStack(){

		//initial capacity of array 10
		ArrayStack = (T[]) new Object[10];
		this.size = 0;
		this.capacity = 10;
	}

	@SuppressWarnings("unchecked")
	/**
	 * This method adds a generic type element o to the top of the Stack thereby increasing the size by one. 
	 * Time complexity: O(n) 
	 * 
	 * @param o Generic type element to be added to the top of the Stack.
	 */
	public void push(T o) {

		//if size less than capacity
		if(size < capacity){

			//add element at next available position in stack
			ArrayStack[size] = o;

		}

		//if size is greater than capacity
		else if(size >= capacity){

			//set newCapacity to double old capacity
			int newCapacity = capacity * 2;

			//create a new array with double capcity of old array
			ArrayStackForGrowth = (T[]) new Object [newCapacity];

			//copy all items from old array over into new array
			for(int i = 0; i < ArrayStack.length; i++){

				ArrayStackForGrowth[i] = ArrayStack[i];

			}

			//set old array to new array
			ArrayStack = ArrayStackForGrowth;

			//add element at next available position in array
			ArrayStack[size] = o;

			//set capacity to new capacity
			capacity = newCapacity;
		}

		//increase size by one
		size++;	
	}


	/**
	 * This method removes a generic type element o from the top of the Stack decreasing the size by one.  Throws an
	 * EmptyStackException if the Stack is empty and there is nothing to remove.
	 * Time complexity: O(k)
	 * 
	 * @return Generic type T removed from the top of the Stack.
	 * @throws EmptyStackException thrown when Stack is empty and no element can be removed.
	 */
	public T pop() throws EmptyStackException {

		if(size == 0){

			throw new EmptyStackException("Stack is Empty");
		}

		//get element at top of stack
		T topObject = ArrayStack[size - 1];

		//set to null to remove it
		ArrayStack[size - 1] = null;

		//decrease size by one
		size--;

		//return top element
		return topObject;
	}


	/**
	 * This method returns a copy of the element at the top of the Stack.  Size does not change. Throws an
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

		//return top element in stack
		return ArrayStack[size - 1];
	}


	/**
	 * This method checks to see if a Stack has a top or not (element at the top) and therefore
	 * isn't empty.
	 * Time complexity: O(k)
	 * 
	 * @return true if the Stack has a top element and isn't empty.  
	 */
	public boolean hasTop() {

		return size != 0;
	}

	/**
	 * This method creates a String representation of the Stack.
	 * Time complexity: O(n)
	 * 
	 * @return String which represents the Stack
	 */
	public String toString(){

		String s = "[ " + size + " :";

		//if no elements in stack
		if(size == 0){
			s+= " ]";
		}

		//if elements in stack
		else{

			//iterate through elements in stack and add to string
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
	 * This method returns the number of elements currently stored in the structure (Stack).
	 * Time complexity: O(k)
	 * 
	 * @return int number of elements stored in the Stack
	 */
	public int size() {

		return size;
	}
}
