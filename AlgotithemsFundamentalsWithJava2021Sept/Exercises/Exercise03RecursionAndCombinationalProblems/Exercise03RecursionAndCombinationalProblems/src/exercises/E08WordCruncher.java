/**
 * @author dimitar
 *
 */
package exercises;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E08WordCruncher {
	
	private static boolean[] used;
	private static List<String>result = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		List<String> chunks;

		Scanner scanner = new Scanner(System.in);

		chunks = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

		String target = scanner.nextLine();

		for (int i = 0; i < chunks.size(); i++) {
			if (target.indexOf(chunks.get(i)) < 0) {

				chunks.remove(i);
				i--;
			}
		}
		
		used = new boolean[chunks.size()];

		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		permute(0, chunks, target, sb,sb2);

	}

	public static void permute(int index, List<String> chunks, String target,StringBuilder sb, StringBuilder sb2) {
		
		if (target.equals(sb.toString())) {
			
			if(!result.contains(sb2.toString().trim())) {
				result.add(sb2.toString().trim());
				System.out.println(sb2.toString().trim());
			}
			
		}else if(!target.startsWith(sb.toString())) {
			return;
		}else {
			for (int i = 0; i < chunks.size(); i++) {
				
				if (!used[i]) {
	                used[i] = true;
	                sb.append(chunks.get(i));
	                sb2.append(chunks.get(i)+" ");
 	                permute(index + 1, chunks, target,sb,sb2);
	                used[i] = false;
	                sb.delete(sb.length() - chunks.get(i).length(), sb.length());
	                sb2.delete(sb2.length() - chunks.get(i).length()-1, sb2.length());
	                
	            }

			}
		}
	}



}
