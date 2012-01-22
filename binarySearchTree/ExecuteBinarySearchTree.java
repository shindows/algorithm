package binarySearchTree;

public class ExecuteBinarySearchTree {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		int size = 10;
		for (int j = 1; j < size; j++) {
			tree.insert((int)(Math.random()*size));
		}
		
		int search = (int)(Math.random()*size);
	
		System.out.println("探索値 " + search + " : " );
		tree.search(search);
		
		System.out.println("前順 (preorder) : ");
		tree.preorder();
		
		System.out.println("間順 (inorder) : ");
		tree.inorder();
		
		System.out.println("降順 (postorder) : ");
		tree.postorder();
		
		System.out.println("幅優先探索 : ");
		tree.breadthFirstTrabersal();
		
		System.out.println("Iterator Test : ");
		
		BinarySearchTreeIterator<Integer> iterator = new BinarySearchTreeIterator<Integer>(tree);
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}
}
