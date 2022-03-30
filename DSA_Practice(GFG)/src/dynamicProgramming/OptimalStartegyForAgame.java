package dynamicProgramming;

public class OptimalStartegyForAgame {

	static int max = Integer.MIN_VALUE;
	static int dp[][];

	public static int optimalStartegy(int array[], int low, int high, int turn, int sum) {

		if (low == high) {
			max = Math.max(max, sum);
			dp[low][high] = max;
			return max;
		}
		
		if (turn == 1) {
			dp[low][high] =  optimalStartegy(array, low + 1, high, 0, sum + array[low]);
			dp[high][low] =  optimalStartegy(array, low, high - 1, 0, sum + array[high]);
		}
		if (turn == 0) {
			if (array[low] > array[high]) {
				dp[low][high] = optimalStartegy(array, low + 1, high, 1, sum);
			} else { 
				dp[high][low] = optimalStartegy(array, low, high - 1, 1, sum);
			}

		}
		return Math.max(dp[low][high], dp[high][low]);
	}
	
	
	
	static int optimalStartegySecond(int array[] ,int i, int j) {
		
		if(i+1 == j)return Math.max(array[i], array[j]);
		
		return Math.max(
				array[i] + Math.min (optimalStartegySecond(array, i+2, j), optimalStartegySecond(array, i, j-2)),
				array[j] + Math.min (optimalStartegySecond(array, i+1, j-1), optimalStartegySecond(array, i, j-2))
		);
		
		
	}

	public static void main(String[] args) {

		int array[] = {3, 7, 8,6,5,4,3,5,6,67,78,89};
		dp = new int[1000][1000];

		for (int i = 0; i < 1000; i++)
			for (int j = 0; j < 1000; j++)
				dp[i][j] = -1;

		System.out.println(optimalStartegySecond(array, 0, array.length-1));

	}

}
