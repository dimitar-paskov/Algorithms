/**
 * @author dimitar
 *
 */
package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E05CombinationsWithoutRepetitions2 {
	
	private static int[] kSlot;
	


	public static void main(String[] args) throws IOException {
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n  = Integer.parseInt(reader.readLine());
		int k  = Integer.parseInt(reader.readLine());
				
		kSlot = new int[k];
		combine(n, k, 0, 1);


		

	}

	private static void combine(int n, int k, int index,int start) {
		
		if(index == k) {
			printArr();
		}else {
			
			for (int i = start; i <= n; i++) {
				
				kSlot[index] = i;
				combine(n,k,index + 1,i+1);
			}
			
		}
		
		
		
	}

	private static void printArr() {
		
		for (int i = 0; i < kSlot.length; i++) {
			System.out.print(kSlot[i] + " ");
		}
		System.out.println();
		
	}

}
