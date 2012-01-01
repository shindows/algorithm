package searching;

public class QuickSort {	
	public static void main(String[] args) {
		final int SIZE = 1000000;
		int[] list = new int[SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			list[i] = (int)(Math.random()*SIZE);
		}
		long startTime = System.currentTimeMillis();
		quickSort(list);
		//print(list);
		
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		
		System.out.println("ŽÀsŽžŠÔ : " + executionTime);
	}
	
	public static void quickSort(int[] list) {
		quickSort(list, 0, list.length - 1);
	}
	
	public static void quickSort(int[] list, int first, int last) {
		if (first < last) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}
	}
	
	public static int partition(int[] list, int first, int last) {
		int pivot = list[first];
		int front = first + 1;
		int back = last;
		
		while (front < back) {	
			while (front <= back && list[front] <= pivot) {
				front++;
			}
			while (front <= back && pivot < list[back]) {
				back--;
			}
			
			if (front < back) {
				int tmp = list[front];
				list[front] = list[back];
				list[back] = tmp;
			}
		}
		
		while (front > back) {
			if (list.length <= front) {
				front--;
			} else if (list[front] >= pivot) {
				front--;
			}
		}
		
		if (list[front] <= pivot) {
			list[first] = list[front];	
			list[front] = pivot;
		}
		return front;
	}

	public static void print(int[] list) {
		for (int j = 0; j < list.length; j++) {
			System.out.print(list[j] + " ");
		}
		System.out.println();
	}
}
