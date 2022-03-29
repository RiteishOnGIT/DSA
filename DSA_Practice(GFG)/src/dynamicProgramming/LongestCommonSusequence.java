package dynamicProgramming;

public class LongestCommonSusequence {
	
	static int memo[][] = new int [10001][10001];
	
	public static int LCSmemo(String s1, String s2, int i, int j) {
		
		if(memo[i][j] == -1) {
			if(i == 0 || j == 0) {
				memo[i][j] = 0;
				return 0;
			}
			
			
			if(s1.charAt(i-1) == s2.charAt(j-1)) {
				
				return memo[i][j] =  1+LCSmemo(s1, s2, i-1, j-1);
				
			}
			
			else {
				return memo[i][j] = Math.max(LCSmemo(s1, s2, i-1, j), LCSmemo(s1, s2, i, j-1));
			}
		}
		
		return memo[i][j];
		
		
	}
	
	
	public static int LCStabular(String s1, String s2) {
		
		int dp[][] = new int [s1.length()+1][s2.length()+1];
		
		for(int i=0; i<=s1.length(); i++)dp[i][0] = 0;
		for(int i=0; i<=s2.length(); i++)dp[0][i] = 0;
		
		
		for(int i=1; i<=s1.length(); i++) {
			for(int j=1; j<=s2.length(); j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = 1+dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		return dp[s1.length()][s2.length()];
	}
	
	public static void main(String[] args) {
		String s1 = "ABC";
		String s2 = "AXDefwefwefweBwedCwedfcwecewfc";
		

		for(int i=0; i<10001; i++) {
			for(int j=0; j<10001; j++) {
				memo[i][j] = -1;
			}
		}
		
		System.out.println(LCSmemo(s1, s2, s1.length(), s2.length()));
		System.out.println(LCStabular(s1, s2));
	}
	
	
	
}
