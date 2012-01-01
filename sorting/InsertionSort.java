package sorting;

public class InsertionSort {
	public static void main(String[] args) {
		final int SIZE = 1000000;
		int[] list = new int[SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			list[i] = (int)(Math.random()*SIZE);
		}
		
		long startTime = System.currentTimeMillis();
		
		for (int j = 1; j < list.length; j++) {
			int currentElement = list[j];
			int k;
			for (k = j - 1; k >= 0 && list[k] > currentElement; k--) {
				list[k + 1] = list[k];
			}
			list[k + 1] = currentElement;
		}
		//print(list);
		
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		
		System.out.println("é¿çséûä‘ : " + executionTime);
	}
	
	public static void print(int[] list) {
		for (int j = 0; j < list.length; j++) {
			System.out.print(list[j] + " ");
		}
		System.out.println();
	}
}
