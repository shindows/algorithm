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
	
		System.out.println("�O�� (preorder) : ");
		tree.preorder();
		
		System.out.println("�ԏ� (inorder) : ");
		tree.inorder();
		
		System.out.println("�㏇ (postorder) : ");
		tree.postorder();
		
		System.out.println("���D��T�� : ");
		tree.breadthFirstTrabersal();
		
		System.out.println("�T���l " + search + " : " );
		tree.search(search);
	}
}
