package dynamicProgramming;

public class TargetSum {
	
	static int result = 0;
	
	static void findTargetSumRecursive(int array[], int n, int targetSum, int mySum) {
		
		if(n < 0)return ;
	
		if(mySum == targetSum) {
			result++;
		}
		
		findTargetSumRecursive(array, n-1, targetSum ,mySum+array[n]);
		findTargetSumRecursive(array, n-1, targetSum, mySum - array[n]);
		findTargetSumRecursive(array, n-1, targetSum, mySum);
		
	}
	
	
	static int findtargetSumWays(int array[], int target) {
		findTargetSumRecursive(array, array.length-1, target, 0);
		return result;
	}
	
	
	
	public static void main(String[] args) {
		int array[] = {1,2};
		System.out.println(findtargetSumWays(array, 3));
	}
	
	
	
}
