/**
 * @author dimitar
 *
 */
package lab;

import java.util.Arrays;
import java.util.Collections;

public class L996CountSort {
	
	private static int[] counts;

	public static void main(String[] args) {

		

		int[] arr = {13,5,2,2,5};
		
		int max= Collections.max(Arrays.asList(13,5,2,2,5));
		
		counts = new int[max+1];
		countSort(arr);
		
		for(int index = 0; index < counts.length; index++) {
			if(counts[index] != 0) {
				for (int i = 0; i < counts[index]; i++) {
					System.out.print(index + " ");
				}
			}
		}

	}

	private static int[] countSort(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			
			counts[arr[i]]++;

		}
		

		return arr;
	}


}
