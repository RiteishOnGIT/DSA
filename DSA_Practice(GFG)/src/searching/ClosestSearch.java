package searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestSearch {
	
	public static int closestBinarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            
            if (arr[mid] == x)
                return mid;
 
            if (arr[mid] > x)
                return closestBinarySearch(arr, l, mid - 1, x);
 
            return closestBinarySearch(arr, mid + 1, r, x);
        }
 
        return l;
    }
	
	
	public static void main(String[] args) {
		
		int array[] = {1,2 ,3 ,4, 5};
		int x = 3;
		int k = 4;
		int center = closestBinarySearch(array, 0, array.length-1, x);
		int left = center - 1;
		int right;
		if(center == array.length) {
			right = center+1;
		}
		else if(array[center] == x) {
			right = center + 1;
			k--;
		}
		else {
			right = center;
		}
		List<Integer> resultArray = new ArrayList<Integer>();
		
		int i=0;
		int leftMin = Integer.MAX_VALUE, rightMin = Integer.MAX_VALUE;
		while(i != k) {
			leftMin = Integer.MAX_VALUE;
			rightMin = Integer.MAX_VALUE;
			if(left >= 0) {
				leftMin = x -array[left];
			}
			if(right < array.length) {
				rightMin = array[right] - x;
			}
			if(leftMin == rightMin) {
				if(array[left] > array[right]) {
					resultArray.add(array[left]);
					left--;
				}
				else {
					resultArray.add(array[right]);
					right++;
				}
			}
			else {
				if(leftMin < rightMin) {

					resultArray.add(array[left]);
					left--;
				}
				else {
					resultArray.add(array[right]);
					right++;
				}
			}
			i++;
		}
		
		Collections.sort(resultArray);
		System.out.println(resultArray);
		
		
	}
	
}
