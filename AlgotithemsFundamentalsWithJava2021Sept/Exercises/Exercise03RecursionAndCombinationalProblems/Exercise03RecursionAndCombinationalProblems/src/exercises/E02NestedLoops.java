/**
 * @author dimitar
 *
 */
package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E02NestedLoops {
	
	private static int[] arr;
	
	private static int n;

	public static void main(String[] args) throws IOException {
		

//		for (int i = 1; i <= n; i++) {
//		for (int j = 1; j <= n; j++) {
//			for (int k = 1; k <= n; k++) {
//				
//				System.out.println(i + " " + j);
//			}
//			
//		}
//	}
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(reader.readLine());
		
		arr = new int[n];
		
		permute(0);


		

	}

	private static void permute(int index) {
		
		if(index == arr.length) {
			printArr();
		}else {
			
			for (int i = 1; i <= n; i++) {
				
				arr[index] = i;
				permute(index + 1);
			}
			
		}
		
		
		
	}

	private static void printArr() {
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
	}




	

}
