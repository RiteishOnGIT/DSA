package dynamicProgramming;

public class MinimumCostClimbingStairs{
	
	static int dp[];
	public static int minCost(int array[] , int i) {
		if(dp[i] != -1)return dp[i];
		if(i == 0)return 0;
		if(i - 2 <0)return 0;
		dp[i] = Math.min(array[i-1]+minCost(array, i-1), array[i-2]+minCost(array, i-2));
		return dp[i];
	}
	
	
	public static int climbingStairs(int n) {
		if(dp[n] != -1)return dp[n];
		if(n == 0)return 1;
		if(n == 1)return 1;
		
		dp[n] =  climbingStairs(n-1) +climbingStairs(n-2);
		return dp[n];
		
	}
	
	public static void main(String[] args) {
		
		int array[] = {1, 100, 1,1, 1,100,1, 100,1};
		dp = new int[array.length+1];
		for(int i=0; i<=array.length; i++)dp[i] = -1;
		System.out.println(minCost(array, array.length));
		for(int i=0; i<array.length+1; i++)System.out.print(dp[i]+" ");
		System.out.println();

		System.out.println(climbingStairs(45));
	}
	
}
