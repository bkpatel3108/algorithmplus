package me.algo.leetcode;

public class Lc0099RecoverBinarySearchTree {
	TreeNode first;
    TreeNode second;
    TreeNode prev;
    
    public void recoverTree(TreeNode root) {
        findNodes(root);
        if(first != null && second != null)
            swap(first, second);
    }
    
    void findNodes(TreeNode root) {
        if(root == null)
            return;
        findNodes(root.left);
        //validate inorder
        if(prev != null && prev.val > root.val){
            if(first == null){
                first = prev;
            }
            second = root;
        }
        prev = root;
        findNodes(root.right);
    }
    
    void swap(TreeNode first, TreeNode second){
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
