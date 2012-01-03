package sorting;

public class BubbleSort {
	public static void main(String[] args) {
		final int SIZE = 1000000;
		int[] list = new int[SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			list[i] = (int)(Math.random()*SIZE);
		}
		
		long startTime = System.currentTimeMillis();
		
		for (int i = 1; i < list.length; i++) {
			for (int j = 0; j < list.length - i; j++) {
				if (list[j] > list[j + 1]) {
					int tmp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = tmp;
				}
			}
	}

		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		
		System.out.println("Execution time : " + executionTime);
	}
	
	public static void printList(int[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}
}
