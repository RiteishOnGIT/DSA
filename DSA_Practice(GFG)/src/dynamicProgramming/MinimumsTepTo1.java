package dynamicProgramming;

public class MinimumsTepTo1 {
	
	
	
	
	static int dp[]; 
	
	public  static int minSteps(int n) 
	{ 
	    if(n == 1) {
	    	dp[n] = 0;
	    	return 0;
	    }
	    if(n <= 0) {
	    	dp[0] = Integer.MAX_VALUE;
	    	return Integer.MAX_VALUE;
	    }
	    if(dp[n] == -1) {
	    int a=Integer.MAX_VALUE, b=Integer.MAX_VALUE, c =Integer.MAX_VALUE;
	    if(n % 2 == 0)a =minSteps(n/2)+1;
	    if(n % 3 == 0)b= minSteps(n/3)+1;
	    if(n > 1)c =minSteps(n-1)+1;
	    
	    return dp[n] =  Math.min(Math.min(a, b),c);
	    }
	    return dp[n];
	} 
	
	
	public static void main(String[] args) {
		for(int i=0; i<10001; i++)dp[i] = -1;
		System.out.println(minSteps(9999));
	}
}
