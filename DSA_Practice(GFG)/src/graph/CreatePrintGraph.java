package graph;

import java.util.ArrayList;

public class CreatePrintGraph {

	
	private ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	private int capacity = 0;
	public CreatePrintGraph(int capacity) {
		this.capacity = capacity;
		for(int i=0; i<this.capacity; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}
	
	public void unDirectedAddEdge(int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	
	public void directedAddEdge(int u, int v) {
		adj.get(u).add(v);
	}
	
	public ArrayList<ArrayList<Integer>> getGraph(){
		return this.adj;
	}
	
	
	public void printGraph(ArrayList<ArrayList<Integer>> graph) {
		
		for(int i=0; i<graph.size(); i++) {
			System.out.print("vertex : "+ i+" ->");
			for(int j=0; j<graph.get(i).size(); j++) {
				System.out.print(graph.get(i).get(j)+ " ");
			}
			System.out.println();
		}
	}
}
