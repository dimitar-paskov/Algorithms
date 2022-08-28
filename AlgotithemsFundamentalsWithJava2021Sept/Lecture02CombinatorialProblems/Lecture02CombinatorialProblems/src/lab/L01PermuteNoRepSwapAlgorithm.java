/**
 * @author dimitar
 *
 */
package lab;

import java.util.Scanner;

public class L01PermuteNoRepSwapAlgorithm {
	
	private static String[] elements; 

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		elements = scanner.nextLine().split("\\s+");

		permute(0);

	}

	public static void permute(int index) {
		if (index == elements.length) {
			print(elements);
		} else {
			permute(index + 1);
			for (int i = index + 1; i < elements.length; i++) {
				swap(elements,index, i);
				permute(index + 1);
				swap(elements,index, i);
			}
		}
	}
	
	
	private static void swap(String[] arr, int first, int second) {
		String temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
		
	}

	private static void print(String[] arg) {
		System.out.println(String.join(" ", arg));
		 
	}

}
