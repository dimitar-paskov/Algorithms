/**
 * @author dimitar
 *
 */
package lab;

import java.util.Arrays;
import java.util.Scanner;

public class L999SelectionSort {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

//		Arrays.stream(selectionSort(arr)).forEach(System.out::print); 
		Arrays.stream(selectionSort(arr)).forEach(e -> System.out.print(e + " ")); 

	}

	private static int[] selectionSort(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			int index = i;
			
			for (int j = i+1; j < arr.length; j++) {
				if(arr[j]< arr[index]) {
					index = j;
				}
			}
			
			swap(arr, i, index);
			
		}
		

		return arr;
	}

	private static void swap(int[] arr, int i, int index) { 
		
		int temp = arr[i];
		arr[i]= arr[index];
		arr[index]= temp;
		
	}

}
