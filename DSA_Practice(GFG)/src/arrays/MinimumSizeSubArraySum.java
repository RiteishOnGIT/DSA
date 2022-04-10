package arrays;

public class MinimumSizeSubArraySum {
	
	public static int minimumSize(int array[] ,int target) {
		
		
		int i=0; 
		int j=0;
		int sum=0;
		int minLength = Integer.MAX_VALUE;
		int flag = 1;
		while(i < array.length) {
			
				sum += array[i];
			
			if(sum >= target) {
				while(j <=i && sum >= target) {
					sum = sum - array[j];
					j++;
				}
				minLength = Math.min(minLength, i-(j-1)+1);
				flag =0;
			}
			i++;
		}
		if(flag == 1)return 0;
		return minLength;
		
	}
	
	
	
	public static void main(String[] args) {
		int arr[] = {1, 1, 1 ,1 ,1 ,1 ,1 ,1};
		System.out.println(minimumSize(arr, 11));
	}
	
	
}
