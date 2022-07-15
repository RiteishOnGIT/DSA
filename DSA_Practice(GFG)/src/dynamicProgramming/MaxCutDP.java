package dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

public class MaxCutDP {
	
	
	public static int maximizeCuts1(int n, int x, int y, int z, int[] dp, int counter){
		/*
		 * if(n < 0)return -1;
		 * 
		 * if(n == 0) return counter;
		 * 
		 * return dp[n] = Math.max( Math.max(maximizeCuts1(n-x, x, y, z, dp, counter+1),
		 * maximizeCuts1(n-y, x, y, z, dp, counter+1)), maximizeCuts1(n-z, x, y, z, dp,
		 * counter+1));
		 */
		if(n == 0)return -1;
        if(dp[n] != -1)return dp[n];
       if(n == 1) return dp[n] = counter;
       
       return dp[n] =  Math.max( Math.max(maximizeCuts1(n/x, x, y, z, dp, counter+(n/x)),  
       maximizeCuts1(n/y, x, y, z, dp, counter+ (n/y))),
       maximizeCuts1(n/z, x, y, z, dp, counter+(n/z)));
    }
	
	
	public static void main(String[] args) {
		int dp[] = new int [4+1];
        Arrays.fill(dp, -1);
        
        //System.out.println(maximizeCuts1(4 ,2, 1, 1 ,dp, 0));
        
	}
}
