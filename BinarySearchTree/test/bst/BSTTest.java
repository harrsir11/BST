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
	public void testAddAndGet() {
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

}
