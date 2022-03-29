package tree;

public class NodesAtKDistance {

	static Node resultNode = null;
	static Node lastDataNode = null;
	static Node DontrecurNode = null;
	static int distanceNode = 4;

	public static void findKDistanceFromRoot(Node root, int k, Node dontRecur) {
		if (k == -1 || root == null)
			return;

		if (k == 0) {
			System.out.println(root.data);
			return;
		}

		else {
			if (root.leftNode != dontRecur) {
				findKDistanceFromRoot(root.leftNode, k - 1, dontRecur);
			}
			if (root.rightNode != dontRecur) {
				findKDistanceFromRoot(root.rightNode, k - 1, dontRecur);
			}
		}
	}

	public static void findKDistanceFromTargetNode(Node root, int target) {
		if (root == null)
			return;
		if (root.data == target) {
			lastDataNode = root;
			DontrecurNode = root;
			System.out.println(root.data);
		}
		
		if (lastDataNode == null) {
			findKDistanceFromTargetNode(root.leftNode, target);
		}
		
		if (lastDataNode == null) {
			findKDistanceFromTargetNode(root.rightNode, target);
		}
		
		if (lastDataNode != null) {
			findKDistanceFromRoot(root, distanceNode, DontrecurNode);
			DontrecurNode = root;
			distanceNode--;
		}
	}

	public static void main(String[] args) {

		Node node = new Node(1);
		//node.leftNode = new Node(7);
		node.rightNode = new Node(2);
		//node.leftNode.leftNode = new Node(4);
		//node.leftNode.rightNode = new Node(3);
		//node.leftNode.rightNode.leftNode = new Node(1);
		node.rightNode.rightNode= new Node(3);
		node.rightNode.rightNode.leftNode= new Node(4);
		node.rightNode.rightNode.leftNode.rightNode= new Node(5);
		
		/*
		 * node.rightNode.leftNode = new Node(55); node.rightNode.leftNode.leftNode =
		 * new Node(56); node.rightNode.rightNode = new Node(50);
		 * node.rightNode.rightNode.rightNode = new Node(13);
		 * node.rightNode.rightNode.rightNode.leftNode = new Node(16);
		 * node.rightNode.rightNode.rightNode.rightNode = new Node(17);
		 */
		findKDistanceFromTargetNode(node, 5);
	}

}
