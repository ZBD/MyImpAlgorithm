import java.util.*;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePreorderTraversal {

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> preorder = new ArrayList<Integer>();
		if (root != null) {
			Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
			//use stack, FILO. Preorder is PLR, so right child should put in the stack first, then left child. The parent is no need to push in the stack
			//because we can just add it to the preorder arraylist.
			stack.push(root);
			while (!stack.isEmpty()) {
				TreeNode node = stack.pop();
				preorder.add(node.val);
				if (node.right != null) {
					stack.push(node.right);
				}
				if (node.left != null) {
					stack.push(node.left);
				}
			}
		}
		return preorder;
	}
}