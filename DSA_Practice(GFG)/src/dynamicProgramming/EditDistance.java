package dynamicProgramming;

public class EditDistance {
	
	
	static int temp [][]= new int[201][201];
	
	
	
	static int findDistanceMemo(String s1, String s2, int i, int j) {
		
		if(temp[i][j] == -1) {
			if(j == 0 || i == 0) {
				temp[i][j] = Math.abs(j-i);
				return temp[i][j];
			}
			
			if(s1.charAt(i-1) == s2.charAt(j-1)) {
				
				temp[i][j] = findDistanceMemo(s1, s2, i-1, j-1);
				return temp[i][j];
				
			}
			else {
				temp[i][j] = Math.min((Math.min(1+findDistanceMemo(s1, s2, i, j-1),
						1+findDistanceMemo(s1, s2, i-1, j))),1+findDistanceMemo(s1, s2, i-1, j-1));
				return temp[i][j];
				
			}
		}
		
		return temp[i][j];
		
	}
	
	
	static int findDistanceTabular(String s1, String s2) {
		
		int dp[][] = new int [s1.length()+1][s2.length()+1];
		
		for(int i=0; i<=s1.length(); i++) {
			dp[i][0] = i;
		}
		for(int i=0; i<=s2.length(); i++) {
			dp[0][i] = i;
		}
		
		
		for(int i=1; i<=s1.length(); i++) {
			for(int j=1; j<=s2.length(); j++) {
				
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.min((Math.min(1+dp[i-1][j], 1+dp[i][j-1])),
							1+dp[i-1][j-1]);
				}
				
			}
		}
		return dp[s1.length()][s2.length()];
	}
	
	 
	public static void main(String[] args) {
		
		for(int i=0; i<201; i++) {
			for(int j=0; j<201; j++) {
				temp[i][j]  =-1;
			}
		}
		
		System.out.println(findDistanceTabular("CWDWDWDW", "CUT"));
		
	}
	
	
}
