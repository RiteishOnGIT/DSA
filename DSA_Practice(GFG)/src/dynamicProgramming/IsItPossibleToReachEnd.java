package dynamicProgramming;

public class IsItPossibleToReachEnd {

	public static boolean isItPossible(int array[]) {
		
		boolean dp[] = new boolean[array.length];
		dp[array.length-1] = true;
		for(int i=array.length-2; i>=0 ; i--) {
			
			if(array[i] != 0) {
				
				if(array[i] + i >= array.length-1) {
					dp[i] = true;
				}
				else {
					if(dp[array[i] + i] == true) {
						dp[i]  =true;
					}
					if(dp[i + 1]) {
						dp[i] =true;
					}
					
					else {
						int start = i+1;
						int end = array[i] + i;
						while(start != end) {
							if(dp[start] == true) {
								dp[i]=true;
								break;
							}
							start++;
						}
					}
				}
			}
			
			
			
		}
		return dp[0];
	}
	
	
	public static void main(String[] args) {
		
		int array[] = {1 ,3, 2};
		System.out.println(isItPossible(array));
		
	}
	
}
