package searching;

import java.util.*;

public class BinarySearchTree <E extends Comparable<E>> {
	LinkedList<BinarySearchTreeNode<E>> list = new LinkedList<BinarySearchTreeNode<E>>();
	BinarySearchTreeNode<E> root;
	
	public void search(E e) {
		if (isEmpty(root)) {
			root = new BinarySearchTreeNode<E>(e);
		} else {
			BinarySearchTreeNode<E> parent = null;
			BinarySearchTreeNode<E> current = root;
			search(e, parent, current);
		}
	}

	public void search(E e, BinarySearchTreeNode<E> parent, BinarySearchTreeNode<E> current) {
		if (e.equals(current.getTreeNodeElement())) {
			System.out.println(e + " ÅÀ íTçıê¨å˜");
			return;
		} else if (e.compareTo(current.getTreeNodeElement()) <= 0 && !childOfTreeNodesIsEmpty(current)) {
			search(e, current, current.getLeftChildNode());	
		} else if (e.compareTo(current.getTreeNodeElement()) > 0 && !childOfTreeNodesIsEmpty(current)) {
			search(e, current, current.getRightChildNode());
		} 
	}

	public void insert(E e) {
		if (isEmpty(root)) {
			root = new BinarySearchTreeNode<E>(e);
		} else {
			BinarySearchTreeNode<E> parent = null;
			BinarySearchTreeNode<E> current = root;
			insert(e, parent, current);	
		}
	}

	public void insert(E e, BinarySearchTreeNode<E> parent, BinarySearchTreeNode<E> current) {
		if (e.equals(current.getTreeNodeElement())) {
			return;
		} else {
			parent = current;
			current = (e.compareTo(current.getTreeNodeElement()) <= 0) ? current.getLeftChildNode() : current.getRightChildNode();
			if (isEmpty(current)) {
				current = new BinarySearchTreeNode<E>(e);
				if (e.compareTo(parent.getTreeNodeElement()) <= 0) {
					parent.setLeftChildNode(current);	
				} else {
					parent.setRightChildNode(current);
				}
			} else {
				insert(e, parent, current);
			}
		}
	}


	public void delete(E e) {
		if (isEmpty(root)) {
			root = new BinarySearchTreeNode<E>(e);
			
		} else {
			BinarySearchTreeNode<E> parent = null;
			BinarySearchTreeNode<E> current = root;
			searchDeleteElemente(e, parent, current);
		}
	}
	
	public void searchDeleteElemente(E e, BinarySearchTreeNode<E> parent, BinarySearchTreeNode<E> current) {
		if (e.equals(current.getTreeNodeElement())) {
			executeDeleteElement(e, parent, current);
		} else if (e.compareTo(current.getTreeNodeElement()) <= 0 && !childOfTreeNodesIsEmpty(current)) {
			searchDeleteElemente(e, current, current.getLeftChildNode());
		} else if (e.compareTo(current.getTreeNodeElement()) > 0 && !childOfTreeNodesIsEmpty(current)) {
			searchDeleteElemente(e, current, current.getRightChildNode());
		} 	
	}
	
	public void executeDeleteElement(E e, BinarySearchTreeNode<E> parent, BinarySearchTreeNode<E> current) {
		if (childOfTreeNodesIsEmpty(current)) {
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
		list.add(root);
		breadthFirstTrabersal(root);
	}
	
	
	public void breadthFirstTrabersal(BinarySearchTreeNode<E> treeNode) {		
		if (!isEmpty(treeNode.getLeftChildNode())) {
			list.add(treeNode.getLeftChildNode());
		} 
		if (!isEmpty(treeNode.getRightChildNode())) {
			list.add(treeNode.getRightChildNode());
		}
		
		System.out.print(list.removeFirst().getTreeNodeElement() + " ");
		if(list.isEmpty()) {
			return;
		}
		breadthFirstTrabersal(list.getFirst());
	}
/*	
	public boolean elementLtTreeNode (E e, BinarySearchTreeNode<E> current) {
		if (e.compareTo(current.getTreeNodeElement()) < 0) {
			return true;
		}
		return false;	
	}

	public boolean elementEqualTreeNode (E e, BinarySearchTreeNode<E> current) {
		if (e.equals(current.getTreeNodeElement())) {
			return true;
		}
		return false;	
	}
	*/
	public boolean isEmpty(BinarySearchTreeNode<E> treeNode) {
		if (treeNode == null) {
			return true;
		}
		return false;
	}
	
	public boolean childOfTreeNodesIsEmpty(BinarySearchTreeNode<E> treeNode) {
		if (treeNode.getLeftChildNode() == null && treeNode.getRightChildNode() == null) {
			return true;
		}
		return false;
	}
}
