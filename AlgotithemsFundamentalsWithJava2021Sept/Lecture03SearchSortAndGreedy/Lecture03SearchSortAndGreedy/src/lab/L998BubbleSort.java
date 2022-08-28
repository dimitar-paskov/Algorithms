/**
 * @author dimitar
 *
 */
package lab;

import java.util.Arrays;
import java.util.Scanner;

public class L998BubbleSort {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

//		Arrays.stream(selectionSort(arr)).forEach(System.out::print); 
		Arrays.stream(bubbleSort(arr)).forEach(e -> System.out.print(e + " ")); 

	}

	private static int[] bubbleSort(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = i+1; j < arr.length ; j++) {
				if(arr[j] > arr[i]) {
					swap(arr, i, j);
				}
			}

		}
		

		return arr;
	}

	private static void swap(int[] arr, int i, int index) { 
		
		int temp = arr[i];
		arr[i]= arr[index];
		arr[index]= temp;
		
	}

}
