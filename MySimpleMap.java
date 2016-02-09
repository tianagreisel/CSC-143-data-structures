package csc143.data_structures;


/**
 * This class represents a Simple Map.  It is duplicate suppressed.  The underlying data structure
 * for the simple map is a binary search tree.
 * 
 * @author Tiana Greisel
 * @version Homework Assignment 8: Map
 *
 * @param <E> Generic type parameter
 */
public class MySimpleMap<K, V> implements BetterMap<K, V>{

	//reference to root of Binary Tree (underlying data structure of MySimpleMap)
	private BinaryTreeNode<K, V> root;

	//size
	private int size;

	/**
	 * Constructs a MySimpleMap.  Sets root equal to null and size equal to 0.  Root is a
	 * reference to the top BinaryTreeNode in binary search tree that is the underlying data 
	 * structure.
	 * 
	 */
	public MySimpleMap(){

		//set underlying tree data structure to null
		this.root = null;

		//initialize size to 0
		this.size = 0;	
	}


	/**
	 * Associates the specified value with the specified
	 * key in the current map.
	 * @param key The key with which the specified value
	 * is to be associated.
	 * @param value The value to be associated with the 
	 * specified key.
	 * @throws IllegalArgumentException when value is null.
	 */
	@SuppressWarnings("rawtypes")
	public void put(K key, V value) throws IllegalArgumentException{

		//if key or value entered is null, throw IllegalArgumentExcpetion
		if( key == null || value == null){

			throw new IllegalArgumentException("key and value cannot be null");

		}

		try{

			root = putSubTree(root, (Comparable)key, value);
			size++; //increase size of tree by one
		}

		catch(DuplicateAddedException ex){
		}

	}

	/**
	 * This method adds the specifed key with the specified value to the simple map.  Adds to tree rooted at r.  If r is null, will
	 * construct a new BinaryTreeNode.  If the key is already in the tree, throws a DuplicateAddedException.
	 * Returns a BinaryTreeNode of possibly new tree modified to contain associated key, value pair.  Helper method for 
	 * put(K key, V value) method.
	 * 
	 * 
	 * @param r BinaryTreeNode<K, V> of subtree making up simple map
	 * @param k The key with which the specified value
	 * is to be associated.
	 * @param v The value to be associated with the 
	 * specified key.
	 * @return BinaryTreeNode (possibly new) tree modified to contain key, value pair
	 * @throws DuplicateAddedException DuplicateAddedException if try to add duplicate item 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BinaryTreeNode<K, V> putSubTree(BinaryTreeNode<K, V> r, Comparable k, V v ) throws DuplicateAddedException{

		//if r is null adding a new node
		if(r == null){

			r = new BinaryTreeNode((Comparable)k, v, null, null);

		}

		//if r is not null
		else{

			//get int comparable of key to item in node 	
			int comp = k.compareTo(r.item);

			//if zero then equal, throw exception to suppress duplicates of keys in tree
			if(comp == 0){

				throw new DuplicateAddedException("Key already in map with an associated value");

			}

			else {
				//if less than traverse to add to left subtree
				if(comp < 0){

					r.left = putSubTree(r.left, k, v);

				}

				else{
					//greater put to right subtree
					r.right = putSubTree(r.right, k, v);
				}
			}
		}

		return r;	
	}


	/**
	 * Returns the value to which the specified key is mapped,
	 * or <tt>null</tt> if the specified key is not mapped.
	 * @param key The key whose associated value is to be returned
	 * @return The value to which the specified key is mapped,
	 * or <tt>null</tt> if the specified key is not mapped.
	 */
	public V get(Object key){

		return subTreeGet(root, key);

	}

