/**
 * @author dimitar
 *
 */
package lab;

import java.util.Scanner;

public class L04VariationsWithRepetitions {
	
	private static String[] elements;  
	private static String[] kSlots;  


	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		elements = scanner.nextLine().split("\\s+");
		
		int k = Integer.parseInt(scanner.nextLine());
		
		kSlots = new String[k];
		
		
		variations(0); 
		
		//Iterative Variant
//		int n = 5;
//		int k = 3;
//		int[] arr = new int[k];
//		while (true) {
//			  print(arr);
//			  int index = k - 1;
//			  while (index >= 0 && arr[index] == n-1)
//			    index--;
//			  if (index < 0)
//			    break;
//			  arr[index]++;
//			  for (int i = index + 1; i < k; i++)
//			    arr[i] = 0;
//			}

	}


	
	public static void variations(int index) {
	    if (index == kSlots.length) {
	    	 print(kSlots);
	    } else {
	        for (int i = 0; i < elements.length; i++) {

	                kSlots[index] = elements[i];
	                variations(index + 1);

	        }
	    }
	}

	private static void print(String[] arg) {
		System.out.println(String.join(" ", arg));
		 
	}

}
