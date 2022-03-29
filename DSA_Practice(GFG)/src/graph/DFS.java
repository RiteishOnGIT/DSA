package graph;

import java.util.ArrayList;

public class DFS {

	
	public static void recursiveDFS(ArrayList<ArrayList<Integer>>adj, int element, int[] visited) {
		
		if(visited[element] != -1) {
			visited[element] = -1;
			System.out.println(element);
			
			for(int i=0; i<adj.get(element).size(); i++) {
				if(visited[adj.get(element).get(i)] != -1) {
					recursiveDFS(adj, adj.get(element).get(i), visited);
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		
		CreatePrintGraph grapghCreatePrintGraph = new CreatePrintGraph(5);
		grapghCreatePrintGraph.directedAddEdge(0, 1);
		grapghCreatePrintGraph.directedAddEdge(0, 2);
		grapghCreatePrintGraph.directedAddEdge(0, 3);
		grapghCreatePrintGraph.directedAddEdge(1, 3);
		grapghCreatePrintGraph.directedAddEdge(3, 4);
		grapghCreatePrintGraph.directedAddEdge(4, 2);
		
		ArrayList<ArrayList<Integer>> adj = grapghCreatePrintGraph.getGraph();
		int [] visisted = new int[5];
		
		recursiveDFS(adj, 3, visisted);
		
	}

}
