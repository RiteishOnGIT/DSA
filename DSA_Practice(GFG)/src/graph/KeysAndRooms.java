package graph;

import java.util.ArrayList;
import java.util.List;

public class KeysAndRooms {
	
	public static void dfsRooms(int visited[] ,int source, List<List<Integer>>graph) {
		
		if(visited[source] == 1)return ;
		
		visited[source] = 1;
		
		for(Integer adj: graph.get(source)) {
			if(visited[adj] == 0) {
				dfsRooms(visited, adj, graph);
			}
		}
	}
	
	
	public static boolean keysAndRooms(List<List<Integer>> graph) {
		
		int [] visited = new int[4];
		dfsRooms(visited, 0, graph);
		
		for(int i=0; i<visited.length; i++)if(visited[i] == 0)return false;
		return true;
	}
	
	
	
	public static void main(String[] args) {
		
		List<List<Integer>> graph = new ArrayList<List<Integer>>();
		
		graph.add(new ArrayList<Integer>(List.of(1, 3)));
		graph.add(new ArrayList<Integer>(List.of(3, 0, 1)));
		graph.add(new ArrayList<Integer>(List.of(2)));
		graph.add(new ArrayList<Integer>(List.of(0, 2)));
		
		System.out.println(keysAndRooms(graph));
		
	}
}
