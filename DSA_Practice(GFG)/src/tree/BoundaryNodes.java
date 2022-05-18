package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BoundaryNodes {

	public static ArrayList<Integer>result = new ArrayList<Integer>();
	static List<Integer> resIntegers = new ArrayList<Integer>();
	
	public static void printLeft(Node root) {
		if(root != null) {
			if(root.leftNode != null) {
				result.add(root.data);
				printLeft(root.leftNode);
			}
			else if(root.rightNode != null) {
				result.add(root.data);
				printLeft(root.rightNode);
			}
		}
	}
	
	public static void printRight(Node root) {
		if(root != null) {
			if(root.rightNode != null) {
				result.add(root.data);
				printLeft(root.rightNode);
			}
			else if(root.leftNode != null) {
				result.add(root.data);
				printLeft(root.leftNode);
			}
		}
		
	}
	
	public static void printMiddle(Node root) {
		if(root == null)return;
		printMiddle(root.leftNode);
		if(root.leftNode == null && root.rightNode == null) {
			result.add(root.data);
		}
		printMiddle(root.rightNode);
		
	}
	
	public static void printBoundary(Node root) {
		printLeft(root.leftNode);
		printMiddle(root);
		printRight(root.rightNode);
	}
	
	
	
	public static void iterativePreOrder(Node root) {
		
		ArrayDeque<Node> deque = new ArrayDeque<Node>();
		deque.add(root);
		resIntegers.add(root.data);
		System.out.println(root.data);
		boolean isOk = false;
		while(!deque.isEmpty()) {
			root = deque.peekFirst();
			if(root.leftNode != null) {
				resIntegers.add(root.leftNode.data);
				System.out.println(root.leftNode.data);
				deque.addFirst(root.leftNode);
				root.leftNode = null;
			}
			else {
				root =  deque.pollFirst();
				if(root.rightNode != null) {
					resIntegers.add(root.rightNode.data);
					System.out.println(root.rightNode.data);
					deque.addFirst(root.rightNode);
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		Node node = new Node(4);
		node.leftNode = new Node(5);
		node.rightNode = new Node(6);
		node.leftNode.leftNode = new Node(7);
		node.leftNode.rightNode = new Node(8);
		node.leftNode.rightNode.leftNode = new Node(1);
		
		//printBoundary(node);
		//System.out.println(result);
		iterativePreOrder(node);
		System.out.println(resIntegers);
	}

}
