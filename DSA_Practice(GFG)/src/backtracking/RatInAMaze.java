package backtracking;

public class RatInAMaze {
	
	
	public static void ratInAMaze(int arr[][], int n, int m, String s ,int [][]visited) {
		
		
		
		if(n < 0 || m < 0 || n > arr.length-1 || m>arr.length-1)return;
		

		if(arr[n][m] == 0)return;

		if(visited[n][m] == 1)return;
		
		if(n == arr.length-1 && m == arr.length-1) {
			System.out.println(s);
			return;
		}
		
		visited[n][m] = 1;
		
		if(arr[n][m] == 1) {
			ratInAMaze(arr, n, m-1, s.concat("L"), visited);
			ratInAMaze(arr, n, m+1, s.concat("R"), visited);
			ratInAMaze(arr, n-1, m, s.concat("U"), visited);
			ratInAMaze(arr, n+1, m, s.concat("D"), visited);
		}
		visited[n][m] = 0;
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		   
		int m[][] = {
					{1, 0, 0, 0},
		         	{1, 1, 1, 1},
		         	{1, 1, 0, 0},
		         	{1, 1, 1, 1},
		         	};
		
		int visited [][] = new int [4][4];
		ratInAMaze(m, 0, 0, "", visited);
		
	}
	
	
}
