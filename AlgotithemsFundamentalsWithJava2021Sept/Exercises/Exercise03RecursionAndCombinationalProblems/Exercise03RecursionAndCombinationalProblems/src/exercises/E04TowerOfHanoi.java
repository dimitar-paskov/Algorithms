/**
 * @author dimitar
 *
 */
package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E04TowerOfHanoi {
	
	private static int[] kSlot;
	


	public static void main(String[] args) throws IOException {
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n  = Integer.parseInt(reader.readLine());
		int k  = Integer.parseInt(reader.readLine());
				
		kSlot = new int[k];
		

	}

	
	private static void printArr() {
		
		for (int i = 0; i < kSlot.length; i++) {
			System.out.print(kSlot[i] + " ");
		}
		System.out.println();
		
	}

}
