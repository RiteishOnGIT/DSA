package additional;

public class EquilibriumPoint {
	
	public static int equilibriumPoint(int array[]) {
		
		int prefixSum = 0;
		
		for(int i=0; i<array.length; i++)prefixSum += array[i];
		
		int leftSum = 0;
		for(int i=0; i<array.length; i++) {
			
			if(leftSum == prefixSum-array[i]) {
				return array[i];
			}
			leftSum += array[i];
			prefixSum -= array[i];
			
		}
		
		
		return -1;
	}
	
	
	
	public static void main(String[] args) {
		
		int array[] = {1,4, 6,10, 1,1,1,1,1,6 };
		System.out.println(equilibriumPoint(array));
		
	}
	
}
