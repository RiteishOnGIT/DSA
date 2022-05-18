package tree;

import java.util.ArrayList;
import java.util.TreeMap;

public class VerticalSum {
	
	
	public static TreeMap<Integer, Integer> result = new TreeMap<Integer, Integer>();
	
	
	public static void verticalSum(Node root, Integer horizontalDistance) {
		if(root  == null)return;
		
		if(result.get(horizontalDistance) == null) {
			result.put(horizontalDistance, root.data);
		}
		else {
			result.put(horizontalDistance, result.get(horizontalDistance)+root.data);
		}
		verticalSum(root.leftNode, horizontalDistance-1);
		verticalSum(root.rightNode, horizontalDistance+1);
		
	}
	
	
	
	public static void main(String[] args) {
		Node node = new Node(1);
		node.leftNode = new Node(2);
		node.rightNode = new Node(3);
		node.leftNode.leftNode = new Node(4);
		node.leftNode.rightNode = new Node(5);
		node.rightNode.leftNode = new Node(6);
		node.rightNode.rightNode = new Node(7);
		verticalSum(node, 0);
		
		ArrayList<Integer>list = new ArrayList<Integer>();
		
		for(java.util.Map.Entry<Integer, Integer> e: result.entrySet()) {
			list.add(e.getValue());
		}
	}
	
	
}