	/**
	 * This method returns the value to which the specified key is mapped or null if
	 * the specified key is not mapped.  Helper method for get(Object key) to look in 
	 * subtrees for recursion to traverse tree.
	 * 
	 * @param r BinaryTreeNode<K, V> of subtree making up simple map
	 * @param k The key with which the specified value
	 * is to be associated.
	 * @return The value to which the specified key is mapped,
	 * or <tt>null</tt> if the specified key is not mapped. 
	 */
	@SuppressWarnings("rawtypes")
	public V subTreeGet(BinaryTreeNode<K, V> r, Object k){

		//return null if specified key not mapped
		if(!containsKey((Comparable)k)){

			return null;
		}

		//get int comparable of key to item in node
		@SuppressWarnings("unchecked")
		int comp = ((Comparable)k).compareTo(r.item);

		//if zero then found node want, return its value
		if(comp == 0){

			return r.value;
		}
		//if less than look in left subtree 
		else if(comp < 0){

			return subTreeGet(r.left,k);
		}

		else{

			//if greater look in right subtree
			return subTreeGet(r.right, k);
		}
	}

	/**
	 * Returns true if the current map contains a mapping for the
	 * specified key.  
	 * 
	 * @param key The key whose presence in the map is being tested.
	 * @return true if this map contains a mapping for the specified
	 * key.
	 */
	@SuppressWarnings("rawtypes")
	public boolean containsKey(Object key){

		return subTreeContainsKey( root, (Comparable)key);
	}


	/**
	 * This method returns true if the current map contains a mapping for the
	 * specified key. Helper method for containsKey(Object key) to look in 
	 * subtrees for recursion to traverse tree.
	 * 
	 * 
	 * @param r BinaryTreeNode<K, V> of subtree making up simple map
	 * @param k The key whose presence in the map is being tested.
	 * @return true if this map contains a mapping for the specified
	 * key.
	 */
	public boolean subTreeContainsKey(BinaryTreeNode<K, V> r, Object k){


		//if r is null, no items in it, so false, it doesn't contain key
		if(r == null){

			return false;
		}

		//if r is not null
		else{

			//compare item looking for to item in current node
			@SuppressWarnings({ "unchecked", "rawtypes" })
			int comp = ((Comparable)k).compareTo(r.item);

			//equals 0 then found item, they are the same, return true
			if(comp == 0){

				return true;
			}

			//less than 0, item searching for is less than current item so look in left subtree
			if(comp < 0){

				return subTreeContainsKey(r.left, k);

			}
			//(comp > 0) look in right subtree
			else{
				return subTreeContainsKey(r.right, k);
			}
		}
	}

	/**
	 * Returns true if the current map contains no key-value mappings.
	 * @return true if the current map contains no key-value mappings.
	 */
	public boolean isEmpty(){

		return size == 0;
	}

	/**
	 * Removes all of the mappings from the current map.
	 */
	public void clear(){

		this.root = null;
		this.size = 0;
	}

	/**
	 * Returns the number of key-value mappings in this map
	 * @return The number of key-value mappings in this map
	 */
	public int size(){

		return size;
	}

	/**
	 * Returns true if the current map contains one or more
	 * keys mapped to the specified value.
	 * @param value The value whose presence in the current 
	 * map is being tested.
	 * @return true if the current map contains one or more
	 * keys mapped to the specified value.
	 */
	public boolean containsValue(Object value){

		return subTreeContainsValue(root, value);

	}


	/**
	 * This method returns true if the current map contains one or more
	 * keys mapped to the specified value.  Helper method for containsValue(Object value) to look in 
	 * subtrees for recursion to traverse tree.
	 * 
	 * 
	 * @param r BinaryTreeNode<K, V> of subtree making up simple map
	 * @param value The value whose presence in the current 
	 * map is being tested.
	 * @return true if the current map contains one or more
	 * keys mapped to the specified value.
	 */
	public boolean subTreeContainsValue(BinaryTreeNode<K, V> r, Object value){

		//if null, false, no keys mapped to specified value
		if(r == null){

			return false;
		}

		//if r's value equals to value looking for, then true, contains key value mapped
		else if(r.value == value){
			return true;
		}

		else{

			//look in left and right subtrees recursively
			return subTreeContainsValue(r.left, value) || subTreeContainsValue(r.right, value);
		} 	
	}

