package tree;

public class CreatingBsts {

	
	public static void binaryTreeCreation(Node head, Node root, int n, int counter) {
		if(n == 0) {
			printBst(head);
			System.out.println();
			return;
		}
		
		root.leftNode = new Node(counter);
		binaryTreeCreation(head, root.leftNode, n-1, counter+1);
		root.leftNode = null;
		root.rightNode = new Node(counter);
		binaryTreeCreation(head, root.rightNode, n-1, counter+1);
		root.rightNode =null;
		
		if(n >= 2) {
			root.leftNode = new Node(counter);
			root.rightNode = new Node(counter+1);
			binaryTreeCreation(head, root.leftNode, n-2, counter+2);
			binaryTreeCreation(head, root.rightNode , n-2, counter+2);
			
		}
		
	}
	
	
	
	public static void bstCreation(Node head, boolean visited[], int n, Node root, int counter) {
		
		if(n == counter) {
			printBst(head);
			System.out.println();
			return;
		}
		
		for(int i=1; i<= n; i++) {
			if(visited[i]== false) {
				visited[i] = true;
				if(i < root.data) {
					root.leftNode = new Node(i);
					bstCreation(head, visited, n, root.leftNode, counter+1);
					}
				visited[i] = false;
			}
		}
		for(int i=1; i<= n; i++) {
			if(visited[i]== false) {
				visited[i] = true;
				if(i  >root.data) {
					root.rightNode = new Node(i);
					bstCreation(head, visited, n, root.rightNode, counter+1);
				}
				visited[i] = false;
			}
		}
		
	}
	

	
	public static void createBst(int n) {
		
		boolean visited[];
		
		for(int i=2; i<= n+1; i++) {
			visited = new boolean[n+1]; 
			visited[i-1] = true;
			Node rootNode = new Node(i-1);
			bstCreation(rootNode, visited, n, rootNode, 1);
			visited[i-1] = false;
		}
		
		
		//Node rootNode = new Node(1);
		//binaryTreeCreation(rootNode, rootNode, n-1, 2);
	}
	
	public static void printBst(Node root) {
		
		if(root ==null)return;
		
		printBst(root.leftNode);
		System.out.print(root.data+" ");
		printBst(root.rightNode);
	}
	
	
	public static void makeBst(Node root, int data) {
		
		if(root == null)return;
		
		if(data < root.data) {
			if(root.leftNode != null) {
				makeBst(root.leftNode, data);
			}
			else {
				root.leftNode = new Node(data);
			}
		}
		else if(root.data < data) {
			if(root.rightNode != null) {
				makeBst(root.rightNode, data);
			}
			else {
				root.rightNode = new Node(data);
			}
		}
		
		
	}
	
	public static void selector(boolean[] visited, int n, int counter ,int index, Node root) {
		
		if(index > n)return ;
		if(counter == n)return;
		
		for(int i=1; i<=n; i++) {
			selector(visited, n, counter, index+1, root);
			if(visited[index] == false) {
				visited[index]  =true;
				makeBst(root, index);
				selector(visited, n, counter+1, index+1, root);
			}
		}
		visited[index] = false;
	}
	
	
	public static void generateTheBST(int n) {
		
		boolean [] visited;
		
		int i=1;
		while(i != n){
			
			Node newRoot = new Node(i);
			visited = new boolean[n+1];
			visited[i] =true;
			selector(visited, n, 1, i+1, newRoot);
			visited[i] = false;
			i++;
			
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//createBst(3);
		generateTheBST(3);
	}

}
