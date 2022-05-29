/**
 * @author dimitar
 *
 */
package lab;

import java.util.Scanner;

public class E03GeneratingVectors {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		
//		Integer[] memory = new Integer[n];
//		
//		fillVector(memory, memory.length-1);
//		
//
//	}
//
//	private static void fillVector(Integer[] memory, int index) {
//		
//		if(index < 0) {
//			print(memory);
//			return;
//		}
//		
//		for (int i = 0; i <= 1; i++) {
//			memory[index]=i;
//			fillVector(memory, index -1);
//		}
//		
//		
//	}
		
		Integer[] memory = new Integer[n];
		
		fillVector(memory, 0);
		

	}

	private static void fillVector(Integer[] memory, int index) {
		
		if(index >= memory.length) {
			print(memory);
			return;
		}
		
		for (int i = 0; i <= 1; i++) {
			memory[index]=i;
			fillVector(memory, index +1);
		}
		
		
	}

	private static void print(Integer[] memory) {
		
		for (Integer integer : memory) {
			System.out.print(integer);
		}
		System.out.println();
		
	}

}
