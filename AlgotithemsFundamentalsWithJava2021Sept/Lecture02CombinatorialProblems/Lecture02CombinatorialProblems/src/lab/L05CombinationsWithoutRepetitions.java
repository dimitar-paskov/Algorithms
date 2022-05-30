/**
 * @author dimitar
 *
 */
package lab;

import java.util.Scanner;

public class L05CombinationsWithoutRepetitions {
	
	private static String[] elements; 
	private static String[] kSlots;  

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		elements = scanner.nextLine().split("\\s+");

		int k = Integer.parseInt(scanner.nextLine());
		
		kSlots = new String[k];
		
		
		comb(0,0); 

	}

	public static void comb(int index, int start) {
	    if (index >= kSlots.length) {
	        print(kSlots);
	    } else {
	        for (int i = start; i < elements.length; i++) {
	            kSlots[index] = elements[i];
	            comb(index + 1, i + 1);
	        }
	    }
	}


	private static void print(String[] arg) {
		System.out.println(String.join(" ", arg));
		 
	}

}
