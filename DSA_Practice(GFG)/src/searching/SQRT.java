package searching;

public class SQRT {

	
	static int findSqrt( int x) {
		
		int low = 0;
		int high = x;
		int res = 1;
		
		while(low <= high) {
			
			int mid = (low+high)/2;
			if(mid * mid == x)return mid;
			if(mid * mid < x) {
				res = mid;
				low = mid+1;
			}
			else {
				high = mid-1;
			}
			
		}
		return res;
		
	}
	
	
	
	
	
	public static void main(String args[]) {
		System.out.println(findSqrt(2147395599));
	}
}
