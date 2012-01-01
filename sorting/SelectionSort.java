package sorting;

public class SelectionSort {
	public static void main(String[] args) {
		final int SIZE = 1000000;
		int[] list = new int[SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			list[i] = (int)(Math.random()*SIZE);
		}
		
		long startTime = System.currentTimeMillis();
		
		
		for (int i = list.length - 1; i >= 1; i--) {
			int currentMax = list[0];
			int currentMaxIndex = 0;
			
			for (int j = 0; j <= i; j++) {
				if (currentMax < list[j]) {
					currentMax = list[j];
					currentMaxIndex = j;
				}
			}
			
			if (currentMax != list[i]) {
				list[currentMaxIndex] = list[i];
				list[i] = currentMax;
			}
			
		}
		//printList(list);
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
