package dynamicProgramming;

import java.util.Arrays;

public class MinimumNumberOfJumps {
	
	public static int minimumNumber(int nums[]) {
		
		int dp[] = new int[nums.length];
		Arrays.fill(dp, Integer.MAX_VALUE-1);
		dp[nums.length-1] = 0;
		for(int i= nums.length-2; i>=0; i--) {
			int reach = nums[i]+i;
			int x = i+1;
			while(x <= reach && x  <nums.length) {
				
				dp[i] = Math.min(dp[x]+1, dp[i]);
				x++;
				
			}	
		}
		
		return dp[0];
		
	}
	
	
	public static void main(String[] args) {
		int array [] = {2,3,1,1,4,2,3,0,1,4};
		System.out.println(minimumNumber(array));
	}
	
	
}
