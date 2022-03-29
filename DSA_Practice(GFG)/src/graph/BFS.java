package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class BFS {
	
	public static void breadthFirstSearch(ArrayList<ArrayList<Integer>> adj, int source) {
		
		int [] visited = new int[adj.size()];
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		queue.add(source);
		while(!queue.isEmpty()) {
			int element = queue.poll();
			visited[element] = -1;
			System.out.print(element);
			for(int i=0; i<adj.get(element).size(); i++) {
				if(visited[adj.get(element).get(i)] != -1) {
					queue.offer(adj.get(element).get(i));
					visited[adj.get(element).get(i)] = -1;
				}
			}
			System.out.println();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		CreatePrintGraph grapghCreatePrintGraph = new CreatePrintGraph(5);
		grapghCreatePrintGraph.unDirectedAddEdge(0, 1);
		grapghCreatePrintGraph.unDirectedAddEdge(0, 2);
		grapghCreatePrintGraph.unDirectedAddEdge(0, 3);
		grapghCreatePrintGraph.unDirectedAddEdge(1, 3);
		grapghCreatePrintGraph.unDirectedAddEdge(3, 4);
		grapghCreatePrintGraph.unDirectedAddEdge(4, 2);
		grapghCreatePrintGraph.unDirectedAddEdge(4, 1);
		
		ArrayList<ArrayList<Integer>> adj = grapghCreatePrintGraph.getGraph();
		breadthFirstSearch(adj, 1);
		
		
	}
}
