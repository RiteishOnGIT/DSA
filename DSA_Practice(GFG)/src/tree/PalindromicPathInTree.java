package tree;

public class PalindromicPathInTree {
	
	public static int findPalidromicPaths(Node root,int array[]) {
		if(root == null)return 0;
		
		if(root.leftNode == null && root.rightNode==null) {
			array[root.data]++;
			int oddCounts = 0;
			for(int i=1; i<=9; i++) {
				if(array[i] % 2 != 0) {
					oddCounts++;
				}
			}
			array[root.data]--;
			if(oddCounts >=2)return 0;
			else return 1;
		}
		
		array[root.data]++;
		int sum = findPalidromicPaths(root.leftNode, array)+
				  findPalidromicPaths(root.rightNode, array);
		array[root.data]--;
		return sum;
	}
	
	
	
	public static int numberOfPaths(Node root) {
		
		int array[] = new int [10];
		return findPalidromicPaths(root, array);
		
		
	}
	
	public static void main(String[] args) {
		
		
		Node root = new Node(3);
		root.leftNode = new Node(3);
		root.rightNode = new Node(1);
		root.leftNode.leftNode = new Node(3);
		root.leftNode.rightNode= new Node(3);
		root.rightNode.rightNode = new Node(1);
		root.rightNode.rightNode.rightNode = new Node(3);
		root.rightNode.rightNode.rightNode.rightNode = new Node(3);
		root.rightNode.rightNode.rightNode.rightNode.rightNode = new Node(2);
		
		System.out.println(numberOfPaths(root));
		
	}
	
	
}
