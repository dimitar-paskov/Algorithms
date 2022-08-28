/**
 * @author dimitar
 *
 */
package lab;

import java.util.Arrays;
import java.util.Random;

public class L995Shuffle {

	private static int[] counts;

	public static void main(String[] args) {

		int[] arr = { 13, 15, 12, 24, 59 };

		Arrays.sort(arr);

		getAsRandom(arr);

		for (int rand : arr) {
			System.out.println(rand + " ");
		}

	}

//	private static void getAsRandom(int[] arr) {
//
//		int[] result = new int[arr.length];
//
//		ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
//
//		for (int i = 0; i < result.length; i++) {
//
//			swap(arr, i, threadLocalRandom.nextInt(arr.length));
//
//		}
//
//		
//	}
	
	private static void getAsRandom(int[] arr) {

		Random random = new Random();

		for (int i = 0; i < arr.length; i++) {

			swap(arr, i, random.nextInt(arr.length));

		}

		
	}

	private static void swap(int[] arr, int i, int index) {

		int temp = arr[i];
		arr[i] = arr[index];
		arr[index] = temp;

	}

}
