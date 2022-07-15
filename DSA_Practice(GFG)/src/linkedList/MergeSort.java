package linkedList;

public class MergeSort {

	public static ListNode merging(ListNode head1, ListNode head2) {
		ListNode first = head1;
		ListNode second = head2;
		ListNode third = null;
		ListNode res = null;
		if (first.val < second.val) {
			third = first;
			first = first.next;
		} else {
			third = second;
			second = second.next;
		}
		res = third;
		while (first != null && second != null) {
			if (first.val < second.val) {
				third.next = first;
				first = first.next;
			} else {
				third.next = second;
				second = second.next;
			}

			third = third.next;
		}

		while (first != null) {
			third.next = first;
			first = first.next;
			third = third.next;
		}

		while (second != null) {
			third.next = second;
			second = second.next;
			third = third.next;
		}
		return res;
	}

	public static ListNode findMid(ListNode node) {
		ListNode fast = node;
		ListNode slow = node;
		ListNode prev = null;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}
		return prev;
	}

	public static ListNode mergeFunction(ListNode first, ListNode last) {
		
		if (first == last)
			return first;

		ListNode mid = findMid(first);
		if(mid == null)return first;
		ListNode midNext = mid.next;
		mid.next = null;
		first =  mergeFunction(first, mid);

		 midNext =  mergeFunction(midNext, last);
		return merging(first, midNext);

	}

	public static void main(String[] args) {

		ListNode rootListNode = new ListNode(8);
		rootListNode.next = new ListNode(11);
		rootListNode.next.next = new ListNode(3);

		rootListNode =  mergeFunction(rootListNode, null);

	}

}
