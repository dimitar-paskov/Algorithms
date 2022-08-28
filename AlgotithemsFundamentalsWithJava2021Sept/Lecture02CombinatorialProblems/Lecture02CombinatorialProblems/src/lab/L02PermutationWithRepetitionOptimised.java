/**
 * @author dimitar
 *
 */
package lab;

import java.util.Arrays;
import java.util.Scanner;

public class L02PermutationWithRepetitionOptimised {
	
	// There is repetition in the elements in the set that we take from; example A B B 
	// A B' B" = A B" B' - this is not allowed as new permutation, because they are the same
	
	private static String[] arr; 


	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		arr = scanner.nextLine().split("\\s+");
		
		int[] arr = {3, 5, 1, 5, 5};
		Arrays.sort(arr);
		permuteRep(arr, 0, arr.length-1);


	}
	
	static void permuteRep(int[] arr, int start, int end) {
		  print(arr);
		  for (int left = end - 1; left >= start; left--)
		      for (int right = left + 1; right <= end; right++) {
		          if (arr[left] != arr[right]) {
		              swap(arr, left, right);
		              permuteRep(arr, left + 1, end);
		          }
		      int firstElement = arr[left];
		      for (int i = left; i <= end - 1; i++)
		          arr[i] = arr[i + 1];
		      arr[end] = firstElement;
		    }
		}

	private static void print(int[] arg) {
		for(int i=0; i < arg.length; i++) {
			System.out.print(arg[i] + " ");
		}
		System.out.println();
		 
	}
	
	private static void swap(int[] arr, int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
		
	}

}
