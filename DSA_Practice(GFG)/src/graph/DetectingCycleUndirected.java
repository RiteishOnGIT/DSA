package graph;

import java.util.ArrayList;

public class DetectingCycleUndirected {

	public static boolean detectingCycle(ArrayList<ArrayList<Integer>> adj, int element, int[] visited,
			int lastVisisted) {
		visited[element] = -1;
		for (int i = 0; i < adj.get(element).size(); i++) {
			if (visited[adj.get(element).get(i)] != -1) {
				
				if(detectingCycle(adj, adj.get(element).get(i), visited, element) == true) {
					return true;
				}
				
			} else {
				if(lastVisisted != adj.get(element).get(i)) {
					return true;
				}
				
			}
		}

		return false;

	}

	public static void main(String[] args) {

		CreatePrintGraph grapghCreatePrintGraph = new CreatePrintGraph(8);
		grapghCreatePrintGraph.unDirectedAddEdge(1, 2);
		grapghCreatePrintGraph.unDirectedAddEdge(3, 5);
		grapghCreatePrintGraph.unDirectedAddEdge(3, 2);
		grapghCreatePrintGraph.unDirectedAddEdge(3, 4);
		grapghCreatePrintGraph.unDirectedAddEdge(5, 7);
		grapghCreatePrintGraph.unDirectedAddEdge(5, 6);
		grapghCreatePrintGraph.unDirectedAddEdge(6, 1);
		

		ArrayList<ArrayList<Integer>> adj = grapghCreatePrintGraph.getGraph();
		int[] visited = new int[8];
		
		for(int i=0; i<8; i++) {
			if(visited[i] != -1) {
				System.out.println(detectingCycle(adj, i, visited, i));
			}
		}

	}

}
