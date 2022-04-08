package sorting;

public class ShortestContinousUnsortedarray {
	
	
	public static void getMax(int array[]) {
		
		int largest_array=0;
		int last_index = array.length-1;
		int min = array[array.length-1];
		boolean setter = false;
		
		for(int i = array.length - 2; i>=0; i--) {
			if(array[i] <= min && array[i] <= array[last_index]) {
				min = array[i];
				if(setter == false)
					last_index = i;
			}
			else if(array[i] > min && array[i] <= array[last_index]) {
				largest_array = Math.max(largest_array, last_index-i+1);
			}
			else {
				while(array[i] > array[last_index] && last_index<array.length) {
					last_index++;
					setter = true;
					if(last_index >= array.length)break;
				}
				last_index--;
				array[last_index] = array[i];
				largest_array = Math.max(largest_array, last_index-i+1);
			}
			
		}
		System.out.println(largest_array);
		
	}
	
	
	
	public static void main(String[] args) {
		int array[] = {10,11,21,13,14,15};
		getMax(array);
 	}
	
}
