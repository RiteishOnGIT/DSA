package arrays;

import java.util.List;
import java.util.Vector;

public class SmallestNextPalindrome {

	
	public static Vector<Integer> smallestNext(int array[], int n) {
		if(array.length == 1 && array[0] == 9)return new Vector<Integer>(List.of(1, 1));
		boolean inFavour = false;
		boolean NotInFavour = true;
		int mid;
		int left;
		int right;
		int tempLeft;
		int tempRight;
		if (n % 2 == 0) {
			mid = (n / 2) - 1;
			left = mid;
			right = mid + 1;
		} else {
			mid = n / 2;
			left = mid - 1;
			right = mid + 1;
		}
		tempLeft = left;
		tempRight = right;
		while (left >= 0) {
			if (array[left] > array[right]) {
				inFavour = true;
				break;
			} else if (array[left] < array[right]) {
				NotInFavour = true;
				break;
			}
			left--;
			right++;
		}
		if (inFavour) {
			array = editedArray(array, true, tempLeft, tempRight);
		} else if (NotInFavour) {
			array = editedArray(array, false, tempLeft, tempRight);
		}
		
		Vector<Integer> result = new Vector<Integer>();
		for(int i=0; i<array.length; i++) {
			result.add(array[i]);
		}
		return result;
	}


	public static int[] editedArray(int array[], boolean favour, int left, int right) {
		int tempLeft = left;
		int tempRight = right;
		if(favour) {
			while(left >= 0) {
				array[right++] = array[left--];
			}
		}
		else {
			if(array.length % 2 != 0) {
				tempLeft++;
			}
			while(array[tempLeft] == 9) {
				array[tempLeft] = 0;
				tempLeft--;
				if(tempLeft < 0)break;
			}
			if(tempLeft < 0) {
				int ninesArray [] = new int[array.length+2];
				ninesArray [0] =1;
				ninesArray[ninesArray.length-1] = 1;
				for(int i=1; i<ninesArray.length-2; i++)ninesArray[i] = 0;
				return ninesArray;
			}
			else {
				array[tempLeft] += 1;
				while(left >= 0) {
					array[tempRight++] = array[left--];
				}
			}
		}
		return array;
		
	}

	public static void main(String[] args) {
		int array[] = {1, 2, 3 ,4, 9,9, 4, 3, 2 ,1};
		System.out.println(smallestNext(array, array.length));
	}

}
