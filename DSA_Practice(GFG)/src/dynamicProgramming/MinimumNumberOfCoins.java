package dynamicProgramming;

public class MinimumNumberOfCoins {
	
	public static void findCoins(int nums[], int index, int count, int target) {

		if (target < 0)
			return;
		if (target == 0) {
			System.out.println(count);
		}
		for (int i = index; i < nums.length; i++) {
			if(target - nums[i] >= 0) {
				findCoins(nums, i, count + 1, target-nums[i]);
			}


		}
	}

	public static void main(String[] args) {
		
		int nums [] = {9, 6, 5, 1};
		
		findCoins(nums, 0, 0, 1200);
		
	}
}
