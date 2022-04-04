package linkedList;

public class DetectingACycle {
	
	
	public static boolean detetctACycle(ListNode head) {
		
		ListNode slowListNode= head;
		ListNode fastListNode = head;
		
		while(slowListNode != null && fastListNode != null && fastListNode.next != null) {
			
			slowListNode = slowListNode.next;
			fastListNode = fastListNode.next.next;
			
			if(slowListNode == fastListNode)return true;
			
			
		}
		return false;
		
	}
	
	
	
	public static void main(String[] args) {
		
	}
	
	
}
