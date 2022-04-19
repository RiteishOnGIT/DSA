package graph;

import java.util.ArrayList;

public class TopologicalSortDfs {
	
	public static void topologicalSorting(int visited[], int source, ArrayList<ArrayList<Integer>> graph, ArrayList<Integer>result) {
		if(visited[source] == 1)return;
		
		visited[source] = 1;
		ArrayList<Integer> list = graph.get(source);
		for(Integer i: list) {
			if(visited[i] == 0) {
				topologicalSorting(visited, i, graph, result);
			}
		}
		result.add(source);
	}
    
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int visited[] = new int[V];
		
		ArrayList<Integer>result = new ArrayList<Integer>();
		
		for(int i=0; i<visited.length; i++) {
			if(visited[i] == 0) {
				topologicalSorting(visited, i, adj, result);
			}
		}
        int[] resultList = new int[V];
        for(int i=result.size()-1; i>=0; i--){
            resultList[(result.size()-i)-1] = result.get(i);
        }
        System.out.println(result);
        return resultList;
    }
	
	
	
	
	public static void main(String[] args) {
		CreatePrintGraph graph = new CreatePrintGraph(5);
		graph.directedAddEdge(3, 4);
		graph.directedAddEdge(3, 0);
		graph.directedAddEdge(1, 0);
		graph.directedAddEdge(2, 0);
		graph.directedAddEdge(1, 3);
		graph.directedAddEdge(2, 3);
		
		topoSort(5, graph.getGraph());
		
	}

}
