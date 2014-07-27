/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class RecoverBinarySearchTree {
    List<TreeNode> inorder;
    TreeNode first = null;
    TreeNode second = null;
    
    public void recoverTree1(TreeNode root) {
        //time O(n log n)  sort, O(n) without sort, space O(n)
        
        //in order traver to get the value and node
        //sort the value
        //re assign the value
        
        if (root == null) {
            return;
        }
        
        inorder = new ArrayList<TreeNode>();
        inOrderTraversal(root);
        
        int[] val = new int[inorder.size()];
        
        for (int i=0; i<inorder.size(); i++) {
            val[i] = inorder.get(i).val;
        }
        
        
        //sort the array, or there is only 2 swaped, so we don't need to sort the array, check which 2 are swaped
        //Arrays.sort(val);
        int first=0;
        while (val[first] <= val[first+1]) {
            first++;
        }
        
        //pay attention to the second node, if it is next to the first node
        int second = first + 2;
        while (second<inorder.size() && val[second] >= val[second-1]) {
            second++;
        }
        if (second == inorder.size()) second = first+1;
        
        inorder.get(first).val = val[second];
        inorder.get(second).val = val[first];
        
        
        // for (int i=0; i<inorder.size(); i++) {
        //     inorder.get(i).val = val[i];
        // }
     }
    
    private void inOrderTraversal(TreeNode node) {
        if (node.left != null) {
            inOrderTraversal(node.left);
        }
        //do something
        inorder.add(node);
        if (node.right != null) {
            inOrderTraversal(node.right);
        }
    }
    
    
    
    
    public void recoverTree(TreeNode root) {
        //time O(n), space O(1), morris traversal, Morris Traversal is based on Threaded Binary Tree.
        
        morrisTraversal(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;

     }
     
     private void morrisTraversal(TreeNode root) {
        //Initialise the current as root
        //2. While current is not NULL
        //    If current does not have left child
                //a) Print current¡¯s data
                //b) Go to the right, i.e., current = current->right
            //Else
                //a) Make current as right child of the rightmost node in current's left subtree              find current's predecessor, link current as it right child
                //b) Go to this left child, i.e., current = current->left
                
        // revert the structure
        
        TreeNode current = root;
        TreeNode preNode = null;
        while (current != null) {
            if (current.left == null) {
                //do something like print data of current
                checkSwaped(preNode, current);
                
                preNode = current; 
                current = current.right;
            }
            else {
                TreeNode pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }
                else {
                    //the predecessor of current is already traversed, so now need to recover the structure and traverse current
                    pre.right = null;
                    //do something like print data of current
                    
                    checkSwaped(preNode, current);
                    
                    preNode = current;
                    current = current.right;
                }
            }
        }
     }
     
     private void checkSwaped(TreeNode pre, TreeNode cur) {
         if (pre != null && pre.val > cur.val) {
             if (first == null) {
                 first = pre;
                 second = cur;
             }
             else {
                 second = cur;
             }
         }
     }
}