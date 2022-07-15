package arrays;

public class EqualSumPartition {
	
	static int dp[] [];
	
	public static int equalSumPartition(int totalSum, int nums[], int i) {
		
		if(totalSum == 0) {
			return dp[i][totalSum] = 1;
		}
		if(totalSum < 0 || i <= 0)return 0;
		if(dp[i][totalSum] != -1)return dp[i][totalSum];
		
		
	 return dp[i][totalSum] =  Math.max(equalSumPartition(totalSum - nums[i-1], nums, i-1),
		equalSumPartition(totalSum, nums, i-1));
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		int arr[] = {1, 3, 4, 6, 4, 3, 1, 9, 6, 5, 4, 5, 4};
		int sum = 0;
		for(int i=0; i<arr.length; i++)sum += arr[i];
		if(sum % 2 != 0)System.out.println(0);
		dp = new int [arr.length+1][sum+1];
		for(int i=0; i<=arr.length; i++) {
			for(int j=0; j<= sum; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(equalSumPartition(sum/2, arr, arr.length-1));
		
	}
	
}
