package tree;

public class PrintNodesAtKdistanceFromLeaf {
	
	static int lowPass = 4;
	static int highPass = 4;
	
	public static int leaftToK(Node root) {
		if(root == null)return 0;
		int lh = leaftToK(root.leftNode);
		int rh = leaftToK(root.rightNode);
		if(lh == 0 && rh == 0)return 1;
		int temp1 = lowPass;
		int temp2 = highPass;
		if(lh != 0 && rh != 0) {
			if(lh > rh) {
				lowPass = highPass-lh;
			}
			else if(rh > lh) {
				lowPass = highPass-rh;
			}
		}
		
		if(lh == lowPass || rh == lowPass) {
			System.out.println(root.data);
			lowPass = highPass;
		}
		else if(lh == highPass || rh == highPass) {
			System.out.println(root.data);
		}
		if(lh == 0 || rh == 0)return 1+Math.max(lh, rh);
		return 1+Math.min(lh, rh);
		
	}
	
	
	
	public static void main(String[] args) {
		Node node = new Node(1);
		node.leftNode = new Node(7);
		node.rightNode = new Node(2);
		node.rightNode.leftNode = new Node(2);
		node.leftNode.leftNode = new Node(4);
		node.leftNode.rightNode = new Node(3);
		node.leftNode.rightNode.leftNode = new Node(1);
		node.rightNode.rightNode= new Node(3);
		node.rightNode.rightNode.leftNode= new Node(4);
		node.rightNode.rightNode.rightNode= new Node(2);
		node.rightNode.rightNode.leftNode.rightNode= new Node(5);
		leaftToK(node);
	}
	
}
