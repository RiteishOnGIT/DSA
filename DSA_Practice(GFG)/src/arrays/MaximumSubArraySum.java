package arrays;

public class MaximumSubArraySum {
	
	public static int kadensAlgorithm(int array[]) {
		
		int sum = array[0];
		int result = array[0];
		
		for(int i=1; i<array.length; i++) {
			
			if(sum +array[i] > array[i]) {
				sum += array[i];
			}
			else {
				sum = array[i];	
			}
			result = Math.max(result, sum);
		}
		
		return result;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {-1, -2};
		System.out.println(kadensAlgorithm(array));
		
		
	}

}
