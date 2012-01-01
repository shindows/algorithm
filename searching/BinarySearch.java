package searching;

public class BinarySearch {
	public static void main(String[] args) {

		for (int i = 1; i < 10; i++) {
			int size = 10000000;
			size = size * i;
			
			int[] list = getRandomList(size);
			int element = getRandomElement(size);

			QuickSort.quickSort(list);

			double startTime = System.currentTimeMillis();

			System.out.print("SIZE : " + size + " , ");
			binarySearch(list, element);
			
			double endTime = System.currentTimeMillis();
			double executionTime = endTime - startTime;
			
			System.out.println("ŽÀsŽžŠÔ : " + executionTime);
			
		}
	}

	public static int[] getRandomList(int size) {
		int[] list = new int[size];
		for (int j = 0; j < size; j++) {
			list[j] = (int)(Math.random()*size);
		}
		return list;
	}

	public static int getRandomElement(int size) {
		int element = (int)(Math.random()*size);
		return element;
	}

	public static boolean binarySearch(int[] list, int element) {
		int low = 0;
		int high = list.length - 1;
		int i = 0;
		
		while (low <= high) {
			int middle = (low + high) / 2;
			if (list[middle] == element) {
				System.out.print(i + ", ’Tõ¬Œ÷, ");
				return true;
			} else if (list[middle] < element) {
				low = middle + 1;
			} else {
				high = middle - 1;
			}
			i++;
		}
		System.out.print(i + ", ’TõŽ¸”s, ");
		return false;
	}
}