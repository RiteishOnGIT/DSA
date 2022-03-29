package dynamicProgramming;

public class SusbsetSum {
	
	
	static int t[][] = new int[1001][1001];
	
	static int finSubsetWithegivenSum(int array[] ,int n, int sum) {
		if(sum < 0)return 0;
		if(sum == 0) {
			t[sum][n] = 1;
			return 1;
		}
		if(n == 0) {
			t[sum][n] = 0;
			return 0;
		}
		if(t[sum][n] == -1) {
			return t[sum][n] =  finSubsetWithegivenSum(array, n-1, sum-array[n-1])+finSubsetWithegivenSum(array, n-1, sum);
		}
		return t[sum][n];
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		int arr[] = {3, 34, 4, 12, 5, 2};
		
		for(int i=0; i<1001; i++) {
			for(int j=0; j<1001; j++) {
				t[i][j] = -1;
			}
		}
		
		System.out.println(finSubsetWithegivenSum(arr, arr.length, 9));

		
	}
	
}
