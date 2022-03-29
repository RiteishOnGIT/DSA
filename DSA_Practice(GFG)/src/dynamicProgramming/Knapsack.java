package dynamicProgramming;

public class Knapsack {

	static int t[][] = new int[100][100];
	
	static int findMaxProfit(int capacity, int n, int array2[], int array[], int currentProfit) {

		if (capacity < 0)
			return currentProfit - array[n+1];
		
		if (n < 0)
			return 0;

		if(capacity == 0)return currentProfit;
		
		if(t[n][capacity] != -1)return t[n][capacity];
		return t[n][capacity] =  Math.max(findMaxProfit(capacity - array2[n], n - 1, array2, array, currentProfit + array[n]),
				findMaxProfit(capacity, n - 1, array2, array, currentProfit));
	}

	static int knapSack(int W, int wt[], int val[], int n) {

		return findMaxProfit(W, n - 1, wt, val, 0);

	}

	public static void main(String[] args) {
		int values[] = {1,3,4,5 };
		int weight[] = {1,4,5,7};
		
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				t[i][j] = -1;
			}
		}
		
		System.out.println( knapSack(7, weight, values, 3));
	}
}
