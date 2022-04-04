package arrays;

public class MoveAllNegativeElementsToTheEnd {
	
	
	
	
	public static void main(String[] args) {
		
		int array[] = {1, -2, -3, 5, 1, -3};
		
		
		int low = -1, high= array.length;
		
		while(low <= high) {
			
			do {low++;}while(array[low] < 0);
			
			do {high--;}while(array[high] > 0);
			if(low > high)break;
			int temp =array[low];
			array[low] = array[high];
			array[high] = temp;
			
		}
		
		for(int i=0; i<array.length; i++)System.out.print(array[i]+" ");
		
	}
	
}
