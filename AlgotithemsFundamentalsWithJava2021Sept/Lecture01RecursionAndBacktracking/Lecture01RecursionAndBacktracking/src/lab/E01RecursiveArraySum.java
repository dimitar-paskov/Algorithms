/**
 * @author dimitar
 *
 */
package lab;

import java.util.Arrays;
import java.util.Scanner;

public class E01RecursiveArraySum {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int arr[] = Arrays.stream(scanner.nextLine().split("\\s+"))
				.mapToInt(Integer::parseInt)
				.toArray();
 		
//		Iteractive
//		int sum = 0;
//		
//		for (int i = 0; i < arr.length; i++) {
//			sum += arr[i];
//		}
//		System.out.println(sum);
		
		
//		int sumRecursiveP = sumNumbersP(arr, 0);
//		System.out.println(sumRecursiveP);
		
		int sumRecursiveM = sumNumbersM(arr, arr.length-1);
		System.out.println(sumRecursiveM);
		
		

	}
	
//	Recursive equivalent to for with i++
	private static int sumNumbersP(int[] numbers, int index) {
		
		if(index >= numbers.length) {
			return 0;
		}
		
		return numbers[index] + sumNumbersP(numbers, index + 1); 
	}
	
//	Recursive equivalent to for with i--
	private static int sumNumbersM(int[] numbers, int index) {
	
	if(index < 0) {
		return 0;
	}
	
	return numbers[index] + sumNumbersM(numbers, index - 1); 
}
	
//	Recursive other
	private static int sumRec(int[] numbers, int index) {
	
	if(index == numbers.length -1) {
		return numbers[index];
	}
	
	return numbers[index] + sumRec(numbers, index - 1); 
}
	
	

}