	/**
	 * Remove the mapping for the specified key from this map
	 * if present. Returns the value to which the specified key
	 * was mapped, null if the current map contains no mapping 
	 * for the specified key.
	 * @param key The key whose mapping is to be removed from 
	 * the map.
	 * @return The value associated with the key, or null if the
	 * map contained no mapping for the key.
	 */
	public V remove(Object key){

		//if map doesn't contain key return null
		if(!containsKey(key)){

			return null;
		}

		else{

			size--;
			return subTreeRemove(getNode(key), key);	
		}  	
	}

	/**
	 * This method removes the mapping for the specified key from this map
	 * if present. Returns the value to which the specified key
	 * was mapped, null if the current map contains no mapping 
	 * for the specified key. Helper method for remove(Object value) to look in 
	 * subtrees for recursion to traverse tree.
	 * 
	 * 
	 * @param r BinaryTreeNode<K, V> of subtree making up simple map
	 * @param key The key whose mapping is to be removed from 
	 * the map.
	 * @return The value associated with the key, or null if the
	 * map contained no mapping for the key.
	 */
	public V subTreeRemove(BinaryTreeNode<K, V> r,Object key){

		//value of node removing to return
		V value = r.value;

		//if a leaf
		if(r.left == null && r.right == null){
			r.value = null;
			r.item = null;
			r = null;
		}

		//if one child on r.right
		else if(r.left == null){

			//get value from child, and replace removing node value with child's value
			r.value = r.right.value;  
			r.item = r.right.item;
			r.right = null;
		}

		//if one child on r.left
		else if(r.right == null){
			r.value = r.left.value;
			r.item = r.left.item;
			r.left = null;	
		}

		//2 children, pick largest value on left and replace removing node value with that value
		else{

			BinaryTreeNode<K, V> maxNode = subTreeMaxValue(r.left);
			r.item = maxNode.item;
			r.value = maxNode.value;
			maxNode.item = null;
			maxNode.value = null;
			maxNode = null;		

		}

		return value;
	}


	/**
	 * This method returns the node with the highest key value in its left subtree.
	 * 
	 * @param r BinaryTreeNode<K, V> being tested for the highest subtree value
	 * @return the BinaryTreeNode<K, V> with the highest key value
	 */
	public BinaryTreeNode<K, V> subTreeMaxValue(BinaryTreeNode<K,V> r){

		//node to return
		BinaryTreeNode<K,V> maxNode;

		//if r's right child is null, return r
		if(r.right==null){
			return r;	
		}
		//look to the right (larger values) until you find the largest value node (end up at leaf)
		else{
			maxNode = subTreeMaxValue(r.right);
		}

		return maxNode;	
	}


	/**
	 * This method gets the node with the associated key
	 * value entered as a parameter.
	 * 
	 * @param key The key whose mapping is to be removed from 
	 * the map.
	 * @return BinaryTreeNode<K, V> the node that has the key value parameter
	 */
	public BinaryTreeNode<K, V> getNode(Object key){

		return subTreeGetNode(root, key);
	}

	/**
	 * This method gets the node with the associated key
	 * value entered as a parameter. Meant to be a helper method of getNode(Object key) to look in 
	 * subtrees for recursion to traverse tree.
	 * 
	 * @param r BinaryTreeNode<K, V> of subtree making up simple map
	 * @param key the key whose mapping is to be removed from 
	 * the map.
	 * @return BinaryTreeNode<K, V> the node that has the key value parameter
	 */
	public BinaryTreeNode<K, V> subTreeGetNode(BinaryTreeNode<K, V> r, Object key){

		//node to return
		BinaryTreeNode<K, V> node;

		//if null, return null
		if(r == null){
			return null;
		}

		//if not null
		else{

			//compare value of key looking for to node item
			@SuppressWarnings({ "unchecked", "rawtypes" })
			int comp = ((Comparable)key).compareTo(r.item);

			//if zero, found the node looking for
			if(comp == 0){

				node = r;
			}

			//if less than zero, look in left subtree
			else if(comp < 0){

				node = subTreeGetNode(r.left, key);
			}

			//if greater than, look in right subtree
			else{

				node = subTreeGetNode(r.right, key);
			}
		}

		return node;
	}


