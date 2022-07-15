package tree;

import java.util.ArrayList;

public class LeftView {
	
	
	static int level = 0;
	static ArrayList<Integer> res = new ArrayList<Integer>();
	public static void leftView(Node node, int treeLevel) {
		
		if(node == null)return;
		
		if(treeLevel == level) {
			res.add(node.data);
			level++;
		}
		
		leftView(node.leftNode, treeLevel+1);
		leftView(node.rightNode, treeLevel+1);
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		Node rootNode = new Node(1);
		rootNode.leftNode = new Node(2);
		rootNode.rightNode = new Node(3);
		rootNode.leftNode.leftNode = new Node(4);
		rootNode.leftNode.rightNode = new Node(5);
		rootNode.leftNode.rightNode.rightNode = new Node(5);
		leftView(rootNode, 0);
	}
	
}
