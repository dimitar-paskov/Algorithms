/**
 * @author dimitar
 *
 */
package lab;

import java.util.Arrays;
import java.util.Scanner;

public class E07RecursiveFibonacci {

	private static long[] arr;

	private static long fibonacci(int n) {
		if (n <= 1) {
			return 1;
		}

		if (arr[n] != -1) {
			return arr[n];
		}
		
		long result = fibonacci(n - 1) + fibonacci(n - 2);
		arr[n] = result;

		return result;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		arr = new long[n+1];
		Arrays.fill(arr, -1);

		System.out.println(fibonacci(n)); // 89
//	    System.out.println(fibonacci(50)); // This will hang!
	}

}
