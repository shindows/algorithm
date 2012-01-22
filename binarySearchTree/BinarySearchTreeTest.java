package binarySearchTree;

import static org.junit.Assert.*;
import org.junit.*;
import org.apache.commons.lang3.RandomStringUtils;

public class BinarySearchTreeTest {

	@Test
	public void testInsertIntegertElement() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		int size = 10;
		int element = (int)(Math.random()*size);
		tree.insert(element);
		assertNotNull(tree);
		tree.breadthFirstTrabersal();
	}

	@Test
	public void testInsertStringElement() {
		BinarySearchTree<String> tree = new BinarySearchTree<String>();
		String element = RandomStringUtils.randomAlphanumeric(10);
		tree.insert(element);
		assertNotNull(tree);
		tree.breadthFirstTrabersal();
	}

	@Test
	public void testSearchElements() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		int size = 10;
		for (int j = 1; j < size; j++) {
			tree.insert((int)(Math.random()*size));
		}
		int searchElement = (int)(Math.random()*size);
		tree.insert(searchElement);

		System.out.print("探索値 " + searchElement + " : ");
		tree.breadthFirstTrabersal();

		assertTrue(tree.search(searchElement));
	}

	@Test
	public void testSearchNullTree() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		int size = 10;
		int searchElement = (int)(Math.random()*size);
		assertFalse(tree.search(searchElement));
	}

	@Test
	public void testDeleteElement() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		int size = 10;
		for (int j = 1; j < size; j++) {
			tree.insert((int)(Math.random()*size));
		}
		int deleteElement = (int)(Math.random()*size);
		
		tree.insert(deleteElement);
		assertTrue(tree.search(deleteElement));
		
		tree.delete(deleteElement);
		assertFalse(tree.search(deleteElement));
	}
	
	@Test
	public void testIteratorHasNext() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.insert(1);
		tree.insert(2);
		BinarySearchTreeIterator<Integer> iterator = new BinarySearchTreeIterator<Integer>(tree);
		
		System.out.println(iterator.next());
		assertTrue(iterator.hasNext());
		
		System.out.println(iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	@Test
	public void testIteratorNext() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		int size = 10;
		for (int j = 1; j < size; j++) {
			tree.insert((int)(Math.random()*size));
		}
		BinarySearchTreeIterator<Integer> iterator = new BinarySearchTreeIterator<Integer>(tree);
		while (iterator.hasNext()) {
			assertNotNull(iterator.next());
		}
	}
	
	@Test
	public void testIteratorRemove() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		int size = 10;
		for (int j = 1; j < size; j++) {
			tree.insert((int)(Math.random()*size));
		}
		BinarySearchTreeIterator<Integer> iterator = new BinarySearchTreeIterator<Integer>(tree);
		
		iterator.remove();
		assertTrue(iterator.list.isEmpty());
	}
}

