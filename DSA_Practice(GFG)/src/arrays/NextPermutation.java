package arrays;

import java.util.Arrays;

public class NextPermutation {
	
	public static void reverse(int array[], int start , int end) {
		
		while(start <= end) {
			int temp = array[start];
			array[start] = array[end];
			array[end]= temp;
			start++;
			end  --;
		}
		
		
	}
	
	
	
	public static void findNextPermuatation(int array[]) {
		
		int start=0, end=array.length;
		boolean flag = true;
		int i=array.length-1;
		for(i=array.length-1; i>=1; i--) {
			
			if(array[i-1] < array[i]) {
				start = i-1;
                flag = false;
				break;
			}
		}
		
        if(flag == true){
		    Arrays.sort(array, start, end);
        }
        else{
            Arrays.sort(array, start+1, end);
		    for(int j=start+1; j<array.length; j++) {
			    if(array[j] > array[start]) {
				    int temp = array[j];
				    array[j] = array[start];
				    array[start] = temp;
				break;
			    }
		    }
        }
		
	}
	
	
	
	public static void main(String[] args) {
		int array[] = {5, 5, 5, 4, 4, 4, 3, 3, 3};
		findNextPermuatation(array);
	}
	
	
}
