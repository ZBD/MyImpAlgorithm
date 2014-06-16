package MyDataStructure;

public class SameTree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}
	
	public static boolean compare(TreeNode root1, TreeNode root2) {
		if (root1 == null) {
			return root2 == null ? true : false;
		}

		if (root2 == null) {
			//here root1 is not null;
			return false;
		}

		//here root1 and root2 are both not null
		return root1.val == root2.val && compare(root1.left, root2.left) && compare(root1.right, root2.right);
	}
	
	public static void main(String[] args) {
		SameTree tree = new SameTree();
		TreeNode root1 = tree.new TreeNode(1);// or put the definition out side
		TreeNode root2 = tree.new TreeNode(1);
		System.out.println(SameTree.compare(root1, root2));
	}
}