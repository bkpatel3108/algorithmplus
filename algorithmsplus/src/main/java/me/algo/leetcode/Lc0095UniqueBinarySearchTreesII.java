package me.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc0095UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
        if(n < 1)
            return new ArrayList();
        List<TreeNode>[][] memo = new List[n+2][n+2];
        return generateTreesRec(1, n, memo);
    }
    
    public List<TreeNode> generateTreesRec(int s, int e, List<TreeNode>[][] memo) {
        if(memo[s][e] != null){
            return memo[s][e];
        }
        if(s == 0 || s > e){
            return null;
        }
        if(s == e){
            List<TreeNode> list = new ArrayList(Arrays.asList(new TreeNode(s)));
            memo[s][e] = list;
            return list;
        }
        
        List<TreeNode> list = new ArrayList<TreeNode>();
        for(int i=s; i<=e; i++){
            List<TreeNode> leftSubTrees = generateTreesRec(s, i-1, memo);
            List<TreeNode> rightSubTrees = generateTreesRec(i+1, e, memo);
            
            if(leftSubTrees != null && rightSubTrees != null){
                for(TreeNode left: leftSubTrees){
                    for(TreeNode right: rightSubTrees){
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        list.add(root);
                    }
                }
            }else if(leftSubTrees == null){
                for(TreeNode right: rightSubTrees){
                    TreeNode root = new TreeNode(i);
                    root.right = right;
                    list.add(root);
                }
            }else if(rightSubTrees == null){
                for(TreeNode left: leftSubTrees){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    list.add(root);
                }
            }
        }
        memo[s][e] = list;
        return list;
    }
}
