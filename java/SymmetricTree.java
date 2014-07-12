/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
    	if (root == null) {
    		//is empty tree Symmetric
    		return true;
        }
    
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode n1, TreeNode n2) {
    	if (n1 == null) {
    		return n2 == null ? true : false;
        }
    
        //now n1 is not null
        if (n2 == null) {
        	return false;
        }
    
        //now n1 n2 are not null
        //check the n1 n2 now
        if (n1.val != n2.val) {
        	return false;
        }
        
        //recursive check its child
        return isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left);
    }
}