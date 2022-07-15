package graph;

import java.util.Arrays;

public class NumberOfPRoviences {
    
    public int [] visited ;
    
    public void dfs(int [][] isConnected, int source){
        if(visited[source] == 1)return;
        visited[source] = 1;
        for(int i=0; i<isConnected.length; i++){
            if(visited[i+1] == 0 && isConnected[source-1][i] == 1){
                dfs(isConnected, i+1);
            }
        }
        
        
    }
    
    
    public int findCircleNum(int[][] isConnected) {
        
        visited = new int[isConnected.length+1];
        Arrays.fill(visited, 0);
        int provinces = 0;
        
        for(int i=1; i<=isConnected.length; i++){
            if(visited[i] == 0){
                provinces++;
                dfs(isConnected, i);
            }
        }
        
        return provinces;
    }
    
    public static void main(String[] args) {
		
    	int graph[][] = {{1,1,0}, {1,1,0},{0,0,1}};
    	NumberOfPRoviences numberOfPRoviences = new NumberOfPRoviences();
    	System.out.println(numberOfPRoviences.findCircleNum(graph));
    	
	}
    
}
