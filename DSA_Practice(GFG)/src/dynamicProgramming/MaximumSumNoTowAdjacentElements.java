package dynamicProgramming;

public class MaximumSumNoTowAdjacentElements {
	
	static int findMax(int array[], int n) {
		if(n == 1)return array[0];
		if(n == 2)return Math.max(array[0], array[1]);
		array[2] += array[0];
		int result = array[2];
		if(n == 3){
		    
		    result =Math.max (Math.max(array[0], array[1]), array[2]);
		    
		}
		
		for(int i=3; i<n; i++) {
			
			array[i] += Math.max(array[i-2], array[i-3]);
			result = Math.max(array[i], result);
			
		}
		
		return result;
		
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		int array[] = {2427, 2292, 9321, 3340};
		
		System.out.println(findMax(array, array.length));
		
		
	}
	
	
}
