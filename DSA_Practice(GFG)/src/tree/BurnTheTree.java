package tree;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class BurnTheTree {
	
	static boolean found = false;
	
	static HashSet<Integer>visited = new HashSet<Integer>();
	
	static Queue<Node> queue = new ArrayDeque<Node>();
	public static void burnItDown(Node root, Node prev, int target) {
		
		if(root == null)return;
		
		if(root.data == target) {
			if(root.leftNode == null && root.rightNode == null) {
				queue.add(prev);
				visited.add(prev.data);
			}
			System.out.println(root.data+" ");
			visited.add(root.data);
			found = true;
		}
		

		if(found != true) burnItDown(root.leftNode, root, target);
		if(found != true) burnItDown(root.rightNode, root, target);
		
		
		
		//if(prev == null)return;
		if(found == true) {
			
			
			
			if(root.leftNode != null) {
				if(!visited.contains(root.leftNode.data)) {
					queue.add(root.leftNode);
				}
			}
			if(root.rightNode != null) {
				if(!visited.contains(root.rightNode.data)) {
					queue.add(root.rightNode);
				}
			}
			if(prev != null) {
				if(!visited.contains(prev.data)) {
					queue.add(prev);
				}
			}
				
			
			while(!queue.isEmpty() || prev != null) {
				Node resNode = queue.poll();
				if(prev != null) {
					if(resNode.data == prev.data) {
						System.out.println(resNode.data+" ");
						visited.add(prev.data);
						return;
					}
				}
				
				System.out.print(resNode.data+" ");
				if(resNode.leftNode != null) {
					queue.add(resNode.leftNode);
					visited.add(resNode.leftNode.data);
				}
				if(resNode.rightNode != null) {
					queue.add(resNode.rightNode); 
					visited.add(resNode.rightNode.data);
				}
			}
			
		}
	}
	
	
	
	
	public static void main(String[] args) {
		
		Node rootNode = new Node(12);
		rootNode.leftNode = new Node(13);
		rootNode.leftNode.leftNode = new Node(4);
		rootNode.leftNode.rightNode = new Node(40);
		rootNode.leftNode.leftNode.leftNode = new Node(41);
		rootNode.rightNode = new Node(10);
		rootNode.rightNode.leftNode = new Node(14);
		rootNode.rightNode.leftNode.leftNode = new Node(21);
		rootNode.rightNode.leftNode.rightNode = new Node(24);
		rootNode.rightNode.rightNode = new Node(15);
		rootNode.rightNode.rightNode.leftNode = new Node(22);
		rootNode.rightNode.rightNode.rightNode = new Node(23);
		rootNode.rightNode.rightNode.rightNode.rightNode = new Node(223);
		rootNode.rightNode.rightNode.rightNode.rightNode.rightNode = new Node(123);
		rootNode.rightNode.rightNode.rightNode.rightNode.rightNode.rightNode = new Node(323);
		
		
		burnItDown(rootNode, null, 41);
		
		
	}
	
	
}
