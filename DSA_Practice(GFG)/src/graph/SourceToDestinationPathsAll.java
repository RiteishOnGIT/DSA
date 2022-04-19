package graph;

import java.util.ArrayList;
import java.util.List;

public class SourceToDestinationPathsAll {

	
	
	public static void DFS(int destination, int source, int graph[][], ArrayList<Integer>path, List<List<Integer>> reslist) {
		if(source == destination) {
			path.add(destination);
			ArrayList<Integer> newResArrayList = new ArrayList<Integer>();
			for(Integer a: path) {
				newResArrayList.add(a);
			}
			reslist.add(newResArrayList);
			path.remove(path.size()-1);
			return;
		}
		
		  
		for(int i=0; i<graph.length; i++) {
			
			if(graph[source][i] == 1) {
				path.add(source);
				DFS(destination, i, graph, path, reslist);
				path.remove(path.size()-1);
			}
			
		}
	}
	
	
	
	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		
		List<List<Integer>> reslist = new ArrayList<List<Integer>>();
		
		DFS(4, 0, graph, new ArrayList<Integer>(), reslist);
		return reslist;
	}

	public static void addEdge(int u, int v, int graph[][]) {

		graph[u][v] = 1;

	}

	public static void main(String[] args) {

		int graph[][] = new int[5][5];

		addEdge(0, 1, graph);
		addEdge(0, 3, graph);
		addEdge(0, 4, graph);
		addEdge(1, 3, graph);
		addEdge(1, 2, graph);
		addEdge(2, 3, graph);
		addEdge(3, 4, graph);
		addEdge(1, 4, graph);
		
		allPathsSourceTarget(graph);
	}

}
