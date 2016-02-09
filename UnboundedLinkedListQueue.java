package csc143.data_structures;

/**
 * This class implements UnboundedQueue and therefore is an unbounded queue data structure.
 * The class uses a Link List as the underlying structure for the queue.
 * 
 * @author Tiana Greisel
 * @version Homework Assignment 5: Stack/Queue Implementation
 *
 * @param <T> Generic type parameter
 */
public class UnboundedLinkedListQueue<T> implements UnboundedQueue<T>{

	//underlying LinkList making up UnboundedQueue
	private LinkList<T> UnboundedQueue;


	/**
	 * Constructs an UnboundedLinkListQueue. Uses a Link List as the underlying data structure. Size is set to zero
	 * within the LinkList constructor.  Uses a Generic type Link List.
	 * Time complexity:  O(k)
	 *
	 */
	public UnboundedLinkedListQueue(){

		//create new LinkList for UnboundedQueue
		UnboundedQueue = new LinkList<T>();

	}

	/**
	 * This method inserts a generic type element to the back of the Queue, increasing the
	 * size by one.  Use add() method in LinkList.
	 * Time complexity:  O(k)
	 * 
	 * @param o Generic type to be added to the back of the Queue.
	 */
	public void insert(T o) {

		//Use LinkList method to add element to LinkList
		UnboundedQueue.add(o);

	}

	/**
	 * This method removes a generic type element from the front of the Queue thereby decreasing the
	 * size by one.  Throws an EmptyQueueException if the Queue is empty and there is no
	 * element to remove. Uses removeFirstLinkItem() in LinkList.
	 * Time complexity: O(n) because helper method in LinkList is O(n) otherwise O(k).
	 * 
	 * @return Object removed from the front of the Queue
	 * @throws EmptyQueueException if Queue is empty and there is no object to remove
	 */
	public T remove() throws EmptyQueueException {

		if(size() == 0){

			throw new EmptyQueueException("Queue is Empty");
		}

		//use LinkList method to remove element 
		return UnboundedQueue.removeFirstLinkItem();
	}

	/**
	 * This method makes a copy of the element at the front of the Queue.  Size stays the same.
	 * Uses getLinkItemAtPos() in LinkList.
	 * Time complexity: O(n) because helper method in LinkList is O(n) otherwise O(k).
	 * 
	 * @return copy of the element at the front of the Queue.
	 * @throws EmptyQueueException thrown if the Queue is empty and there is no element at the front
	 */
	public T front() throws EmptyQueueException {

		if(size() == 0){

			throw new EmptyQueueException("Queue is Empty");
		}

		//uses LinkList method to return element at front of queue
		return UnboundedQueue.getLinkItemAtPos(1);
	}

	/**
	 * This method returns true if the Queue has a front element and therefore is 
	 * not empty.
	 * Time complexity:  O(k)
	 * 
	 * @return true if the Queue has a front element
	 */
	public boolean hasFront() {

		return size() != 0;
	}

	/**
	 * This method creates a String representation of the Queue.
	 * Time complexity:  O(n)
	 * 
	 * @return String which represents the Queue
	 */
	public String toString(){

		//number of elements in Queue
		int size = size();

		String s = "[ " + size + " :";

		//if no elements in Queue
		if(size == 0){
			s+= " ]";
		}
		//if elements in Queue
		else{

			//iterate through elements in Queue and add to string
			for(int i = 1; i < size; i++){

				T value = UnboundedQueue.getLinkItemAtPos(i);

				s += " " + value + ",";
			}

			//add last element to string
			T last = UnboundedQueue.getLinkItemAtPos(size);
			s+= " "+ last + " ]";

		}
		return s;
	}
	/**
	 * This method returns the number of elements currently stored in the structure (Queue).
	 * Uses size() method of LinkList.
	 * Time complexity:  O(k)
	 * 
	 * 
	 * @return int number of elements stored in the Queue
	 */
	public int size() {
		//uses LinkList method to return number of Links in LinkList (queue)
		return UnboundedQueue.size();
	}
}
