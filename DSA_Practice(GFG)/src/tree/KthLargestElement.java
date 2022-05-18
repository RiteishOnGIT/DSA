package tree;

public class KthLargestElement {
	
	static int count = 2;
	static int result;
	public static void  kthLargest(Node root) {
		if(root == null)return;
		
		
		kthLargest(root.rightNode);
		count--;
		System.out.println(count);
		if(count == 0)result = root.data;
		kthLargest(root.leftNode);
	}
	
	
	public static void main(String[] args) {
		Node node = new Node(22);
		node.leftNode = new Node(14);
		kthLargest(node);
		System.out.println(result);
	}
	
}
