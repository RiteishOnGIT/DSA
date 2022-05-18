package linkedList;

public class MergeSort {
	
	public static ListNode merging(ListNode head1, ListNode head2, int low, int high) {
		int mid = ((high-low)/2 )+ low;
		int midV2 = mid;
		ListNode first = head1;
		ListNode second = head2;
		ListNode third = null;
		ListNode res = null;
		if (first.val < second.val) {
			third = first;
			first = first.next;
			low++;
		} else {
			third = second;
			second = second.next;
			midV2++;
		}
		third.next = null;
		res = third;
		while (first != null && second != null && low < mid && midV2 < high) {
			if (first.val < second.val) {
				third.next = first;
				first = first.next;
				low++;
			} else {
				third.next = second;
				second = second.next;
				midV2++;
			}

			third = third.next;
			third.next = null;
		}
		while (first != null && low < mid) {
			third.next = first;
			first = first.next;
			third = third.next;
			third.next = null;
			low++;
		}

		while (second != null && midV2 < high) {
			third.next = second;
			second = second.next;
			third = third.next;
			third.next = null;
			midV2++;
		}
		return res;
	}
	
	
	public static void mergeFunction(ListNode node, int left, int right){
		
		if(left <= right)return;
		
		int mid = (right - left) /2 ;
		
		mergeFunction(node, left, mid);
		mergeFunction(node, mid+1, right);
		merging(node, node, left, right);
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		ListNode rootListNode = new ListNode(8);
		rootListNode.next = new ListNode(11);
		rootListNode.next.next = new ListNode(3);
		rootListNode.next.next.next = new ListNode(9);
		rootListNode.next.next.next.next = new ListNode(5);
		rootListNode.next.next.next.next.next = new ListNode(6);
		
		rootListNode =  merging(rootListNode, rootListNode, 0, 1);
		
	}
	
}
