package tree;

class List{
	int count;
	int min;
	int max;
	Boolean isBst;
	
	public List(int count, int min, int max, Boolean isBst) {
		super();
		this.count = count;
		this.min = min;
		this.max = max;
		this.isBst = isBst;
	}
	
	@Override
	public String toString() {
		return count+" "+min+" "+max+" "+isBst;
	}
}

public class LargestBstInBinaryTree {
	
	
	
	public static List getLargestBst(Node root) {
		if(root == null)return new List(0, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
		if(root.leftNode == null & root.rightNode == null) {
			return new List(1, root.data, root.data, true);
		}
		List left = getLargestBst(root.leftNode);
		List right = getLargestBst(root.rightNode);
		
		int count = left.count+right.count+1;
		
		if(left.isBst == true && right.isBst == true) {
			if(left.max < root.data && right.min > root.data) {
				return new List(count, Math.max(left.max, right.max), Math.min(left.min, right.min) , true);
			}
			
		}
		return new List(count, Integer.MIN_VALUE, Integer.MAX_VALUE, false);
		
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
		System.out.println(getLargestBst(node));
		
	}
	
}
