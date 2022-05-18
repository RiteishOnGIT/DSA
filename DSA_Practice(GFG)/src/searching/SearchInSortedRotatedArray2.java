package searching;

public class SearchInSortedRotatedArray2 {
	
	
	public static boolean getRes(int nums[], int target) {
		int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            
            if(nums[mid] == target || nums[low] == target || nums[high] == target)return true;
            else if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                int tempMid = mid;
                while(tempMid < high){
                    if(nums[tempMid] == target)return true;
                    tempMid++;
                }
                if(tempMid == high){
                    high = mid-1;
                }
            }
            else if(nums[low] <= nums[mid]){
                if(target <= nums[mid] && target >= nums[low]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{
                if(target >= nums[mid] && target<= nums[high]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
            
        }
        return false;
	}
	
	
	public static void main(String[] args) {
		
		int array[] = {1, 1, 0, 1, 1, 1, 1, 1};
		getRes(array, 0);
		
	}
	
}
