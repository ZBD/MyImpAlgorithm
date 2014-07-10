
public class PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        root.next = null;
        bfsConnect(root);
    }
    
    private void bfsConnect(TreeLinkNode node) {
        
        if (node == null) {
            return;
        }
        
        //rightmost child first, because it need the information when it do next with left child
        connectRightChild(node);
        connectLeftChild(node);
        //rightmost child first, because it need the information when it do next with left child
        bfsConnect(node.right);
        bfsConnect(node.left);
    }
    
    private void connectLeftChild(TreeLinkNode node) {
        if (node == null || node.left == null) {
            return;
        } 
    
        //because it may be any binary tree;
        if (node.right != null) {
            node.left.next = node.right;
        }
        else {
            TreeLinkNode left = node.left;
            TreeLinkNode next = null;
            while (next == null && node.next != null) {
                node = node.next;
                if (node.left != null) {
                    next = node.left;
                }
                else if (node.right != null) {
                    next = node.right;
                }
            }
            left.next = next;
        }
    }
    
    private void connectRightChild(TreeLinkNode node) {
        if (node == null || node.right == null) {
            return;
        } 
    
        //because it is perfect binary tree;
        if (node.next != null) {
            TreeLinkNode right = node.right;
            TreeLinkNode next = null;
            while (next == null && node.next != null) {
                node = node.next;
                if (node.left != null) {
                    next = node.left;
                }
                else if (node.right != null) {
                    next = node.right;
                }
            }
            right.next = next;
        }
        else {
            node.right.next = null;
        }
    }
    
    // //O(1) space iterative

    // //based on level order traversal
    // public void connect(TreeLinkNode root) {

    //     TreeLinkNode head = null; //head of the next level
    //     TreeLinkNode prev = null; //the leading node on the next level
    //     TreeLinkNode cur = root;  //current node of current level

    //     while (cur != null) {

    //         while (cur != null) { //iterate on the current level
    //             //left child
    //             if (cur.left != null) {
    //                 if (prev != null) {
    //                     prev.next = cur.left;
    //                 } else {
    //                     head = cur.left;
    //                 }
    //                 prev = cur.left;
    //             }
    //             //right child
    //             if (cur.right != null) {
    //                 if (prev != null) {
    //                     prev.next = cur.right;
    //                 } else {
    //                     head = cur.right;
    //                 }
    //                 prev = cur.right;
    //             }
    //             //move to next node
    //             cur = cur.next;
    //         }

    //         //move to next level
    //         cur = head;
    //         head = null;
    //         prev = null;
    //     }

    // }
}