/**
 * @author dimitar
 *
 */
package exercises;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E07Cinema {

	public static void main(String[] args) throws IOException {

		String[] names;

		Map<String, Integer> reserved = new HashMap<>();

		Scanner scanner = new Scanner(System.in);

		names = scanner.nextLine().split(", ");

		String line = scanner.nextLine();

		while (!"generate".equals(line)) {

			String[] tokens = line.split(" - ");

			reserved.put(tokens[0], Integer.parseInt(tokens[1]));
			
			line = scanner.nextLine();

		}
		
		String[] noReserved = new String[names.length - reserved.size()];
		String[] perm = new String[names.length - reserved.size()];
		boolean[] used = new boolean[names.length - reserved.size()];
		int j = 0;
		for (int i = 0; i < names.length; i++) { 
			if(!reserved.containsKey(names[i]) ) {
				noReserved[j++] = names[i];
			}
		}
		
		permute(0,noReserved,used, perm,reserved );
		
		

	}
	
	public static void permute(int index, String[] noReserved, boolean[] used,String[] perm, Map<String, Integer> reserved) {
	    if (index == noReserved.length) {
	        print(noReserved,used, perm,reserved);
	    } else {
	        for (int i = 0; i < noReserved.length; i++) {
	            if (!used[i]) {
	                used[i] = true;
	                perm[index] = noReserved[i];
	                permute(index + 1,noReserved,used, perm,reserved);
	                used[i] = false;
	            }
	        }
	    }
	}
	
	private static void print(String[] noReserved, boolean[] used,String[] perm, Map<String, Integer> reserved) {
		
		String[] print = new String[reserved.size() + noReserved.length];
		
		int j = 0;
		for (int i = 0; i < reserved.size() + noReserved.length; i++) {
			
			for (String key : reserved.keySet() ) {
				if(reserved.get(key)== i+1) {
					print[i] = key;
					break;
				}
				
			}
			
			if(print[i]!= null) {
				continue;
			}
			
			print[i]=perm[j++];
			
		}
		
		System.out.println(String.join(" ", print));
		 
	}

}
