/**
 * @author dimitar
 *
 */
package lab;

import java.util.Arrays;
import java.util.Scanner;

public class L01BinarySearch {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

		int key = Integer.parseInt(scanner.nextLine());

//		System.out.println(indexOf(arr, key));
		System.out.println(indexOf(arr, key, 0, arr.length - 1));

	}

//	private static int indexOf(int[] arr, int key) {
//		
//		
//		int start = 0;
//		int end = arr.length-1;
//		
//		while(start <= end) {
//			
//			int mid = (start + end)/2;
//			int curr = arr[mid];
//			
//			if(key < curr) {
//				
//				end = mid -1;
//			}else if(key > curr){
//				start = mid + 1;
//			}else {
//				return mid;
//			}
//
//		}
//		
//
//		return -1;
//	}

	private static int indexOf(int[] arr, int key, int start, int end) {

		int mid = (start + end) / 2;
		int curr = arr[mid];

		if (start <= end) {

			if (key < curr) {

				return indexOf(arr, key, start, mid - 1);

			} else if (key > curr) {
				return indexOf(arr, key, mid + 1, end);

			} else {
				return mid;
			}
		}

		return -1;
	}

}
