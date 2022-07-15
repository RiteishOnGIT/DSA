package additional;

public class TuringQuestion1 {
	
	
	public static void main(String[] args) {
		int array[] = {2 ,2};
		int result[] = new int[2];
		int temp[] = new int[array.length+1];
		for(int i=0; i<array.length; i++) {
			temp[array[i]]++;
		}
		
		for(int i=1; i<temp.length; i++) {
			if(temp[i] > 1) {
				result[0] = i;
			}
			if(temp[i] == 0) {
				result[1] = i;
			}
		}
		System.out.println(result[0] + " "+ result[1]);
		
	}
	
	
}
