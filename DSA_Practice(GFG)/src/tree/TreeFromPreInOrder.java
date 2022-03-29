package tree;

public class TreeFromPreInOrder {

	static int preorderIndex=0;
	public static int findElement(int []inorder, int low, int high, int element) {
		
		for(int i=low; i<=high; i++) {
			if(inorder[i] == element)return i;
		}
		return -1;
	}
	
	public static Node preIn(int[] preorder, int[] inorder, int i, int low, int high) {
		if(low > high) {
			preorderIndex--;			
			return null;
		}
		if(preorder.length != inorder.length)return null;
		if(preorder.length == 1)return new Node(preorder[i]);
		
		Node parent = new Node(preorder[i]);
		int index = findElement(inorder, low, high, preorder[i]);
		if(low < high) {
			parent.leftNode = preIn(preorder, inorder, ++preorderIndex, low, index-1);
			parent.rightNode = preIn(preorder, inorder, ++preorderIndex , index+1, high);
		}
		
		return parent;
		
	}
	
	
	
	public static void main(String[] args) {
		
		int[] preorder = {10, 20, 30};
		int[] inorder = {10, 20, 30};
		preIn(preorder, inorder, 0, 0, preorder.length-1);
		
		
	}

}
