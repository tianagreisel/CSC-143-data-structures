package csc143.data_structures;


/**
 * This class represents a Simple Set.  It is duplicate suppressed.  The underlying data structure
 * for the simple set is a binary search tree.
 * 
 * @author Tiana Greisel
 * @version Learning Activity 11: Sets
 *
 * @param <E> Generic type parameter
 */
public class MySimpleSet<E> implements SimpleSet<E>{

	//reference to root of Binary Tree (underlying data structure of MySimpleSet)
	private BinaryTreeNode<E> root;

	//size
	private int size;

	/**
	 * Constructs a MySimpleSet.  Sets root equal to null and size equal to 0.  Root is a
	 * reference to the top BinaryTreeNode in binary search tree that is the underlying data 
	 * structure.
	 * 
	 */
	public MySimpleSet(){

		//set underlying tree data structure to null
		this.root = null;

		//initialize size to 0
		this.size = 0;
	}

	/**
	 * Add an element to the set. Uses addToSubtree() method which throws DuplicateAddedException.
	 * 
	 * @param e The element to be added to the set
	 * @return  <tt>true</tt> if this operation updated the contents of the set
	 */
	@SuppressWarnings("rawtypes")
	public boolean add(E e){

		try{
			root = addToSubtree(root, (Comparable) e );
			size++;
			return true;
		}
		catch(DuplicateAddedException ex){
			return false;

		}
	}

	/**
	 * This method adds elem to the simple set.  Adds elem to tree rooted at r.  If r is null, will
	 * construct a new BinaryTreeNode.  If the elem is already in the set, throws a DuplicateAddedException.
	 * Returns a BinaryTreeNode of possibly new tree modified to contain elem.  Helper method for add(E e)
	 * method.
	 * 
	 *  @param r BinaryTreeNode root of tree making up simple set
	 * @param elem element attempting to add to tree (simple set)
	 * @return BinaryTreeNode (possibly new) tree modified to contain elem
	 * @throws DuplicateAddedException if try to add duplicate item 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BinaryTreeNode<E> addToSubtree(BinaryTreeNode<E> r, Comparable elem) throws DuplicateAddedException{

		//if r is null construct a new node of given elem and null references to right and left nodes
		if(r == null){
			return new BinaryTreeNode(elem, null, null);
		}
		//if not null
		else{
			//compare item node contains to item adding
			int comp = elem.compareTo(r.item);

			//if item being added equals 0, items are equal (duplicate suppressed)
			if(comp == 0){

				throw new DuplicateAddedException("Element already in set");
			}

			//item being added is less than item in current node
			if(comp < 0){

				r.left = addToSubtree(r.left, elem);

			}

			//comp > 0  item being added is greater than item in current node
			else{

				r.right = addToSubtree(r.right, elem);  

			}

			return r; 

		}
	}

	/**
	 * Remove all elements from this set
	 */
	public void clear(){

		this.root = null;
		this.size = 0;

	}

	/**
	 * Checks for the existence of the specified value within the set.  Uses subtreeContains() method.
	 * 
	 * @param e The value sought
	 * @return  <tt>true</tt> if the value exists in the set.
	 */
	@SuppressWarnings("rawtypes")
	public boolean contains(E e){

		return subtreeContains(root, (Comparable)e);

	}

	/**
	 * This method checks a subtree rooted at r to see if it contains an element, elem, given as 
	 * a parameter.  Returns true if the set contains the element and false if it doesn't.  Helper method
	 * of contians(E e).
	 *   
	 * @param r BinaryTreeNode rooted at r
	 * @param elem element seeing if set contains
	 * @return boolean true if elem is in set
	 */
	@SuppressWarnings("unchecked")
	public boolean subtreeContains(BinaryTreeNode<E> r,  @SuppressWarnings("rawtypes") Comparable elem){

		//if r is null, no items in it, so false, it doesn't contain item
		if(r == null){

			return false;
		}

		//if r is not null
		else{

			//compare item looking for to item in current node
			int comp = elem.compareTo(r.item);

			//equals 0 then found item, they are the same, return true
			if(comp == 0){

				return true;
			}

			//less than 0, item searching for is less than current item so look in left subtree
			if(comp < 0){

				return subtreeContains(r.left, elem);

			}
			//(comp > 0) look in right subtree
			else{
				return subtreeContains(r.right, elem);
			}
		}

	}
	/**
	 * Check for the existence of elements in the set
	 * 
	 * @return  <tt>true</tt> if there are no elements in the set
	 */
	public boolean isEmpty(){

		return size == 0;
	}

	/**
	 * Return the number of elements in the set
	 * @return  the number of elements in the set.
	 */
	public int size(){

		return size;
	}

	/**
	 * Returns a String representation of the contents of the set.  Uses subtreeString() method.  Uses
	 * a pre-order traversal of the underlying data structure which is a binary search tree.
	 * 
	 * @return  the String representation of the set.
	 */
	public String toString(){
		
		//use subtreeString() method to create string representation of simple set
		String treeString = "" + subtreeString(root);

		return treeString;
	}

	public String subtreeString(BinaryTreeNode<E> r){

		//string composing string representation of simple set
		String s;

		//if r is null
		if(r == null){

			return "()";
		}

		//if r is not null
		else{

			//get item in the node first and add to string
			s = "(" + r.item + " ";

			//next traverse left node and add item to string
			s += subtreeString(r.left) + " ";

			//then traverse right node and add item to string
			s += subtreeString(r.right);

		}
		//return string representing subtree
		return s + ")";
	}

	/**
	 * This class represents a single node of a Binary Tree.  Helper class of MySimpleSet which
	 * uses a binary search tree as its underlying data structure.  This class represents a single
	 * node in a binary tree consisting of multiple nodes.  Each node contains a single item consisting of
	 * of a generic type E and references to the right and left nodes in the tree.
	 *  
	 * @author Tiana Greisel
	 *
	 * @param <E> Generic type parameter
	 */
	@SuppressWarnings("hiding")
	private class BinaryTreeNode<E>{

		//data item
		private E item;

		//reference to left BinaryTreeNode
		private BinaryTreeNode<E> left;

		//reference to right BinaryTreeNode
		private BinaryTreeNode<E> right;


		/**
		 * 
		 * @param item Generic type parameter E
		 * @param l left BinaryTreeNode reference
		 * @param r right BinaryTreeNode reference
		 */
		public BinaryTreeNode(E item, BinaryTreeNode<E> l, BinaryTreeNode<E> r){

			this.item = item;
			this.left = l;
			this.right = r;
		}
	}
}


/**
 * This class extends Exception and constructs a new exception with the specified detail message.
 * Created for the add method of MySimpleSet.
 * 
 * @author Tiana Greisel
 * @version Learning Activity 11: Sets
 * 
 */
@SuppressWarnings("serial")
class DuplicateAddedException extends Exception{


	/**
	 * Constructs a new exception with the specified detail message.  Invokes superclass
	 * constructor. 
	 * 
	 * @param message Detailed message of reason for exception being thrown
	 */
	public DuplicateAddedException(String message){

		super(message);
	}
}