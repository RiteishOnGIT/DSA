package dynamicProgramming;

public class CoinChange {	
	
	static int coinChange(int array[], int n, int sum) {
		
		if(sum == 0) {
			return 1;
		}
		if(n == 0)return 0;
		
		int result = coinChange(array, n-1, sum);
		
		if(sum >= array[n]) {
			
			result = result + coinChange(array, n, sum-array[n]);
			
		}
		
		return result;
		
		
	}
	
	
	




	public static void main(String[] args) {
		
		
		int coins[] = {2, 5, 3, 6};
		System.out.println(coinChange(coins, coins.length, 10));
		
		
	}
	
	
	
}
