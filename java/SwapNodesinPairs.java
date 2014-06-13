/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
		//try to see the discussion and add a dumy node?

		if (head == null || head.next == null) {
			return head;
		}

		ListNode node = head;
		head = head.next;

		ListNode pre = null;
		//be carefull, you should test node and node.next
		while (node != null && node.next != null) {
			ListNode next = node.next.next;
			node.next.next = node;
			if (pre != null) {
				pre.next = node.next;
			}
			//this line should put here
			node.next = next;
			pre = node;
			node = next;
		}
		return head;
	}
}
