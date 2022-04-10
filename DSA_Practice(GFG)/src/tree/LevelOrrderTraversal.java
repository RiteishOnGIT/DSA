package tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrrderTraversal {
	
	
	public static void levelOrder(Node root) {
		
		if(root == null)return;
		
		Queue<Node> queue = new ArrayDeque<Node>();
		int level = 0;
		queue.add(root);
		int size = 1;
		@SuppressWarnings("unused")
		int sum = Integer.MIN_VALUE;
		while(queue.isEmpty() == false) {
			size = queue.size();
			@SuppressWarnings("unused")
			int innerSum =  0;
			while(size != 0) {
				Node temp  = queue.poll();
				innerSum += temp.data;
				if(temp.leftNode != null)queue.add(temp.leftNode);
				if(temp.rightNode != null)queue.add(temp.rightNode);
				size--;
			}
			
			
		}
		
		System.out.println(level);
		
	}
	
	
	
	public static void main(String[] args) {
		
		Node rootNode = new Node(1);
		rootNode.leftNode = new Node(7);
		rootNode.rightNode = new Node(0);
		rootNode.leftNode.leftNode = new Node(7);
		rootNode.leftNode.rightNode = new Node(-8);
		levelOrder(rootNode);
	}
	
	
}
