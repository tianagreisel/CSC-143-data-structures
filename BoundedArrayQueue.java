package csc143.data_structures;


/**
 * This class implements BoundedQueue and therefore is a bounded queue data structure.
 * The class uses an array as the underlying structure for the queue.
 * 
 * @author Tiana Greisel
 * @version Homework Assignment 5: Stack/Queue Implementation
 *
 * @param <T> Generic type parameter
 */
public class BoundedArrayQueue<T> implements BoundedQueue<T>{

	//array making up BoundedQueue
	private T ArrayQueue [];

	//capacity of BoundedQueue
	private int capacity;

	//number of elements in BoundedQueue
	private int size;

	//counter to move index over every time remove element from array
	private int counter;

	/**
	 * Constructs a BoundedArrayQueue with maximum capacity of int capacity where capacity
	 * is greater than or equal to zero.  Throws IllegalArgumentException if capacity is less
	 * than zero.  Uses an array as the underlying data structure and sets the size of the 
	 * initial array to zero.
	 * Time complexity: O(k)
	 *   
	 * @param capacity maximum number of elements the queue can hold
	 * @throws IllegalArgumentException if capacity is less than zero (0 <= capacity)
	 */
	@SuppressWarnings("unchecked")
	public BoundedArrayQueue(int capacity){


		if(capacity < 0){

			throw new IllegalArgumentException("capacity cannot be less than zero");
		}

		//array to make up BoundedArrayQueue set to capacity
		ArrayQueue = (T[]) new Object [capacity];

		this.capacity = capacity;
		this.size = 0;

	}

	/**
	 * This method inserts a generic type parameter to the back of the Queue, increasing the
	 * size by one.  Throws a FullQueueException if the Queue is at capacity and
	 * cannot insert another element.
	 * Time complexity: O(k)
	 * 
	 * @param o generic type parameter to be added to the back of the Queue.
	 * @throws FullQueueException if the Queue is at maximum capacity
	 */
	public void insert(T o) throws FullQueueException {

		if(size >= capacity){

			throw new FullQueueException("Queue is Full");

		}

		//set object to correct position in BoundedQueue which is one up from size plus 
		//how ever many elements have been removed.  Modulus wraps array around to keep constant time
		ArrayQueue[(size + counter) % capacity] = o;

		//increase size by one
		size++;

	}

	/**
	 * This method removes a generic type from the front of the Queue thereby decreasing the
	 * size by one.  Throws an EmptyQueueException if the Queue is empty and there is no
	 * element to remove.
	 * Time complexity: O(k)
	 * 
	 * @return Generic type removed from the front of the Queue
	 * @throws EmptyQueueException if Queue is empty and there is no element to remove
	 */
	public T remove() throws EmptyQueueException {

		if(size == 0 ){
			throw new EmptyQueueException("Queue is Empty");
		}

		//get front object in array at position zero, plus how every many elements removed 
		T frontObject = ArrayQueue[(0 + counter) % capacity];

		//increase counter by one since not moving objects over but wrapping around for constant time
		counter++;

		//decrease size by one
		size--;

		//return removed element
		return frontObject;
	}

	/**
	 * This method makes a copy of the (generic type) element at the front of the Queue.  Size stays the same.
	 * Time complexity: O(k)
	 * 
	 * @return copy of the (generic type) element at the front of the Queue.
	 * @throws EmptyQueueException thrown if the Queue is empty and there is no object at the front
	 */
	public T front() throws EmptyQueueException {

		if(size == 0){

			throw new EmptyQueueException("Queue is Empty");
		}

		//return object at front of queue
		return ArrayQueue[(0 + counter) % capacity];
	}

	/**
	 * This method returns true if the Queue has space for more elements and therefore 
	 * is not full (at capacity).
	 * Time complexity: O(k)
	 * 
	 *  @return true if the Queue has more space and is not at capacity (size != capacity).
	 */
	public boolean hasSpace() {

		return size < capacity;
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
	 * This method returns the number of elements currently stored in the structure (Queue).
	 * Time complexity: O(k)
	 * 
	 * @return int number of elements stored in the Queue
	 */
	public int size() {

		return size;
	}

	/**
	 * This method creates a String representation of the Queue.
	 * Time complexity: O(n)
	 * 
	 * @return String which represents the Queue
	 */
	public String toString(){

		String s = "[ " + size + " :";

		//if size zero don't add any elements just closing bracket
		if(size == 0){

			s+= " ]";

		}

		//if elements in queue
		else{

			//iterate through elements in queue
			for(int i = 0; i < size - 1; i++){

				T value = ArrayQueue[(i + counter) % capacity];
				s += " " + value + ",";
			}
			//add last element
			T last = ArrayQueue[((size - 1) + counter) % capacity];

			s+= " "+ last + " ]";

		}
		return s;	
	}
	/**
	 * This method returns the maximum value of size for the Queue
	 * Time complexity: O(k)
	 * 
	 * @return int maximum value of size for the Queue
	 */
	public int capacity() {

		return capacity;
	}
}
