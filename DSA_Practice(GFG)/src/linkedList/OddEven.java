package linkedList;

public class OddEven {
	
	
	
	public static ListNode oddEven(ListNode root) {
		
		ListNode first = root;
		ListNode second = first.next;
		ListNode tempForFirst = first;
		ListNode tempforSecond = second;
		ListNode temp = first;
		boolean switchOddEven = true;
		
		while(temp.next != null) {
			temp = temp.next;
			if(switchOddEven == true) {

				if(tempforSecond.next == null) {
					tempForFirst.next = null;
					break;
				}
				tempForFirst.next = tempforSecond.next;
				tempForFirst = tempForFirst.next;
				switchOddEven = false;
			}
			else {
				if(tempForFirst.next == null) {
					tempforSecond.next = null;
					break;
				}
				tempforSecond.next = tempForFirst.next;
				tempforSecond = tempforSecond.next;
				switchOddEven = true;
			}
			
		}
		tempForFirst.next = second;
		return first;
		
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		ListNode rootListNode = new ListNode(1);
		rootListNode.next = new ListNode(2);
		rootListNode.next.next = new ListNode(3);
		
		
		rootListNode  = oddEven(rootListNode);
		while(rootListNode != null) {
			System.out.println(rootListNode.val);
			rootListNode = rootListNode.next;
		}
		
		
		
	}
	
	
	
}
