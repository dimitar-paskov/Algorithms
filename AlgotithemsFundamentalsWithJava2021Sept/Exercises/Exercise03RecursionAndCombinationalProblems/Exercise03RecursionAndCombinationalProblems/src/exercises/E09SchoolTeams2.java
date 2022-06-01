/**
 * @author dimitar
 *
 */
package exercises;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E09SchoolTeams2 {

	private static String[] girls;
	private static String[] girlsCombinations = new String[3];
	private static String[] boys;
	private static String[] boysCombinations = new String[2];
	
	private static List<String> allGirsl = new ArrayList<>();
	private static List<String> allBoys = new ArrayList<>();

	private static List<List<String>> girlCombinations = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);

		girls = scanner.nextLine().split(", ");
		boys = scanner.nextLine().split(", ");

		combineGirls(0, 0);
		combineBoys(0, 0);
		
		for (String girls : allGirsl) {
			for (String boys : allBoys) {
				
				System.out.println(girls + ", " + boys );
				
				
			}
			
			
		}

	}

	private static void combineGirls(int index, int start) {

		if (index == girlsCombinations.length) {
			allGirsl.add(String.join(", ", girlsCombinations)); 
		} else {
			for (int i = start; i < girls.length; i++) {

				girlsCombinations[index] = girls[i];
				combineGirls(index + 1, i + 1);

			}
		}

	}
	
	private static void combineBoys(int index, int start) {

		if (index == boysCombinations.length) {
			allBoys.add(String.join(", ", boysCombinations)); 
		} else {
			for (int i = start; i < boys.length; i++) {

				boysCombinations[index] = boys[i];
				combineBoys(index + 1, i + 1);
				
			}
		}

	}
	
	

}
