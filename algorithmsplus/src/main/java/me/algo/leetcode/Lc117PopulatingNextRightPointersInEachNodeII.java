package me.algo.leetcode;

public class Lc117PopulatingNextRightPointersInEachNodeII {
	public void connect(TreeLinkNode root) {
		TreeLinkNode currLevel = root;

		while (currLevel != null) {
			TreeLinkNode curr = currLevel;
			TreeLinkNode nextLevelStart = null;
			TreeLinkNode head = new TreeLinkNode(0);
			TreeLinkNode prev = head;
			while (curr != null) {
				if (curr.left != null) {
					if (nextLevelStart == null)
						nextLevelStart = curr.left;
					prev.next = curr.left;
					prev = curr.left;
				}
				if (curr.right != null) {
					if (nextLevelStart == null)
						nextLevelStart = curr.right;
					prev.next = curr.right;
					prev = curr.right;
				}
				curr = curr.next;
			}
			head.next = null;
			currLevel = nextLevelStart;
		}
	}
}
