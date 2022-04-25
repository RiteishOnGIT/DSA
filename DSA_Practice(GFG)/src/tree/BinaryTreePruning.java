package tree;

public class BinaryTreePruning {
	
	public static boolean pruning(Node node) {
		if(node == null)return false;
		
		boolean res = false;
		if(node.data == 1)res = true;
		boolean leftRes = pruning(node.leftNode);
		boolean rightRes = pruning(node.rightNode);
		if(leftRes == false)node.leftNode= null;
		if(rightRes == false)node.rightNode= null;
		
		return res || leftRes||rightRes;
	}
	
	
	public static void main(String[] args) {
		
		Node rootNode = new Node(1);
		rootNode.leftNode = new Node(0);
		rootNode.rightNode = new Node(1);
		rootNode.leftNode.leftNode = new Node(0);
		rootNode.leftNode.rightNode = new Node(1);
		rootNode.rightNode.leftNode = new Node(0);
		rootNode.rightNode.rightNode = new Node(1);
		
		pruning(rootNode);
	}
	
}
