package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class NAryTreePostorderIter {
	
	public static List<Integer> getPostOrder(TreeNode root){
		
		ArrayDeque<TreeNode> ad = new ArrayDeque<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)return result;
		ad.add(root);
        if(root.val == 0)root.val =-1000001;
		else root.val = -root.val;
		while(! ad.isEmpty()) {
			TreeNode tempNode = ad.pollLast();
			List<TreeNode> elements = tempNode.children;
			
			if(elements.size() == 0){
                if(tempNode.val == -1000001)result.add(0);
                else result.add(Math.abs(tempNode.val));
			}
            
            else if(tempNode.children.get(0).val < 0){
                if(tempNode.val == -1000001)result.add(0);
                else result.add(Math.abs(tempNode.val));
            }
            
			else {
				ad.add(tempNode);
				for(int i=elements.size()-1; i>=0; i--) {
					TreeNode t = elements.get(i);
					if(t.val >= 0) {
						ad.add(t);
                        if(t.val == 0)t.val = -1000001;
						else t.val = -t.val;
					}
					else {
						break;
					}
				}
			}
			
		}
		return result;
		
	}
	
	
	public static void main(String[] args) {	
		
		int a = -0;
		System.out.println(a);
	}
	
	
}
