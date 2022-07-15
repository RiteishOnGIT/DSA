package hashing;

import java.util.HashMap;

public class SnakeAndLadder {
	static int minThrow(int N, int arr[]){
        // code here
        
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer> ();
        for(int i=0; i<arr.length; i+=2){
            hm.put(arr[i], arr[i+1]);
        }
        
        int count = 0;
        int index = 1;
        while(index < 30){
            int i = 1;
            int maxRes = index;
            while(i != 7){
                int value = index + i;
                if(hm.get(index + i) != null){
                    value = hm.get(index+i);
                }
                maxRes = Math.max(maxRes, value);
                i++;
            }

            index = maxRes;
            
        System.out.println(index);
            count++;
            
            
        }
        
        System.out.println(hm);
        
        return count;
    }
	
	
	public static void main(String[] args) {
		int arr[] = {7, 9, 22, 19, 8, 18, 25, 24};
		
		minThrow(8, arr);
	}
}
