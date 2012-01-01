package sorting;

public class MergeSort {
	public static void main(String[] args) {
		final int SIZE = 50000;
		int[] list = new int[SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			list[i] = (int)(Math.random()*SIZE);
		}
		long startTime = System.currentTimeMillis();
		
		mergeSort(list);
		
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		
		System.out.println("ŽÀsŽžŠÔ : " + executionTime);
		
	}

	private static int[] mergeSort(int[] list) {
		if (list.length == 1) {
			return list;
		}
		else {
			int[] left = new int[list.length / 2];
			for (int i = 0; i < left.length; i++) {
				left[i] = list[i];
			}
			int[] right = new int[list.length - left.length];
			for (int i = 0; i < right.length; i++) {
				right[i] = list[left.length + i];
			}
			
			left = mergeSort(left);
			//print(left);
			right = mergeSort(right);
			//print(right);

			merge(left, right, list);

			return list;
		}
	}

	public static int[] merge( int[] list1, int[] list2, int[] mergeList) {
		int indexMerge = 0;
		int index1 = 0;
		int index2 = 0;

		while (index1 < list1.length && index2 < list2.length) {
			if (list1[index1] <= list2[index2]) {
				mergeList[indexMerge++] = list1[index1++];
			} else {
				mergeList[indexMerge++] = list2[index2++];
			}
		}

		while (index1 < list1.length) {
			mergeList[indexMerge++] = list1[index1++];
		}

		while (index2 < list2.length) {
			mergeList[indexMerge++] = list2[index2++];
		}
		return mergeList;
	}

	public static void print(int[] list) {
		for (int j = 0; j < list.length; j++) {
			System.out.print(list[j] + " ");
		}
		System.out.println();
	}
}
