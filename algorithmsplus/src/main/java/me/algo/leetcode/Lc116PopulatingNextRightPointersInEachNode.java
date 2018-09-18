package me.algo.leetcode;

public class Lc116PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
        if(root != null && root.left != null && root.right != null){
            root.left.next = root.right;
            connect(root.left, root.right);
        }
    }
    
    public void connect(TreeLinkNode node1, TreeLinkNode node2) {
        if(node1.left != null && node1.right != null && node2.left != null && node2.right != null){
            node1.left.next = node1.right;
            node1.right.next = node2.left;
            node2.left.next = node2.right;
            
            connect(node1.left, node1.right);
            connect(node1.right, node2.left);
            connect(node2.left, node2.right);
        }
    }
}
