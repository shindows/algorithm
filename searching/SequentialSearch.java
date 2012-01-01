package searching;

//import java.util.StringTokenizer;
import java.io.*;


public class SequentialSearch {
	public static void main(String[] args) {

		for (int i = 1; i < 10; i++) {
			int size = 10000000;   
			size = size * i;

			int[] list = getRandomList(size);
			int element = getRandomElement(size);

			long startTime = System.currentTimeMillis();

			System.out.print("SIZE : " + size + " , ");
			sequentialSearch(list, element);

			long endTime = System.currentTimeMillis();
			long executionTime = endTime - startTime;

			System.out.println("ŽÀsŽžŠÔ : " + executionTime);

			// write csv
			try {
				File csv = new File("writers.csv");
				BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); 
				bw.write(size + "," + executionTime);
				bw.newLine();
				bw.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
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

	public static boolean sequentialSearch(int[] list, int element) {
		for (int i = 0; i < list.length; i++) {
			if (list[i] == element) {
				System.out.print("Search success, ");
				return true;
			}
		}
		System.out.print("Search not success, ");
		return false;
	}

}
