package tree;

public class Node {
	
	int data;
	Node leftNode;
	Node rightNode;
	
	public Node() {
		// TODO Auto-generated constructor stub
	}
	
	public Node(int data) {
		this.data = data;
		leftNode = null;
		rightNode = null;
	}
	
	public Node(int data, Node leftNode, Node rightNode) {
		this.data = data;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
	
	
}
