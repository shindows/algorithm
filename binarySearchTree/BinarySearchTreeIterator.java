package binarySearchTree;

import java.util.*;

public class BinarySearchTreeIterator<E extends Comparable<E>> implements java.util.Iterator<E> {	
	LinkedList<BinarySearchTreeNode<E>> list = new LinkedList<BinarySearchTreeNode<E>>();
	BinarySearchTree<E> tree;

	int current = 0;
	
	public BinarySearchTreeIterator(BinarySearchTree<E> tree) {
		this.tree = tree;
		breadthFirstTrabersal();
	}

	public void breadthFirstTrabersal() {
		int count = 0;
		list.add(tree.root);
		breadthFirstTrabersal(tree.root, count);
	}


	public void breadthFirstTrabersal(BinarySearchTreeNode<E> treeNode, int count) {		
		if (!isEmpty(treeNode.getLeftChildNode())) {
			list.add(treeNode.getLeftChildNode());
		} 
		if (!isEmpty(treeNode.getRightChildNode())) {
			list.add(treeNode.getRightChildNode());
		}
		
		count++;
		if(count == list.size() ) {
			return;
		}
		breadthFirstTrabersal(list.get(count), count);
	}
	
	public boolean isEmpty(BinarySearchTreeNode<E> treeNode) {
		if (treeNode == null) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean hasNext() {
		if (current < list.size()) {
			return true;
		}
		return false;
	}

	@Override
	public E next() {
		return list.get(current++).getTreeNodeElement();
	}

	@Override
	public void remove() {
		list.clear();
	}
}

