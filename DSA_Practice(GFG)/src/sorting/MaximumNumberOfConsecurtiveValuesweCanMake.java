package sorting;

import java.util.Arrays;

public class MaximumNumberOfConsecurtiveValuesweCanMake {
	
	
	public static int getMaximumConsecutive(int[] coins) {
		
		Arrays.sort(coins);
		
		int sum = 0;
		int i=0;
		for(; i<coins.length; i++) {
			
			if(sum+1 >= coins[i]) {
				sum += coins[i];
			}
			else {
				return sum+1;
			}
			
			
		}
		return sum+1;
	}
 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {12, 8, 1, 1, 1, 1, 3,27, 45, 56, 78, 54, 110, 113, 112, 1134};
		System.out.println(getMaximumConsecutive(array));
	}

}
