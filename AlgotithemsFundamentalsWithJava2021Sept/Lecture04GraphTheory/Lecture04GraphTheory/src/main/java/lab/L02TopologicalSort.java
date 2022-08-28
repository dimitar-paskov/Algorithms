package lab;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class L02TopologicalSort {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());

		List<List<Integer>> graph = new ArrayList<>();

		for (int i = 0; i < n; i++) {

			String nextLine = scanner.nextLine();

			if (nextLine.trim().equals("")) {
				graph.add(new ArrayList<>());
			} else {

				List<Integer> nextNodes = Arrays.stream(nextLine.split("\\s+")).map(Integer::parseInt)
						.collect(Collectors.toList());

				graph.add(nextNodes);
			}
		}

		List<Deque<Integer>> connectedComponents = getConnectedComponents(graph);

		for (Deque<Integer> connectedComponent : connectedComponents) {
			System.out.print("Connected component: ");

			for (int integer : connectedComponent) {
				System.out.print(integer + " ");
			}

			System.out.println();

		}
	}

	public static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {

		

		return null;

	}


//  topSort with BFS
//	public static Collection<String> topSort(Map<String, List<String>> graph) {
//
//		Map<String, Integer> dependenciesCount = getDependenciesCount(graph);
//		
//		List<String> sorted = new ArrayList<>();
//		
//		while(!graph.isEmpty()) {
//			
//			String key = graph.keySet().stream()
//					.filter(k -> dependenciesCount.get(k) == 0)
//					.findFirst()
//					.orElse(null);
//			
//			if(key == null) {
//				break;
//			}
//			
//			
//			for (String child : graph.get(key)) {
//				
//				dependenciesCount.put(child, dependenciesCount.get(child)-1);
//				
//			}
//			
//			
//			sorted.add(key);
//			graph.remove(key);
//			
//		}
//		
//		if(!graph.isEmpty()) {
//			throw new IllegalArgumentException();
//		}
//		
//		
//		return sorted;
//
//	}
//
//	private static Map<String, Integer> getDependenciesCount(Map<String, List<String>> graph) {
//
//		Map<String, Integer> dependenciesCount = new LinkedHashMap<>();
//
//		for (Map.Entry<String, List<String>> node : graph.entrySet()) {
//			dependenciesCount.putIfAbsent(node.getKey(), 0);
//
//			for (String child : node.getValue()) {
//				dependenciesCount.putIfAbsent(child, 0);
//
//				dependenciesCount.put(child, dependenciesCount.get(child) + 1);
//
//			}
//		}
//		
//		return dependenciesCount;
//	}

//  topSort with DFS
	public static Collection<String> topSort(Map<String, List<String>> graph) {

		List<String> sorted = new ArrayList<>();

		Set<String> visited = new HashSet<>();
		Set<String> detectCycles = new HashSet<>();

		for (Map.Entry<String, List<String>> node : graph.entrySet()) {

			dfs(node.getKey(), visited, graph, sorted, detectCycles);

		}

		Collections.reverse(sorted);

		return sorted;

	}

	private static void dfs(String key, Set<String> visited, Map<String, List<String>> graph, List<String> sorted,
			Set<String> detectCycles) {

		if (detectCycles.contains(key)) {
			throw new IllegalArgumentException();
		}

		if (!visited.contains(key)) {

			visited.add(key);

			detectCycles.add(key);
			for (String child : graph.get(key)) {

				dfs(child, visited, graph, sorted, detectCycles);

			}
			detectCycles.remove(key);
			sorted.add(key);

		}
	}

}
