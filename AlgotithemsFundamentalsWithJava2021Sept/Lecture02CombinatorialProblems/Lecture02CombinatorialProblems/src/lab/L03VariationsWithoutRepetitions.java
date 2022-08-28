/**
 * @author dimitar
 *
 */
package lab;

import java.util.Scanner;

public class L03VariationsWithoutRepetitions {
	
	private static String[] elements; 
	private static String[] kSlots;  
	private static boolean[] used;

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		elements = scanner.nextLine().split("\\s+");
		 
		used = new boolean[elements.length];
		
		int k = Integer.parseInt(scanner.nextLine());
		
		kSlots = new String[k];
		
		
		variations(0); 

	}
	

	public static void variations(int index) {
	    if (index >= kSlots.length) {
	    	print( kSlots);
	    } else {
	        for (int i = 0; i < elements.length; i++) {
	            if (!used[i]) {
	                used[i] = true;
	                kSlots[index] = elements[i];
	                variations(index + 1);
	                used[i] = false;
	            }
	        }
	    }
	}

	private static void print(String[] arg) {
		System.out.println(String.join(" ", arg));
		 
	}

}
