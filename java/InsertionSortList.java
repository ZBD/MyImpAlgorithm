
public class InsertionSortList {

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) 
			return head;


		ListNode nodeNow = head.next;
		ListNode tail = head;
		head.next = null;
		while (nodeNow != null) {
			ListNode t = head;
			ListNode p = null;
			while (t != null) {
				if (t.val < nodeNow.val) {
					p = t;
					t = t.next;
				}
				else {
					break;
				}
			}
			if (t == null) {
				tail.next = nodeNow;
				tail = tail.next;
				nodeNow = nodeNow.next;
				tail.next = null;
			}
			else if (p == null) {
				ListNode tmp = nodeNow.next;
				nodeNow.next = head;
				head = nodeNow;
				nodeNow = tmp;
			}
			else {
				ListNode tmp = nodeNow.next;
				nodeNow.next = p.next;
				p.next = nodeNow;
				nodeNow = tmp;
			}
		}
		return head;
	}
}