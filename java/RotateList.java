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
public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		//what happened if k is larger than the length of the list ? 
		if (head == null) {
			return head;
		}

		ListNode node = head;
		int length = 1;
		while (node.next != null) {
			node = node.next;
			length++;
		}
		ListNode tail = node;
		int rotate = n % length;
		if (rotate == 0) {
			return head;
		}

		node = head;
		ListNode pre = null;
		int i=0;
		while (i < length - rotate) {
			pre = node;
			node = node.next;
			i++;
		}
		pre.next = null;
		tail.next = head;
		return node;

	}
}