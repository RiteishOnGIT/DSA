package tree;

public class KthSmallestElementITree {
	
	public static int counter = 0;
	private static Integer resultInteger = -1;
	
	static void setTheValue(int val) {
		if(resultInteger == -1)resultInteger = val;
	}
	
	 static void findKthSmallest(Node root, int k) {
		
		if(root == null)return ;
		
		
		findKthSmallest(root.leftNode, k);
		if(counter == k) {
			setTheValue(root.data);
		}
		counter++;
		if(counter == k) {
			setTheValue(root.data);
		}
		findKthSmallest(root.rightNode, k);
		if(counter == k) {
			setTheValue(root.data);
		}
	}
	
	
	public static void main(String[] args) {
		
		Node rootNode = new Node(24);
		rootNode.leftNode = new Node(12);
		rootNode.rightNode = new Node(27);
		rootNode.leftNode.leftNode = new Node(11);
		rootNode.leftNode.rightNode = new Node(13);
		rootNode.rightNode.leftNode = new Node(16);
		rootNode.rightNode.leftNode.leftNode = new Node(15);
		
		findKthSmallest(rootNode, 7);
		System.out.println(resultInteger);
		
		
	}
}
