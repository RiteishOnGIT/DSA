package searching;

public class PageAllocationUsingBinarySearch {

	public static int pageAllocationUsingBinarySearch(int array[], int n, int k) {
		
		int sum = 0;
		int max = 0;
		for(int i=0; i<array.length; i++) {
			if(max < array[i])max = array[i];
			sum += array[i];
		}
		int low=max, high = sum, ans = 0;
		while(low <= high) {
			
			int mid = (low+high)/2;
			if(isFeasible(array, mid, k)) {
				ans = mid;
				high = mid-1;
			}
			else {
				low = mid+1;
			}
			
		}
		return ans;
	}
	
	
	
	private static boolean isFeasible(int[] array, int ans, int k) {
		
		int req = 0, sum = 0;
		for(int i=0; i<array.length; i++) {
			if(sum+array[i] > ans) {
				sum = array[i];
				req++;
			}
			else {
				sum += array[i];
			}
		}
		
		return req <= k;
	}

	public static int findPages(int[]A,int N,int M)
    {
        int solution =  pageAllocationUsingBinarySearch(A, N, M);
        int max = 0;
        int sum = 0;
        for(int i=0; i<A.length; i++){
            if(sum+A[i] > solution) {
                if(sum > max) {
                	
                	max = sum;
                }
				sum = A[i];
			}
			else {
				sum += A[i];
			}
        }
        return max;
        //Your code here
    }

	public static void main(String[] args) {
		int array[] = {12, 34, 67, 90};
		System.out.println(findPages(array, 0, 2));
		
	}

}
