package strings;

public class CommonChild {
	
	
	
	//ATTENTION RECURSIVE APPROACH WILL GIVE STACK OVERFLOW
	public static int findCommonChild(String s1, String s2, int i, int j, int[][] dp) {
		
		if(i == 0 || j == 0) {
			return 0;
		}
		if(dp[i][j] != -1) {
			System.out.println("Im used");
			return dp[i][j];
		}
		int res = 0;
		if(s1.charAt(i-1) == s2.charAt(j -1)) {
			res = 1 + findCommonChild(s1, s2, i-1, j-1,  dp);
			return res;
		}
		
		res =  Math.max(findCommonChild(s1, s2, i-1, j,  dp), findCommonChild(s1, s2, i, j-1, dp));
		dp[i][j] = Math.max(dp[i][j], res);
		return res;
	}
	
	public static int findCommonChildDp(String s1, String s2) {
		
		int dp[][] = new int[s1.length()+1][s2.length()+1];
		for(int i=0; i<s1.length()+1; i++) {
			for(int j=0; j<s2.length()+1; j++) {
				dp[i][j] = -1;
			}
		}
		
		return findCommonChild(s1, s2, s1.length(), s2.length(), dp);
		
		
	}
	
public static int findCommonChildIterative(String s1, String s2) {
		
		int dp[][] = new int[s1.length()+1][s2.length()+1];
		for(int i=0; i<s1.length()+1; i++) {
			for(int j=0; j<s2.length()+1; j++) {
				dp[i][j] = 0;
			}
		}
		
		
		for(int i=1; i<=s1.length(); i++) {
			for(int j=1; j<= s2.length(); j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		return dp[s1.length()][s2.length()];
		
		
	}
	public static void main(String[] args) {
		System.out.println( findCommonChildIterative("SAHINCHN", "NOHAIRAAN"));
	}
	
}
