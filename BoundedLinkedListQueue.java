package csc143.data_structures;

/**
 * This class implements BoundedQueue and therefore is a bounded queue data structure.
 * The class uses a Link List as the underlying structure for the queue.
 * 
 * @author Tiana Greisel
 * @version Homework Assignment 5: Stack/Queue Implementation
 *
 * @param <T> Generic type parameter
 */
public class BoundedLinkedListQueue<T> implements BoundedQueue<T>{

	//underlying LinkList of BoundedQueue
	private LinkList<T> BoundedQueue;

	//maximum number of elements of BoundedQueue
	private int capacity;

	/**
	 * Constructs a BoundedLinkListQueue with maximum capacity of int capacity where capacity
	 * is greater than or equal to zero.  Throws IllegalArgumentException if capacity is less
	 * than zero.  Uses a Link List as the underlying data structure. Size is set to zero
	 * within the LinkList constructor.
	 * 
	 * @param capacity capacity maximum number of elements the queue can hold
	 * @throws IllegalArgumentException if capacity is less than zero (0 <= capacity)
	 */
	public BoundedLinkedListQueue(int capacity){

		if(capacity < 0){

			throw new IllegalArgumentException("capacity cannot be less than zero");
		}

		//create new LinkList that makes up BoundedQueue
		BoundedQueue = new LinkList<T>();
		this.capacity = capacity;
	}

	/**
	 * This method inserts a generic type parameter to the back of the Queue, increasing the
	 * size by one.  Throws a FullQueueException if the Queue is at capacity and
	 * cannot insert another element.  Uses add method of LinkList.
	 * Time complexity: O(k)
	 * 
	 * @param o generic type parameter to be added to the back of the Queue.
	 * @throws FullQueueException if the Queue is at maximum capacity
	 */
	public void insert(T o) throws FullQueueException {

		if(size() >= capacity ){  

			throw new FullQueueException ("Queue is Full");
		}

		//use LinkList add method to add element to BoundedQueue
		BoundedQueue.add(o);
	}

	/**
	 * This method removes a generic type from the front of the Queue thereby decreasing the
	 * size by one.  Throws an EmptyQueueException if the Queue is empty and there is no
	 * element to remove. Uses removeFirstLinkItem() in LinkList.
	 * Time complexity: O(n) because helper method in LinkList is O(n) otherwise O(k).
	 * 
	 * @return Generic type removed from the front of the Queue
	 * @throws EmptyQueueException if Queue is empty and there is no element to remove
	 */
	public T remove() throws EmptyQueueException {

		if(size() == 0){

			throw new EmptyQueueException("Queue is Empty");
		}

		//use LinkList remove method to remove first Link item
		return BoundedQueue.removeFirstLinkItem();  
	}

	/**
	 * This method makes a copy of the (generic type) element at the front of the Queue.  Size stays the same.
	 * Time complexity: O(n) because helper method in LinkList is O(n) otherwise O(k). Uses getLinkItemAtPos()
	 * method of LinkList.
	 * 
	 * @return copy of the (generic type) element at the front of the Queue.
	 * @throws EmptyQueueException thrown if the Queue is empty and there is no object at the front
	 */
	public T front() throws EmptyQueueException {

		if(size() == 0){
			throw new EmptyQueueException("Queue is Empty");
		}

		//use LinkList method to get item in first Link (front element)
		return BoundedQueue.getLinkItemAtPos(1);  
	}

	/**
	 * This method returns true if the Queue has space for more elements and therefore 
	 * is not full (at capacity).
	 * Time complexity: O(k)
	 * 
	 *  @return true if the Queue has more space and is not at capacity (size != capacity).
	 */
	public boolean hasSpace() {

		return size() < capacity;   
	}

	/**
	 * This method returns true if the Queue has a front object/ element and therefore is 
	 * not empty.
	 * Time complexity: O(k)
	 * 
	 * @return true if the Queue has a front element
	 */
	public boolean hasFront() {

		return size() != 0;
	}

	/**
	 * This method returns the number of elements currently stored in the structure (Queue).
	 * Uses size method of Link List to return number of Links in LinkList.
	 * Time complexity: O(k)
	 * 
	 * @return int number of elements stored in the Queue
	 */
	public int size() {

		return BoundedQueue.size();
	}

	/**
	 * This method creates a String representation of the Queue.
	 * Time complexity: O(n)
	 * 
	 * @return String which represents the Queue
	 */
	public String toString(){

		//number of elements in LinkList
		int size = size();

		String s = "[ " + size + " :";

		//if size is zero no elements in LinkList
		if(size == 0){
			s+= " ]";
		}

		//if elements in LinkList
		else{

			//iterate through elements in LinkList and add to string
			for(int i = 1; i < size; i++){

				T value = BoundedQueue.getLinkItemAtPos(i);
				s += " " + value + ",";
			}
			//get last item in LinkList
			T last = BoundedQueue.getLinkItemAtPos(size);

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
