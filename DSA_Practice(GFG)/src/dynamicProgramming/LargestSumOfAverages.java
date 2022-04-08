package dynamicProgramming;

public class LargestSumOfAverages {
	
	public static double findAverages(int array[] ,int start, int end, int k, double[][]dp) {
		
		if(start+1 < k)return 0;
		if(dp[k][start] != 0)return dp[k][start];
		double average = 0;
		if(k == 1) {
			for(int i=0; i<end; i++) {
				average += array[i];
			}
			average = average /(end-0);
			dp[k][start] = average;
			return average;
		}
		
		double result1 = 0;
		double result2 = 0;
		result1 = findAverages(array, start-1, end, k, dp);
		result2 = findAverages(array, start-1, start, k-1, dp);
		if(result1 <=0 && result2 <=0)return 0;
		for(int i=start; i<end; i++) {
			average += array[i];
		}
		average = average /(end-start);
		result1 = Math.max(result1, result2+average);
		dp[k][start] = result1;
		return result1;
	}
	
	
	public static double findAveragesAccurateVersion(int array[], int k ,int start ,double[][] dp) {
		
		if(k <=0)return 0;
		
		double sum = 0;
		double res = 0;
		if(dp[k][start] != 0) return dp[k][start];
		for(int i=start; i<array.length; i++) {
			
			sum += array[i];
			if(k != -1 || i == array.length -1) {
				res = Math.max(res, sum/(i-start+1) + findAveragesAccurateVersion(array, k-1, i+1, dp));
			}
			
		}
		return dp[k][start] = res;
		
	}
	
	
	public static void main(String[] args) {
		int array[] = {9,1,2,3,9};
		double dp[][] = new double[3+1][array.length+1];
		System.out.println(findAveragesAccurateVersion(array, 3, 0, dp));
	}
	
}
