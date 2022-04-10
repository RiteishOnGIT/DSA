package recursion;

public class KnightSteps {

	
	public static int minSteps(boolean[][] array, int row, int col, int n, int targetRow, int targetCol, int [][]dp) {
		

		if(col >= n || row>=n || row<0 || col < 0)return (int) Double.MAX_VALUE;

		if(dp[row][col] != -1)return dp[row][col];
		if(targetRow == row && targetCol == col) {
			dp[row][col] = 0;
			return 0;
		}
		if(array[row][col] == true)return n*n+1;
		array[row][col] = true;
		int result = 0;
		result =  1 + Math.min(
				Math.min(
				Math.min(minSteps(array, row-2, col-1, n, targetRow, targetCol, dp), minSteps(array, row-2, col+1, n, targetRow, targetCol, dp)),
				Math.min(minSteps(array, row+2, col-1, n, targetRow, targetCol, dp), minSteps(array, row+2, col+1, n, targetRow, targetCol, dp))
				),
				Math.min(
				Math.min(minSteps(array, row-1, col-2, n, targetRow, targetCol, dp), minSteps(array, row+1, col-2, n, targetRow, targetCol, dp)),
				Math.min(minSteps(array, row-1, col+2, n, targetRow, targetCol, dp), minSteps(array, row+1, col+2, n, targetRow, targetCol, dp)))
				);
		array[row][col] = false;
		dp[row][col] = result;
		return result;
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		int n=30;
		boolean array[][] = new boolean[n][n];
		int dp[][] = new int [n+1][n+1];
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<n+1; j++)dp[i][j] = -1;
		}
		System.out.println(minSteps(array, 29, 29, n, 0, 0, dp));
		
		
	}
	
}
