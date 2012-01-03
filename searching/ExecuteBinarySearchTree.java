package searching;


public class ExecuteBinarySearchTree {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		int size = 10;
		for (int j = 1; j < size; j++) {
			tree.insert((int)(Math.random()*size));
		}
		
		int search = (int)(Math.random()*size);
	
		System.out.println("‘O‡ (preorder) : ");
		tree.preorder();
		
		System.out.println("ŠÔ‡ (inorder) : ");
		tree.inorder();
		
		System.out.println("Œã‡ (postorder) : ");
		tree.postorder();
		
		System.out.println("•—Dæ’Tõ : ");
		tree.breadthFirstTrabersal();
		
		System.out.println("’Tõ’l " + search + " : " );
		tree.search(search);
	}
}
