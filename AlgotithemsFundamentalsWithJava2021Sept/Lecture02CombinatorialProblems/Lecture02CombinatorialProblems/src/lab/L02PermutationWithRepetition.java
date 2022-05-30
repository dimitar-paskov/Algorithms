/**
 * @author dimitar
 *
 */
package lab;

import java.util.HashSet;
import java.util.Scanner;

public class L02PermutationWithRepetition {
	
	// There is repetition in the elements in the set that we take from; example A B B 
	// A B' B" = A B" B' - this is not allowed as new permutation, because they are the same
	
	private static String[] elements; 


	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		elements = scanner.nextLine().split("\\s+");
		
		permuteWithRepetitions(0); 

	}
	
	public static void permuteWithRepetitions(int index) {
	    if (index >= elements.length) {
	    	print(elements);
	    } else {
	        permuteWithRepetitions(index + 1);
	        HashSet<String> swapped = new HashSet<>();
	        swapped.add(elements[index]);
	        for (int i = index + 1; i < elements.length; i++) {
	            if (!swapped.contains(elements[i])) {
	                swap(elements,index, i);
	                permuteWithRepetitions(index + 1);
	                swap(elements,index, i);
	                swapped.add(elements[i]);
	            }
	        }
	    }
	}

	private static void print(String[] arg) {
		System.out.println(String.join(" ", arg));
		 
	}
	
	private static void swap(String[] arr, int first, int second) {
		String temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
		
	}

}
