package binarySearchTree;

public class BinarySearchTreeNode<E extends Comparable<E>> {
	private E element;
	private BinarySearchTreeNode<E> parent;
	private BinarySearchTreeNode<E> leftChild;
	private BinarySearchTreeNode<E> rightChild;
	
	public BinarySearchTreeNode() {}
	
	public BinarySearchTreeNode(E e) {
		setTreeNodeElement(e);
	}
	
	public void setTreeNodeElement(E e) {
		element = e;
	}
	
	public E getTreeNodeElement() {
		return element;
	}
	
	public void setParent(BinarySearchTreeNode<E> parent) {
		this.parent = parent;
	}
	
	public BinarySearchTreeNode<E> getParent() {
		return this.parent;
	}
	
	public void setLeftChildNode (BinarySearchTreeNode<E> current) {
		this.leftChild = current;
	}

	public BinarySearchTreeNode<E> getLeftChildNode () {
		return this.leftChild;
	}
	
	public void setRightChildNode (BinarySearchTreeNode<E> current) {
		this.rightChild = current;
	}

	public BinarySearchTreeNode<E> getRightChildNode () {
		return this.rightChild;
	}
	
}