	/**
	 * Returns a String representation of the contents of the map.  Uses subtreeString() method.  Uses
	 * a pre-order traversal of the underlying data structure which is a binary search tree.
	 * 
	 * @return  the String representation of the map.
	 */
	public String toString(){

		//use subtreeString() method to create string representation of simple set
		String treeString = "" + subtreeString(root);

		return treeString;
	}

	/**
	 * Returns a String representation of the contents of the map.  Uses subtreeString() method.  Uses
	 * a pre-order traversal of the underlying data structure which is a binary search tree.  Helper method for 
	 * toString() to look in subtrees for recursion to traverse tree.
	 *
	 * @param r BinaryTreeNode<K, V> of subtree making up simple map
	 * @return the String representation of the map.
	 */
	public String subtreeString(BinaryTreeNode<K, V> r){

		//string composing string representation of simple set
		String s = "";

		//if r is null
		if(r == null || r.item == null || r.value == null){

			return "()";
		}

		//if r is not null
		else{
			//get item in the node first and add to string
			s = "(" + r.item + ":" + r.value +" ";

			//next traverse left node and add item to string
			s += subtreeString(r.left) + " ";

			//then traverse right node and add item to string
			s += subtreeString(r.right);

		}
		//return string representing subtree
		return s + ")";
	}



	/**
	 * This class represents a single node of a Binary Tree.  Helper class of MySimpleMap which
	 * uses a binary search tree as its underlying data structure.  This class represents a single
	 * node in a binary tree consisting of multiple nodes.  Each node contains a single item consisting of
	 * of a generic type K, which is the key and a generic type V, which is the value of the associate key,
	 *  and references to the right and left nodes in the tree.  Meant to be used in the implementation of a
	 *  map.
	 *  
	 * @author Tiana Greisel
	 *
	 * @param <K> Generic type parameter
	 * @param <V> Generic type parameter
	 */
	@SuppressWarnings("hiding")
	private class BinaryTreeNode<K, V> {

		//key 
		private K item;

		//associated value
		private V value;

		//reference to left BinaryTreeNode
		private BinaryTreeNode<K, V> left;

		//reference to right BinaryTreeNode
		private BinaryTreeNode<K, V> right;



		/**
		 * Constructs a BinaryTreeNode.  Sets item equal to k, the key value. Sets value equal
		 * to v, the value associated with the key, and sets left and right to the associated
		 * left and right subtree references (children) of the node.
		 * 
		 * @param k K Generic type parameter key value
		 * @param v V Generic type parameter value associated with key
		 * @param l left BinaryTreeNode reference
		 * @param r right BinaryTreeNode reference
		 */
		public BinaryTreeNode(K k, V v, BinaryTreeNode<K, V> l, BinaryTreeNode<K, V> r){

			this.item = k;
			this.value = v;
			this.left = l;
			this.right = r;

		}
	}

	public static void main(String[] args){

		MySimpleMap<Integer, String>  set = new MySimpleMap();
		//set.put(5, "five");
		//set.put(2, "two");
		//set.put(6, "six");
		//set.put(1, "one");
		//set.put(3, "three");
		//set.put(7, "seven");
		//set.put(4, "four");
		//set.remove(2);

		set.put(17, "seventeen");
		set.put(24, "twentyfour");
		set.put(20, "twenty");
		set.put(6, "six");
		
		set.put(28, "twentyeight");
		set.put(11, "eleven");
		set.put(14, "fourteen");
		set.put(5, "five");
		//set.remove(6);
		set.put(4, "four");
		set.put(2, "two");
		set.put(3, "three");
		//set.remove(6);
		set.put(22, "twentytwo");
		set.put(18, "eightteen");
		set.put(19, "nineteen");
		//set.remove(6);
		set.remove(24);
		set.remove(22);
		//set.remove(20);
		
		//System.out.println(set.remove(20));

		//System.out.println(set.remove(4));
		//set.remove(4);
		//set.remove(1);
		//set.remove(2);
		//System.out.println(set.size());

		//set.clear();
		//System.out.println(set.isEmpty());
		//System.out.println(set.containsKey(6));

		//System.out.println(set.containsValue("ten"));
		//System.out.println(set.size());
		//System.out.println(set.get(7));
		System.out.println(set);





	}
}