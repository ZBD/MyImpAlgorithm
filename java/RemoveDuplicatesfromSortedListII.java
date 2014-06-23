
public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) return head;

		//delete from the original list   or remove and insert to a new list
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		while (head != null) {
			if (head.next != null && head.next.val == head.val) {
				//it is duplicate, delete all the node
				ListNode nextValue = head.next;
				while (nextValue != null && nextValue.val == head.val) nextValue = nextValue.next;
				pre.next = nextValue;
				head = nextValue;
			}
			else {
				//don't forget to update pre
				pre = head;
				head = head.next;
			}
		}

		return dummy.next;
	}
}