import java.util.*;

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
public class MergeKSortedLists {
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}

		Queue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
			@Override
			public int compare(ListNode n1, ListNode n2) {
				return n1.val - n2.val;
			}
		});

		for (ListNode node : lists) {
			if (node != null) minHeap.offer(node);
		}

		ListNode dummy = new ListNode(-1);
		ListNode tail = dummy;

		while (!minHeap.isEmpty()) {
			ListNode tmp = minHeap.poll();
			tail.next = tmp;
			tail = tmp;
			if (tmp.next != null) {
				minHeap.offer(tmp.next);
			}
		}

		return dummy.next;
	}
}