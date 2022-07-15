package linkedList;

import tree.Node;

public class ReorderList {

	
	
	public static ListNode findMiddle(ListNode node) {
		
		ListNode fast = node;
		ListNode slow = node;
		ListNode prev = slow;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}
		return prev;
	}
	
	public static ListNode reverseList(ListNode listNode) {
		
		ListNode first = listNode;
		ListNode current = null;
		ListNode prev = null;
		
		while(first != null) {
			prev = current;
			current = first;
			first = first.next;
			current.next = prev;
			
		}
		return current;
	}
	
	
	public static void main(String[] args) {
		
		ListNode listNode = new ListNode(1);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(3);
		listNode.next.next.next = new ListNode(4);
		//listNode.next.next.next.next = new ListNode(5);
		//listNode.next.next.next.next.next = new ListNode(6);
		//listNode.next.next.next.next.next.next = new ListNode(7);
		
		ListNode lastNode = findMiddle(listNode);
		lastNode.next = reverseList(lastNode.next);
		
		ListNode temp1 = listNode;
		ListNode temp2 = lastNode.next;
		ListNode temp3 = temp1.next;
		ListNode temp4 = temp2.next;
		
		while(temp1 != lastNode && temp2 != null) {
			temp1.next = temp2;
			temp2.next = temp3;
			temp1 = temp3;
			temp2 = temp4;
			temp3 = temp3.next;
			temp4 = temp4.next;
		}
		temp1.next = temp2;
		
		
	}

}
