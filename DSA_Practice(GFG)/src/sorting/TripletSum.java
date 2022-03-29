package sorting;

import java.util.Arrays;

public class TripletSum {
	
	public static boolean findTriplet(int [] array, int sum) {
		
		int x, y, z= 0;
		for(int i=0; i<array.length; i++) {
			int j=i+1;
			x = array[i];
			int k= array.length-1;
			while(j<k) {
				y = array[j]+array[k];
				if(y == sum-x)return true;
				else if(y < sum-x) {
					j++;
				}
				else if(y > sum-x) {
					k--;
				}
			}
		}
		return false;
		
	}
	
	
	public static void main(String[] args) {
		
		int array[] = {1, 2, 8, 5, 3, 9};
		Arrays.sort(array);
		System.out.println(findTriplet(array, 10));
	}
	
	
}
