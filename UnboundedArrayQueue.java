package csc143.data_structures;

/**
 * This class implements UnboundedQueue and therefore is an unbounded queue data structure.
 * The class uses an array as the underlying structure for the queue.  Uses a bounded array
 * and appears unbounded by copying elements over into an array that doubles as needed.
 * 
 * @author Tiana Greisel
 * @version Homework Assignment 5: Stack/Queue Implementation
 *
 * @param <T> Generic type parameter
 */
public class UnboundedArrayQueue<T> implements UnboundedQueue<T> {

	//underlying array making up UnboundedQueue
	private T ArrayQueue[];

	//number of elements in UnboundedQueue
	private int size;

	//maximum number of elements of array (keeps track so can grow as needed)
	private int capacity;

	//counter to move index over every time remove element from array
	int counter;

	//array that will double capacity of current array as needed
	private T ArrayQueueForGrowth[];

	/**
	 * Constructs an UnboundedArrayQueue. Uses an array as the underlying data structure and sets the size of the 
	 * initial array to zero.  Sets initial capacity to 10.  Array constructed with initial capacity of 10 but
	 * will appear unbounded because insert() method doubles capacity as needed.
	 * Time complexity: O(k)
	 *   
	 */
	@SuppressWarnings("unchecked")
	public UnboundedArrayQueue(){

		//initial capacity of array 10
		ArrayQueue = (T[]) new Object[10];
		this.size = 0;
		this.capacity = 10;

	}


	/**
	 * This method inserts a generic type element to the back of the Queue, increasing the
	 * size by one.  The initial array will double its capacity as needed to appear unbounded.
	 * 
	 * @param o Generic type to be added to the back of the Queue.
	 * Time complexity:  O(n)
	 */
	@SuppressWarnings("unchecked")
	public void insert(T o) {

		//if size is less than capacity plus any objects removed (since no sliding over)
		if(size + counter < capacity){

			//put element in next available position
			ArrayQueue[size + counter] = o;  
		}

		//if capacity reached
		else if(size + counter >= capacity){

			//double current capacity
			int newCapacity = capacity * 2;

			//create a new array with double capacity of old array
			ArrayQueueForGrowth = (T[]) new Object[newCapacity];

			//copy all elements from old array into new array
			for(int i = 0; i < ArrayQueue.length; i++){

				ArrayQueueForGrowth[i] = ArrayQueue[i];

			}

			//set old array to new one
			ArrayQueue = ArrayQueueForGrowth;

			//add next element into array
			ArrayQueue[size + counter] = o;

			//set new capacity
			capacity = newCapacity;

		}

		//increase size by one
		size++;

	}

	/**
	 * This method removes a generic type element from the front of the Queue thereby decreasing the
	 * size by one.  Throws an EmptyQueueException if the Queue is empty and there is no
	 * element to remove.  When an element is removed from the queue all elements aren"t moved over, instead
	 * the index for first element is increased with variable counter to keep constant time.
	 * Time complexity: O(k)
	 * 
	 * @return Object removed from the front of the Queue
	 * @throws EmptyQueueException if Queue is empty and there is no object to remove
	 */
	public T remove() throws EmptyQueueException {

		if(size == 0){

			throw new EmptyQueueException("Queue is Empty");
		}

		//get front object to return
		T frontObject = ArrayQueue[0 + counter];

		//increase counter since not moving items over after removed but moving index over
		counter++;

		//decrease size by one
		size--;

		//return front element
		return frontObject;
	}

	/**
	 * This method makes a copy of the element at the front of the Queue.  Size stays the same.
	 * Time complexity: O(k)
	 * 
	 * @return copy of the element at the front of the Queue.
	 * @throws EmptyQueueException thrown if the Queue is empty and there is no element at the front
	 */
	public T front() throws EmptyQueueException {

		if(size == 0){

			throw new EmptyQueueException("Queue is Empty");	
		}

		//return front element
		return ArrayQueue[0 + counter];
	}

	/**
	 * This method returns true if the Queue has a front element and therefore is 
	 * not empty.
	 * Time complexity: O(k)
	 * 
	 * @return true if the Queue has a front element
	 */
	public boolean hasFront() {

		return size != 0;
	}

	/**
	 * This method creates a String representation of the Queue.
	 * Time complexity: O(n)
	 * 
	 * @return String which represents the Queue
	 */
	public String toString(){

		String s = "[ " + size + " :";

		//if no elements in UnboundedQueue
		if(size == 0){

			s+= " ]";
		}

		//if elements in BoundedQueue
		else{

			//iterate through values in BoundedQueue and add to string
			for(int i = 0; i < size - 1; i++){

				T value = ArrayQueue[i + counter];
				s += " " + value + ",";
			}

			//add last value in BoundedQueue to string
			T last = ArrayQueue[(size - 1) + counter];

			s+= " "+ last + " ]";
		}
		return s;
	}
	/**
	 * This method returns the number of elements currently stored in the structure (Queue).
	 * Time complexity: O(k)
	 * 
	 * 
	 * @return int number of elements stored in the Queue
	 */
	public int size() {

		return size;
	}
}
