package dynamicProgramming;

public class LongestCommonSubstring {
	
	static int dp[][];
	
	public static int longestSubsting(String s1, String s2, int i, int j, int counter) {
		
		if(dp[i][j] != -1)return dp[i][j];
		
		if(i == 0 ||j== 0) {
			return counter;	
		}
		 
		if(s1.charAt(i-1) == s2.charAt(j-1)) {
			counter = 0;
			int a = i;
			int b= j;
			while(s1.charAt(a-1) == s2.charAt(b-1) && (a != 0 || b != 0)) {
				a--;
				b--;
				counter++;
				if(a == 0 || b== 0)break;
			}
		}
		dp[i][j] =	Math.max(counter, Math.max(longestSubsting(s1, s2, i, j-1, 0),longestSubsting(s1, s2, i-1, j, 0)));
		return dp[i][j];
	}
	

	public static void main(String[] args) {
		
		String s1 = "ABXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXWFSDVWDVTWDVTAVDTVADVAVDTAVTADVTAWVDTWDVTWDV";
		String s2 = "ABAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADAAAAABDBASDBSDCBCBCXDWDBHWDBJDBJDBWJBDJWBDJBWDJUBDAAAAAAAAAA";
		dp = new int [s1.length()+1][s2.length()+1];
		for(int i=0; i<=s1.length(); i++) {
			for(int j=0; j<=s2.length(); j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(longestSubsting(s1, s2, s1.length(), s2.length(), 0));
		
	}
	
}
