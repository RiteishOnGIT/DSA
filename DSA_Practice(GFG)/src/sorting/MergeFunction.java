package sorting;

public class MergeFunction {

	
	public static int mergeTwoArrays(int [] array, int low, int mid, int high) {
		int inversions = 0;
		if(low == array.length-1)return 0;
		int left[] = new int[mid -low+1];
		int right[] = new int[high-mid];
		int k = 0;
		int temp[] = new int[high - low+1];
		int a  =low;
		int b = high;
		int i=0;
		while(low <= mid)left[i++] = array[low++];
		i=0;
		mid++;
		while(mid <= high)right[i++] = array[mid++];
		i=0;
		int j =0;
		while(i < left.length && j < right.length) {
			if(left[i] <= right[j]) {
				temp[k++] = left[i++];
			}
			else {
				temp[k++] = right[j++];
				inversions += left.length - i;
			}
		}
		
		while(i < left.length)temp[k++] = left[i++];
		while(j < right.length)temp[k++]= right[j++];
		i = 0;
		while(a <= b) {
			array[a++] = temp[i++];
		}
		return inversions;
	}
	
	public static void main(String[] args) {
		
		int array[] = {2, 3, 4, 10 ,10, 10};
		
		System.out.println(mergeTwoArrays(array, 0, ((array.length)/2)-1, array.length-1));
		for(int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}
		
	}

}
