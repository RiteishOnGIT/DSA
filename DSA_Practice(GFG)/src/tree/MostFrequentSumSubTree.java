package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;



public class MostFrequentSumSubTree {
	
	
	public static int getSubtreeSum(HashMap<Integer, Integer> hm, Node root, int sum) {
		if(root == null)return 0;
		int temp = sum;
		sum += getSubtreeSum(hm, root.leftNode, temp);
		sum += getSubtreeSum(hm, root.rightNode, temp);
		
		sum+= root.data;
		if(hm.containsKey(sum)) {
			hm.put(sum, hm.get(sum)+1);
		}
		else {

			hm.put(sum, 1);
		}
		return sum;
	}
	
	
	public static void main(String[] args) {
		
		HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
		
		Node rootNode = new Node(1);
		//rootNode.leftNode = new Node(2);
		//rootNode.leftNode.leftNode = new Node(2);
		//rootNode.leftNode.rightNode = new Node(-2);
		//rootNode.rightNode = new Node(-1);
		getSubtreeSum(hMap, rootNode, 0);
		
		int maxFrequencyTillNow = Integer.MIN_VALUE;
		
		for(Entry<Integer, Integer> e: hMap.entrySet()) {
			if(maxFrequencyTillNow < e.getValue())maxFrequencyTillNow = e.getValue();
		}
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for(Entry<Integer, Integer> e: hMap.entrySet()) {
			if(e.getValue() == maxFrequencyTillNow)ar.add(e.getKey());
		}
		
		int array[] = new int [ar.size()];
		for(int i=0; i<ar.size(); i++)array[i] = ar.get(i);
		
		for(int i=0; i<array.length; i++)System.out.println(array[i]);
		
	}
	
	
}
