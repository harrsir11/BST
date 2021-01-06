package bst;



/**
 * Binary Search Tree. (Unbalanced implementation). 
 * @param <E> generic type
 * @author Riley Harris 
 *
 */
public class BST<E extends Comparable<E>> {
	/** Size of tree */ 
	private int size;
	/** Root of tree */
	private Node root; 
	
	/**
	 * Constructor for Binary Search Tree.
	 * Constructs an empty BST. 
	 */
	public BST() {
		size = 0;
		root = null;
	}
	
	/**
	 * Size of BST. 
	 * @return size as an integer
	 */
	public int size() {
		return size; 
	}
	
	
	/**
	 * Returns whether or not the specified data is contained in the tree.
	 * @param data Data to search for
	 * @return true if found, false if not
	 */
	public boolean contains(E data) {
		return contains(root, data);
	}
	
	/**
	 * Helper method to recursively search for data. 
	 * @param node Current node
	 * @param data Data to search for
	 * @return true if found, false if not
	 * @throws IllegalArgumentException if data is null
	 */
	private boolean contains(Node node, E data) {
		if (data == null) {
			throw new IllegalArgumentException("Data specified is null.");
		}
		if (node == null) { // Base case
			return false;
		} else if (data.compareTo(node.data) == 0) { // Base case 2 [found node]
			return true;
		} else { // Recursive case
			if (data.compareTo(node.data) < 0) { // go left
				return contains(node.left, data);
			} else { // greater than 0, go right
				return contains(node.right, data);
			}
		}
	}
	
	/**
	 * Add element to the tree. 
	 * @param data Data to add 
	 * @throws IllegalArgumentException if element to add is null
	 */
	public void add(E data) {
		if (data == null) {
			throw new IllegalArgumentException("Data to add cannot be null.");
		}
		root = add(root, data);
	}
	
	/**
	 * Recursive helper method to add specified data. 
	 * @param node Node to explore
	 * @param data Data to add 
	 * @return node to reference
	 */
	private Node add(Node node, E data) {
		// Adds recursively 
		if (node == null) { // Base case 
			size++;
			return new Node(data);
		} else { // Recursive case 
			if (data.compareTo(node.data) <= 0) {
				node.left = add(node.left, data);
			} else { // greater than 0 
				node.right = add(node.right, data);
			} 
		}
		return node;
	}

	/**
	 * Finds and returns the minimum element in the BST.
	 * @return Minimum element
	 * @throws IllegalArgumentException if called with no elements in tree
	 */
	public E getMin() {
		if (size == 0) {
			throw new IllegalArgumentException("No elements in tree.");
		}
		return getMin(root);
	}
	
	/**
	 * Helper method that recursively searches for minimum element. 
	 * @param node Node to begin search with
	 * @return E minimum element
	 */
	private E getMin(Node node) {
		if (node.left == null) { // Base case 
			return node.data;
		} else { // Recursive case 
			return getMin(node.left);
		}
	}
	
	/**
	 * Deletes the min element of the BST.
	 * @throws IllegalArgumentException if there are no elements in the tree
	 */
	public void deleteMin() {
		if (size == 0) {
			throw new IllegalArgumentException("No elements in tree.");
		}
		root = deleteMin(root);
		size--;
	}
	
	/**
	 * Helper method that recursively searches for min to delete. 
	 * @param node Node to search with 
	 * @return updated node reference 
	 */
	private Node deleteMin(Node node) {
		if (node.left == null) { // Base case
			return node.right;
		} else { // Recursive case 
			node.left = deleteMin(node.left);
			return node;
		}
	}

	/**
	 * Node containing references to left and right children. 
	 * Contains generic data. 
	 * @author Riley Harris
	 *
	 */
	private class Node {

		/** Reference to left node */
		private Node left; 
		/** Reference to right node */
		private Node right; 
		/** Data of node */ 
		private E data; 
		
		/**
		 * Constructs node with null right/left references and specified data.
		 * @param data Data of node
		 */
		private Node(E data) {
			this.data = data;
			left = null;
			right = null;
		}
		
		/**
		 * Parameterized node that allows for specification of left/right references 
		 * in addition to data
		 * @param data Data of node
		 * @param left Left reference
		 * @param right Right reference 
		 */
		private Node(E data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
}
