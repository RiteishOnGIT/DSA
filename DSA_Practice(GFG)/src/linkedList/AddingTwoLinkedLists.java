package linkedList;

public class AddingTwoLinkedLists {
	
	static int carry = 0;
	public static ListNode getAddition(ListNode l1, ListNode l2, int act, int diff) {
		
		if(l1 == null && l2 == null)return null;
		
		ListNode headListNode = new ListNode();
		
		if(act == diff) {

			headListNode.next = getAddition(l1.next, l2.next, act+1, diff+1);
			int value = l1.val+l2.val+carry;
			if(value <= 9)carry = 0;
			else if(value > 9) {
				carry = 1;
				value = value%10;
			}
			headListNode.val = value;
			
		}
		else {

			headListNode.next = getAddition(l1.next, l2, act+1, diff);
			int value = l1.val+carry;
			if(value <= 9)carry = 0;
			else if(value > 9) {
				carry = 1;
				value = value%10;
			}
			headListNode.val = value;
		}
		return headListNode;
	}
	
	
	
	public static int getLength(ListNode root) {
		
		ListNode tempListNode = root;
		int counter = 0;
		while(tempListNode != null) {
			tempListNode = tempListNode.next;
			counter++;
		}
		return counter;
		
	}
	
	public static void main(String[] args) {
		ListNode rootListNode = new ListNode(5);
		rootListNode.next = new ListNode(5);
		rootListNode.next.next = new ListNode(5);
		ListNode rootListNode2 = new ListNode(5);
		rootListNode2.next = new ListNode(5);
		rootListNode2.next.next = new ListNode(5);
		
		int length1 = getLength(rootListNode);
		int length2 = getLength(rootListNode2);
		
		System.out.println(length1 - length2);
		if(length1 < length2) {
			getAddition(rootListNode2, rootListNode, 0, length2-length1);
		}
		else {
			getAddition(rootListNode, rootListNode2, 0, length1-length2);
		}
	}
	
}
