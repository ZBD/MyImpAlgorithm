/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return bfs(root);
    }
    
    private int bfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        if (isLeaf(node)) {
            return 1;
        }
        
        
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (node.left != null) {
            left = bfs(node.left);
        }
        if (node.right != null) {
            right = bfs(node.right);
        }
        
        return Math.min(left, right) + 1;
    }
    
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
