package dynamicProgramming;

import java.util.Arrays;

public class MinimumSumPartition {
	
	static int minSum = Integer.MAX_VALUE;
	
	public static int minimumSum(int sum1, int n, int arr[], int sum2, int x, int dp[][]) {
		
		minSum = Math.min(Math.abs(sum2 - sum1), minSum);
		if(n == 0 || x == 0)return dp[n][sum1] =  minSum;
		if(dp[n][sum1] != -1)return dp[n][sum1];
		
		return dp[n][sum1] = Math.min(minimumSum(sum1-arr[n-1], n-1, arr, sum2+arr[n-1], x-1, dp),
		minimumSum(sum1, n-1, arr, sum2, x, dp));
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		int arr [] = {1, 2,3,4};
		Arrays.sort(arr);
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		
		int dp[][] = new int[arr.length+1][sum+1];
		for(int i=0; i<arr.length+1; i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(minimumSum(sum, arr.length, arr, 0, (int)Math.ceil((float)arr.length/2), dp));
		//System.out.println(minSum);
		
	}
}
