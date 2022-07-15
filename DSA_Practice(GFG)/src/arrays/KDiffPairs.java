package arrays;

import java.util.Arrays;

public class KDiffPairs {
	
	public static int kDiff(int arr[], int k) {
		
		Arrays.sort(arr);
		int count = 0;
		int i=0,j=1;
		while(j < arr.length && i<=j) {
			if(i == j) {
				j++;
				continue;
			}
			if(Math.abs(arr[i]-arr[j]) > k) {
				i++;
			}
			else if(Math.abs(arr[i]-arr[j]) < k)j++;
			else if(Math.abs(arr[i]-arr[j]) == k) {
				if(i+1 < arr.length && i<= j) {
					while(i < j && arr[i] == arr[i+1]) {
						i++;
					}
				}
				if(j+1 < arr.length) {
					while(j+1 < arr.length && arr[j] == arr[j+1])j++;
				}
				count++;
				j++;
				i++;
			}
		}
		return count;
		
	}
	
	
	
	
	public static void main(String[] args) {
		int arr[] = {1,1,1,1,1,2,2};
		System.out.println(kDiff(arr, 0));
	}
	
	
	
}
