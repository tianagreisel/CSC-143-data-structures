package csc143.data_structures;

/**
 * This class represents a Link List data structure.  Helper class to BoundedQueue, BoundedStack,
 * UnboundedQueue and UnboundedStack.  The LinkList contains instance fields for the first and last
 * Link objects.  Within each Link object is an object (item) and a next Link that points to the next
 * Link in the LinkList.
 * 
 * @author Tiana Greisel
 * @version Homework Assignment 5: Stack/Queue Implementation
 *
 * @param <T> Generic type parameter
 */
public class LinkList<T> {

	//first Link in LinkList
	private Link<T> first;
	
	//last Link in LinkList
	private Link<T> last;
	
	//number of Links in LinkList
	private int numLinks;
	

	/**
	 * Constructs a Link List.  Sets first and last to null and numLinks to zero.
	 * Time complexity: O(k)
	 * 
	 */
	public LinkList(){

		first = null;
		last = null;
		numLinks = 0;
	}

	/**
	 * This method adds a generic type T to the Link List and returns true if the LinkList
	 * was changed and the the element was successfully added.
	 * Time complexity: O(k)
	 * 
	 * @param o Generic type T to be added to the Link List
	 * @return true if LinkList changed and element successfully added
	 */
	public boolean add(T o){

		//Link to be added to List
		Link<T> newLink = new Link<T> (o,null);

		//if first is null then first link added to LinkList
		if(first == null){
			first = newLink;

		}
		
		else{
			//set current last Link's next to newLink
			last.next = newLink;

		}

		//make new Link the last Link
		last = newLink;
		
		//increase number of Links in list by one
		numLinks++;
		return true;

	}

	/**
	 * This method returns the size of the LinkList, which is the number of Links in the LinkList.
	 * Time complexity: O(k)
	 * 
	 * @return numLinks number of Links in LinkList
	 */
	public int size(){
		
		return numLinks;
	}
	
	
	/**
	 * This method returns the Link at position pos in the LinkList.
	 *  precondition (unchecked): 0 <= pos < size
	 *  Time complexity: O(n)
	 * 
	 * @param pos integer position of desired Link in LinkList
	 * @return Link<T> Link at position pos in LinkList
	 */
	public Link<T> getLinkAtPos(int pos){

		//get first Link in LinkList
		Link<T> p = first;

		//iterate through links til find Link at desired position
		for(int k = 1; k < pos; k++){

			p = p.next;
		}

		return p;
	}

	/**
	 * This method returns a generic type element within the Link 
	 * at position pos in Link List.
	 * Time complexity: O(n)
	 * 
	 * @param pos integer position of desired Link in LinkList
	 * @return T Generic type element in Link
	 */
	public T getLinkItemAtPos(int pos){

		Link<T> p = getLinkAtPos(pos);
		
		//return item in the Link at desired position
		return p.item;
	}

	/**
	 * This method returns the generic type element at the last (top) Link in the Link List.
	 * Time complexity: O(n)
	 * 
	 * @return T the generic type item in the top Link of the LinkList
	 */
	public T removeLastLinkItem(){

		Link<T> topLink = removeLastLink();
		
		//return item in LastLink
		return topLink.item;
	}

	/**
	 * This method returns the top (last) Link in the LinkList. 
	 * Time complexity: O(k) 
	 * 
	 * @return Link<T> the top Link of the LinkList
	 */
	public Link<T> removeLastLink(){

		//get last Link
		Link<T> topLink = last;
		
		//get second to last Link
		Link<T> topMinusOne = getLinkAtPos(numLinks - 1);

		//make second to last Link null now since new last link
		topMinusOne.next = null;

		//update last
		last = topMinusOne;
		
		//decrease numLinks
		numLinks--;
		return topLink;
	}

	/**
	 * This method returns the first Link in the LinkList.
	 * Time complexity: O(n)
	 * 
	 * @return Link<T> first Link in the LinkList
	 */
	public Link<T> removeFirstLink(){

		//get Link in front to be removed
		Link<T> frontLink = first;


		//get Link next to front to become new first
		Link<T> frontPlusOne = getLinkAtPos(2);

		//change next pointer to null to remove from LinkList
		frontLink.next = null;

		//update first
		first = frontPlusOne;
		numLinks--;

		return frontLink;
	}

	/**
	 * This method returns the generic type item in the first Link in the LinkList.
	 * Time complexity: O(n)
	 * 
	 * @return T Generic type item in first Link in LinkList
	 */
	public T removeFirstLinkItem(){

		Link<T> frontLink = removeFirstLink();

		//return item in first Link
		return frontLink.item;

	}


	/**
	 * This class represents a Link in a LinkList.  Each Link contains an item of generic type and a
	 * next field that is the next Link in the LinkList.
	 * 
	 * @author Tiana Greisel
	 *
	 * @param <T> Generic type parameter
	 */
	public class Link<T>{

		//generic type item stored in Link
		T item;
		
		//next Link in LinkList
		Link<T> next;

		/**
		 * Constructs a Link object.  Sets the item and next instance fields.
		 * Time complexity: O(k)
		 * 
		 * @param item T Generic type item
		 * @param next Link<T> next Link in the LinkList
		 */
		public Link(T item, Link<T> next){

			this.item = item;
			this.next = next;
		}
	}
}
