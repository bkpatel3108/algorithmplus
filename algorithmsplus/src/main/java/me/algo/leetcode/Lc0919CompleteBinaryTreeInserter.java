package me.algo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Lc0919CompleteBinaryTreeInserter {
	Queue<TreeNode> q;
	TreeNode root;

	public Lc0919CompleteBinaryTreeInserter(TreeNode root) {
		this.root = root;
		q = new LinkedList<>();
		q.offer(root);
		while (q.size() > 0) {
			TreeNode curr = q.peek();
			if (curr.left == null)
				break;
			q.offer(curr.left);

			if (curr.right == null)
				break;
			q.offer(curr.right);

			q.poll();
		}
	}

	public int insert(int v) {
		TreeNode currParent = q.peek();
		int parentVal = currParent.val;
		if (currParent.left == null) {
			currParent.left = new TreeNode(v);
			q.offer(currParent.left);
		} else {
			currParent.right = new TreeNode(v);
			q.offer(currParent.right);
			q.poll();
		}
		return parentVal;
	}

	public TreeNode get_root() {
		return root;
	}
}
