package searching;

public class FindMountain {

	
	
	public static int findMountain(int array[]) {
		
		int [] leftMax = new int[array.length];
		int [] rightMax = new int[array.length];
		int max = Integer.MIN_VALUE;
		for(int i=0; i<array.length; i++) {
			if(max < array[i]) {
				max  = array[i];
			}
			leftMax[i] = max;
		}
		max = Integer.MIN_VALUE;
		for(int i=array.length-1; i>=0; i--) {
			if(max < array[i]) {
				max  = array[i];
			}
			rightMax[i] = max;
		}
		
		for(int i=1; i<array.length-1; i++) {
			if(array[i] > leftMax[i-1] && array[i] > rightMax[i+1])return i;
		}
		return 0;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		int array[] = {0, 5, 10, 2};
		System.out.println(findMountain(array));
		
	}

}
