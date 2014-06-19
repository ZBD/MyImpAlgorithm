import java.util.*;


public class SameTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null) return q == null;
		if (q == null) return p == null;
		//using stack
		Deque<TreeNode> s1 = new ArrayDeque<TreeNode>();
		Deque<TreeNode> s2 = new ArrayDeque<TreeNode>();
		while (!s1.isEmpty() || p != null) {
			try {
				while (p != null) {
					s1.push(p);
					p = p.left;
					s2.push(q);
					q = q.left;
				}
			}
			catch(Exception ex) {
				//structure different;
				return false;
			}

			if (q != null) return false;
			p = s1.pop();
			q = s2.pop();
			if (p.val != q.val) return false;
			p = p.right;
			q = q.right;
		}

		return s2.isEmpty();
	}


	public boolean isSameTreeQue(TreeNode p, TreeNode q) {
		if (p == null) {
			return q == null;
		}
		if (q == null) {
			return p == null;
		}

		Queue<TreeNode> q1 = new ArrayDeque<TreeNode>();
		Queue<TreeNode> q2 = new ArrayDeque<TreeNode>();
		q1.offer(p);
		q2.offer(q);
		while (!q1.isEmpty() && !q2.isEmpty()) {
			TreeNode n1 = q1.poll();
			TreeNode n2 = q2.poll();
			if (n1.val != n2.val) {
				return false;
			}
			if (n1.left != null && n2.left != null) {
				q1.offer(n1.left);
				q2.offer(n2.left);
			}
			else if (n1.left == null && n2.left == null) {
			}
			else {
				return false;
			}
			if (n1.right != null && n2.right != null) {
				q1.offer(n1.right);
				q2.offer(n2.right);
			}
			else if (n1.right == null && n2.right == null) {
			}
			else {
				return false;
			}
		}
		if (q1.isEmpty() && q2.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isSameTreeRec(TreeNode p, TreeNode q) {
		if (p == null) {
			return q == null ? true : false;
		}
		if (q == null) {
			//p  is not null
			return false;
		}

		//p q are all not null
		if (p.val != q.val) {
			return false;
		}

		return isSameTreeRec(p.left, q.left) && isSameTreeRec(p.right, q.right);
	}
}
