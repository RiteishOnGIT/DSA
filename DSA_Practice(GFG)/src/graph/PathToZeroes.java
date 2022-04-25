package graph;

import java.util.ArrayList;

public class PathToZeroes {
	
	static Integer countInteger  = 0;
	
	public static boolean dfsSolution(ArrayList<ArrayList<Integer>> graph, Integer count, int source, int []reachable, int visited[]) {
		if(visited[source] == 1)return false;;
		count = countInteger;
		visited[source] = 1;
		
		for(Integer adj: graph.get(source)) {
			
			if(reachable[adj] == 1)continue;
			
			if(visited[adj] == 0) {
				if(!dfsSolution(graph, count+1, adj, reachable, visited)) {
					countInteger++;
				}
				reachable[adj] = 1;
			}
		}
		return false;
	}
	
	
	public static int allPaths(ArrayList<ArrayList<Integer>> graph) {
		
		int [] reachable = new int[8];
		int [] visited = new int[8];
		reachable[0] = 1;
		int count = 0;
		for(int i=0; i<8; i++) {
			if(visited[i] == 0) {
				dfsSolution(graph, 0, i, reachable, visited);
			}
		}
		return countInteger;
	}
	
	public static void main(String[] args) {
		
		CreatePrintGraph graph = new CreatePrintGraph(8);
		graph.directedAddEdge(1, 0);
		graph.directedAddEdge(1, 2);
		graph.directedAddEdge(3, 2);
		graph.directedAddEdge(2, 7);
		graph.directedAddEdge(4, 7);
		graph.directedAddEdge(3, 4);
		graph.directedAddEdge(5, 4);
		graph.directedAddEdge(6, 5);
		System.out.println(allPaths(graph.getGraph()));
		
	}

}
