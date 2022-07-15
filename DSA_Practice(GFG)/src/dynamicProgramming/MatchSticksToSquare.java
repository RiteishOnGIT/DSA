package dynamicProgramming;

import java.util.Arrays;

public class MatchSticksToSquare {
	
	
	public static boolean isPossible(boolean visited[], int arr[], int n, int sum, int element) {
		if(sum == element)return true;
		if(n < 0 )return false;
		if(visited[n] == true)return isPossible(visited, arr, n-1, sum, element);
		
		
		if(arr[n] <= element - sum) {
			if(isPossible(visited, arr, n-1, sum+arr[n], element)) {
				visited[n] = true;
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return isPossible(visited, arr, n-1, sum, element);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		int arr[] = {1, 1,1,1,2, 2, 4};
		Arrays.sort(arr);
		
		boolean visisted[] = new boolean[arr.length];
		Arrays.fill(visisted, false);
		
		int i=arr.length-2;
		int k = 0;
		while( i>= 0) {
			if(visisted[i] == false) {
				visisted[i] = true;
				if(!(isPossible(visisted, arr, i-1, arr[i], arr[arr.length-1]))) {
					break;
				}
				k++;
			}
			i--;
		}
		
		if(k == 3)System.out.println(true);
		else System.out.println(false);
	}
	
}
