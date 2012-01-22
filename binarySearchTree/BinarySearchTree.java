package binarySearchTree;

import java.util.*;

public class BinarySearchTree <E extends Comparable<E>> {
	LinkedList<BinarySearchTreeNode<E>> list = new LinkedList<BinarySearchTreeNode<E>>();
	BinarySearchTreeNode<E> node = new BinarySearchTreeNode<E>();
	BinarySearchTreeNode<E> root;

	public boolean search(E e) {
		if (isEmpty(root)) {
			return false;
		} else {
			BinarySearchTreeNode<E> parent = null;
			BinarySearchTreeNode<E> current = root;
			current = searchElement(e, parent, current);
			parent = node.getParent();

			return match(e, current);
		}
	}

	public BinarySearchTreeNode<E> searchElement(E e, BinarySearchTreeNode<E> parent, BinarySearchTreeNode<E> current) {
		while (true) {
			if (e.compareTo(current.getTreeNodeElement()) < 0 && !isEmpty(current.getLeftChildNode())) {
				parent = current;
				current = current.getLeftChildNode();
			} else if (e.compareTo(current.getTreeNodeElement()) > 0 && !isEmpty(current.getRightChildNode())) {
				parent = current;
				current = current.getRightChildNode();
			} else {
				break;
			}
		}
		node = current;
		node.setParent(parent);
		return node;
	}

	public boolean match(E e, BinarySearchTreeNode<E> current) {
		if (e.equals(current.getTreeNodeElement())) {
			return true;
		} else {
			return false;
		}
	}

	public void insert(E e) {
		if (isEmpty(root)) {
			root = new BinarySearchTreeNode<E>(e);
		} else {
			BinarySearchTreeNode<E> parent = null;
			BinarySearchTreeNode<E> current = root;
			current = searchElement(e, parent, current);
			parent = node.getParent();
			if (!match(e, current)) {
				insert(e, parent, current);
			} else {
				return;
			}
		}
	}

	public void insert(E e, BinarySearchTreeNode<E> parent, BinarySearchTreeNode<E> current) {
		parent = current;
		current = (e.compareTo(current.getTreeNodeElement()) <= 0) ? current.getLeftChildNode() : current.getRightChildNode();
		current = new BinarySearchTreeNode<E>(e);
		if (e.compareTo(parent.getTreeNodeElement()) <= 0) {
			parent.setLeftChildNode(current);	
		} else {
			parent.setRightChildNode(current);
		}
	}

	public void delete(E e) {
		if (isEmpty(root)) {
			root = new BinarySearchTreeNode<E>(e);

		} else {
			BinarySearchTreeNode<E> parent = null;
			BinarySearchTreeNode<E> current = root;
			current = searchElement(e, parent, current);
			parent = node.getParent();

			if (match(e, current)) {
				executeDeleteElement(e, parent, current);
			}
		}
	}
	
	public void executeDeleteElement(E e, BinarySearchTreeNode<E> parent, BinarySearchTreeNode<E> current) {
		if (isEmpty(current.getLeftChildNode()) || isEmpty(current.getRightChildNode())) {
			if (e.compareTo(parent.getTreeNodeElement()) < 0) {
				parent.setLeftChildNode(null);
			} else {
				parent.setRightChildNode(null);
			}
		} else {
			if (isEmpty(current.getRightChildNode())) {
				parent.setRightChildNode(current.getLeftChildNode());
			} else {
				BinarySearchTreeNode<E> rightMost = current.getLeftChildNode();
				BinarySearchTreeNode<E> parentOfRightMost = current;
				while (rightMost.getRightChildNode() != null) {
					parentOfRightMost = rightMost;
					rightMost = rightMost.getRightChildNode();
				}
				rightMost.setLeftChildNode(current.getLeftChildNode());
				rightMost.setRightChildNode(current.getRightChildNode());
				parentOfRightMost.setRightChildNode(null);

				if (isEmpty(parent)) {
					root = rightMost;
				} else {
					parent.setRightChildNode(rightMost);
				}
			}
		}
	}

	public void preorder() {
		preorder(root);
		System.out.println();
	}

	public void preorder(BinarySearchTreeNode<E> treeNode){
		if (isEmpty(treeNode)) {
			return;
		}
		System.out.print(treeNode.getTreeNodeElement() + " "); 
		preorder(treeNode.getLeftChildNode());
		preorder(treeNode.getRightChildNode());
	}

	public void inorder() {
		inorder(root);
		System.out.println();
	}

	public void inorder(BinarySearchTreeNode<E> treeNode){
		if (isEmpty(treeNode)) {
			return;
		}
		inorder(treeNode.getLeftChildNode());
		System.out.print(treeNode.getTreeNodeElement() + " ");
		inorder(treeNode.getRightChildNode());
	}

	public void postorder() {
		postorder(root);
		System.out.println();
	}

	public void postorder(BinarySearchTreeNode<E> treeNode){
		if (isEmpty(treeNode)) {
			return;
		}
		postorder(treeNode.getLeftChildNode());
		postorder(treeNode.getRightChildNode());
		System.out.print(treeNode.getTreeNodeElement() + " "); 
	}


	public void breadthFirstTrabersal() {
		int count = 0;
		list.add(root);
		breadthFirstTrabersal(root, count);
		System.out.println();
	}


	public void breadthFirstTrabersal(BinarySearchTreeNode<E> treeNode, int count) {		
		if (!isEmpty(treeNode.getLeftChildNode())) {
			list.add(treeNode.getLeftChildNode());
		} 
		if (!isEmpty(treeNode.getRightChildNode())) {
			list.add(treeNode.getRightChildNode());
		}

		System.out.print(list.get(count).getTreeNodeElement() + " ");
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
}
