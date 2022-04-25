package arrays;

public class MaximumProductSubArray {

	
	public static int generateSubArray(int array[]) {
		
		int count = 0;
		
		if(array.length == 2) {
			if(array[0] <= 0 || array [1]<=0) {
				if(array[1] == 0)return 0;
				if(array[0] == 0)return 0;
					
			}
		}
		
		for(int i=1; i<array.length-1; i++) {
			if(array[i] == 0){
				count++;
			}
		}
		if(array.length != 2 && count !=0) {
			if(array[0] <= 0 && array[array.length-1] <= 0 && count == array.length-2) {
				return 0;
			}
		}
		
		
		int result = Integer.MIN_VALUE;
		int minVal = 1;
		int maxVal = 1;
		for(int i=0; i<array.length; i++) {
			
			if(array[i] <= 0) {
				maxVal = 1;
			}
			else {
				maxVal = Math.max(maxVal, maxVal*array[i]);
			}
			if(array[i] == 0) {
				minVal = 1;
			}
			else {
				minVal = minVal*array[i];
			}
			if(maxVal < minVal) {
				maxVal = minVal;
			}
			result = Math.max(maxVal, result);
			
		}
		return result;
		
	}
	
	
	
	public static void main(String[] args) {
		
		int array[] = {-2, -3,-5};
		System.out.println(generateSubArray(array));
	}

}
