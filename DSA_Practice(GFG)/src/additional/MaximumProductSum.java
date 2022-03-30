package additional; public class MaximumProductSum {
	
	
	
	public static int maxProductRotations(int array[] ) {
		
		int maxProd = 0;
		int maxSum = 0;
		
		for(int i=1; i<array.length; i++)maxSum += array[i];
		for(int i=0; i<array.length; i++)maxProd += array[i]*i;
		
		int result = Integer.MIN_VALUE;
		result = Math.max(maxProd, result);
		
		for(int i=1; i<array.length; i++) {
			maxProd = maxProd - maxSum + (array[i-1]*(array.length-1));
			maxSum = maxSum - array[i]+array[i-1];
			result = Math.max(maxProd, result);
			
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		int array[]  = {3, 2, 1};
		maxProductRotations(array);
 	}
	
}
