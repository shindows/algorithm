package searching;


public class ExecuteBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		int size = 100000;
		for (int j = 1; j < size; j++) {
			tree.insert((int)(Math.random()*size));
		}
		tree.search((int)(Math.random()*size));
	}
}
