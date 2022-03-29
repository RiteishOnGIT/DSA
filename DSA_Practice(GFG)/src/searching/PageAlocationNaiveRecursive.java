package searching;

public class PageAlocationNaiveRecursive {

	
	public static int maximumAllocation(int array[], int index, int k) {
		
		if(k == 1)return sum(array, index);
		if(array.length == 1)return array[0];
		
		int tempResult = Integer.MAX_VALUE;
		int current = 0;
		int result = Integer.MAX_VALUE;
		for(int i=index; i<array.length; i++) {
			current += array[i];
			tempResult = Math.max(current, maximumAllocation(array, i+1, k-1));
			if(result > tempResult) {
				result = tempResult;
			}
			
		}
		return result;
	}
	
	
	public static int sum(int array[], int index) {
		
		int sum = 0;
		for(int i=index; i<array.length; i++) {
			sum += array[i];
		}
		return sum;
	}
	
	
	public static void main(String[] args) {
		int array[] = {12, 34, 67, 90};
		System.out.println(maximumAllocation(array, 0, 2));
		
	}

}
