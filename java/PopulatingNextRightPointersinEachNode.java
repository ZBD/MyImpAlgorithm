class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
}

public class PopulatingNextRightPointersinEachNode {
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

		connectLeftChild(node);
		connectRightChild(node);
		bfsConnect(node.left);
		bfsConnect(node.right);
	}

	private void connectLeftChild(TreeLinkNode node) {
		if (node == null || node.left == null) {
			return;
		} 

		//because it is perfect binary tree;
		node.left.next = node.right;
	}

	private void connectRightChild(TreeLinkNode node) {
		if (node == null || node.right == null) {
			return;
		} 

		//because it is perfect binary tree;
		if (node.next != null) {
			node.right.next = node.next.left;
		}
		else {
			node.right.next = null;
		}
	}


	//	     /* Go through parent level by its next pointer to generate children level next pointer */
	// public class Solution {
	//	     public void connect(TreeLinkNode root) {

	//	         TreeLinkNode leftWall = root;
	//	         while (leftWall != null) {

	//	             TreeLinkNode across = leftWall;
	//	             while (across != null) {
	//	                 if (across.left != null) {
	//	                     across.left.next = across.right;
	//	                 }

	//	                 if (across.right != null && across.next != null) {
	//	                     across.right.next = across.next.left;
	//	                 }

	//	                 across = across.next;
	//	             }
	//	             leftWall = leftWall.left;
	//	         }
	//	     }
	// }
}