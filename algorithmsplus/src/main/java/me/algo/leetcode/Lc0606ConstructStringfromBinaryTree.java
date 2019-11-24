package me.algo.leetcode;

public class Lc0606ConstructStringfromBinaryTree {
	public String tree2str(TreeNode t) {
		String str = "";
		if (t == null)
			return str;

		str += t.val;
		if (t.left == null && t.right == null)
			return str;

		if (t.left == null) {
			System.out.println(t.val);
			return str + "()" + "(" + tree2str(t.right) + ")";
		}

		str = str + "(" + tree2str(t.left) + ")";
		if (t.right != null)
			str = str + "(" + tree2str(t.right) + ")";

		return str;
	}
}
