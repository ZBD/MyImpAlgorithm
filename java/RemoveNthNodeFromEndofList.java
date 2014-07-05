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
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = head;
        ListNode pre = dummy;
        //make node distance n from head
        for (int i=0; i<n; i++) {
            if (node != null) {
                node = node.next;
            }
            else {
                return head.next;
            }
        }
        
        //move to tail
        while (node != null) {
            pre = pre.next;
            head = head.next;
            node = node.next;
        }
        
        pre.next = head.next;
        head.next = null;
        
        return dummy.next;
    }
    
}
