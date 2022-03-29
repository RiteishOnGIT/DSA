package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {

	
	public static int[][] mergeIntervals(int array[][], int n){
		
		Arrays.sort(array, (a, b) -> {
			if(a[0] < b[0]) {
				return -1;
			}
			else if(a[0] > b[0]) {
				return 1;
			}
			else {
				if(a[1] < b[1])return -1;
				if(a[1] > b[1])return 1;
				return 0;
			}
		});
		
		ArrayList<ArrayList<Integer>>result = new ArrayList<ArrayList<Integer>>(0);
		
		int front = array[0][0];
		int back = array[0][1];
		
		for(int i=1; i<array.length; i++) {
			if(back >= array[i][0]) {
				if(back < array[i][1])back = array[i][1];
			}
			else{
				result.add(new ArrayList<Integer>(List.of(front, back)));
				front = array[i][0];
				back = array[i][1];
			}
		}
		result.add(new ArrayList<Integer>(List.of(front, back)));
		int finalArray[][] = new int[result.size()][2];
		for(int i=0; i<result.size(); i++) {
			finalArray[i][0] = result.get(i).get(0);
			finalArray[i][1] = result.get(i).get(1);
		}
		
		return finalArray;
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		
		int array[][] = {{1, 3},{2, 6}, {8,10}, {15,18}};
		int[][] result = mergeIntervals(array, array.length);
		
		for(int i=0; i<result.length; i++) {
			System.out.println(result[i][0]+" "+result[i][1]);
		}
	}
	
}
