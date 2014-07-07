/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        
        RandomListNode copyHead = new RandomListNode(head.label);
        RandomListNode copyNode = copyHead;
        RandomListNode originNode = head;
        map.put(head, copyHead);
        while (originNode.next != null) {
            RandomListNode copyNextNode = new RandomListNode(originNode.next.label);
            copyNode.next = copyNextNode;
            map.put(originNode.next, copyNextNode);
            originNode = originNode.next;
            copyNode = copyNode.next;
        }
        
        
        copyNode = copyHead;
        originNode = head;
        while (originNode.next != null) {
            copyNode.random = map.get(originNode.random);
            originNode = originNode.next;
            copyNode = copyNode.next;
        }
        copyNode.random = map.get(originNode.random);
        return copyHead;
    }
}
