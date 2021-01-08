package bst;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests BST class.
 * @author Riley Harris
 *
 */
public class BSTTest {

	/**
	 * Tests add method with integers. 
	 */
	@Test
	public void testAddAndContains() {
		// Create empty BST
		BST<Integer> bst = new BST<>();
		assertEquals(0, bst.size());
		bst.add(15);
		assertEquals(1, bst.size());
		assertTrue(bst.contains(15));
		bst.add(8);
		assertEquals(2, bst.size());
		assertTrue(bst.contains(8));
		bst.add(18);
		assertEquals(3, bst.size());
		assertTrue(bst.contains(18));
	}
	
	/**
	 * Tests getMin method with integers.
	 */
	@Test
	public void testGetMin() {
		// create and setup bst 
		BST<Integer> bst = new BST<>();
		assertEquals(0, bst.size());
		bst.add(20);
		bst.add(15);
		bst.add(23);
		bst.add(28);
		bst.add(10);
		bst.add(17);
		bst.add(10);
		// test get min
		assertTrue(10 == bst.getMin());
		
		// test after adding new min
		bst.add(3);
		assertTrue(3 == bst.getMin());
	}
	
	/**
	 * Tests deleteMin method with integers.
	 */
	@Test
	public void testDeleteMin() {
		// create and setup bst 
		BST<Integer> bst = new BST<>();
		assertEquals(0, bst.size());
		bst.add(20);
		bst.add(10);
		bst.add(11);
		bst.add(25);
		bst.add(5);
		assertEquals(5, bst.size());
		
		// test delete min
		assertTrue(5 == bst.getMin());
		assertTrue(bst.contains(5));
		bst.deleteMin();
		assertFalse(bst.contains(5));
		assertEquals(4, bst.size());
		assertTrue(10 == bst.getMin());
		
		// test deleting again
		assertTrue(10 == bst.getMin());
		assertTrue(bst.contains(10));
		bst.deleteMin();
		assertFalse(bst.contains(10));
		assertEquals(3, bst.size());
		assertTrue(11 == bst.getMin());
		
		// test deleting again
		assertTrue(11 == bst.getMin());
		assertTrue(bst.contains(11));
		bst.deleteMin();
		assertFalse(bst.contains(11));
		assertEquals(2, bst.size());
		assertTrue(20 == bst.getMin());
		
		// test deleting again
		assertTrue(20 == bst.getMin());
		assertTrue(bst.contains(20));
		bst.deleteMin();
		assertFalse(bst.contains(20));
		assertEquals(1, bst.size());
		assertTrue(25 == bst.getMin());
		
		// test deleting again
		assertTrue(25 == bst.getMin());
		assertTrue(bst.contains(25));
		bst.deleteMin();
		assertFalse(bst.contains(25));
		assertEquals(0, bst.size());
	}
	
	/**
	 * Tests delete(data) method.
	 */
	@Test
	public void testDelete() {
		// create and setup bst
		BST<Integer> bst = new BST<>();
		assertEquals(0, bst.size());
		bst.add(20);
		bst.add(10);
		bst.add(11);
		bst.add(25);
		bst.add(5);
		assertEquals(5, bst.size());
		
		// test deleting node with no children
		bst.delete(5);
		assertEquals(4, bst.size());
		assertFalse(bst.contains(5));
		assertTrue(10 == bst.getMin());
		
		// test deleting node with one child
		bst.delete(10);
		assertEquals(3, bst.size());
		assertFalse(bst.contains(10));
		assertTrue(11 == bst.getMin());
		
		// test deleting node with two children
		bst.delete(20);
		assertEquals(2, bst.size());
		assertFalse(bst.contains(20));
		assertTrue(11 == bst.getMin());
		
	}
	

}
