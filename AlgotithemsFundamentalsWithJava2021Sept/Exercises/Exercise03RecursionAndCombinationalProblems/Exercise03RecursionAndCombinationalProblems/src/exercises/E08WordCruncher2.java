/**
 * @author dimitar
 *
 */
package exercises;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class E08WordCruncher2 {

	private static List<String> words;
	private static List<String> combined = new ArrayList<>();
	private static String target;
	private static Map<Integer, List<String>> table = new HashMap<>();
	private static Map<String, Integer> occurrences = new HashMap<>();
	private static Set<String> out = new TreeSet<>();

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);

		words = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

		target = scanner.nextLine();

		words.removeIf(next -> !target.contains(next));

		for (String substr : words) {

			occurrences.putIfAbsent(substr, 0);
			occurrences.put(substr, occurrences.get(substr) + 1);

			int index = target.indexOf(substr);

			while (index != -1) {

				table.putIfAbsent(index, new ArrayList<>());
				table.get(index).add(substr);

				index = target.indexOf(substr, index + 1);
			}
		}

		permute(0);
		
		for (String str : out) {
			System.out.println(str); 
			
		}

	}

	public static void permute(int index) {
		if (index == target.length()) {
			print();
		} else if (table.containsKey(index)) {

			List<String> strings = table.get(index);

			for (String str : strings) {

				if (occurrences.get(str) > 0) {
					occurrences.put(str, occurrences.get(str)-1);
					combined.add(str);
					permute(index + str.length());
					combined.remove(combined.size() - 1);
					occurrences.put(str, occurrences.get(str)+1);
					
				}

			}
		}

	}

	private static void print() {

		String actual = String.join("", combined);
		if (actual.contains(target)) {
			out.add(String.join(" ", combined)); 
		}

	}

}
