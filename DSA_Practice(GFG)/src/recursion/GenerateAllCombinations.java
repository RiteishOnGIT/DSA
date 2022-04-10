package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllCombinations {
	
	
    public static List<List<Integer>> demo(int k, int n, ArrayList<Integer>list, List<List<Integer>> resultList){
        
        if(n < 0)return resultList;
        
        if(k == 0){
        	ArrayList<Integer> newaArrayList = new ArrayList<Integer>();
        	for(int i=0;i<list.size(); i++) {
        		newaArrayList.add(list.get(i));
        	}
            resultList.add(newaArrayList);
            return resultList;
        }
        
        list.add(n);
        demo(k-1, n-1, list, resultList);
        list.remove(list.size()-1);
        demo(k, n-1, list, resultList);
        return resultList;
    }
	
	
	
	
	public static void main(String[] args) {
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		resultList =  demo(2, 4, new ArrayList<Integer>(), resultList);
		System.err.println(resultList);
	}
	
}
