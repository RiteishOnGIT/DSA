package arrays;

public class MedianOfTwoSortedArrays {

	public static double medianOfTwo(int nums1[], int nums2[]) {
		
		int arr1[], arr2[];
		if(nums1.length > nums2.length) {
			arr1 = nums2;
			arr2 = nums1;
		}
		else {
			arr1 = nums1;
			arr2 = nums2;
		}
		
		int n1 = arr1.length;
		int n2 = arr2.length;
		int begin = 0;
		int end = arr1.length;
		
		while(begin <= end) {
			
			int i1 = (begin+end)/2;
			int i2 = (n1 + n2 +1 )/2 - i1;
			
			int min1 = i1 != n1 ? arr1[i1]: Integer.MAX_VALUE;
			int max1 = i1 > 0 ? arr1[i1-1]: Integer.MIN_VALUE;
			int min2 = i2 != n2 ? arr2[i2]: Integer.MAX_VALUE;
			int max2 = i2 > 0 ? arr2[i2-1]: Integer.MIN_VALUE;
			
			if(max2 <= min1 && max1 <= min2) {
				if((arr1.length + arr2.length)%2 == 0) {
					return (double) (Math.min(min1,  min2) + Math.max(max1, max2))/2;
				}
				else {
					return (double) (Math.max(max2, max1));
				}
			}
			else if(max1 > min2) {
				end = i1-1;
			}
			else {
				begin = i1+1; 
			}
		}
		return -1;
	}
	
	
	
	public static void main(String[] args) {
		int arr1[] = {10, 20, 30};
		int arr2[] = {5, 15 ,25, 35, 45};
		System.out.println(medianOfTwo(arr1, arr2));

	}

}
