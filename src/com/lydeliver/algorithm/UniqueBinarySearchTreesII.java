package com.lydeliver.algorithm;


import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UniqueBinarySearchTreesII
 * @Author jonathan
 * @Date 2018/10/7 8:40 PM
 * @Version 1.0
 * @Description
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 */
public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1,n);
    }


    private List<TreeNode> generateTrees(int l,int r){
        List<TreeNode> res = new ArrayList<>();
        if(l>r){
            res.add(null);
            return res;
        }

        for(int k=l;k<=r;k++){
            List<TreeNode> leftNodes = generateTrees(1,k-1);
            List<TreeNode> rightNodes = generateTrees(k+1,r);
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode root = new TreeNode(k);
                    root.left=leftNode;
                    root.right=rightNode;
                    res.add(root);
                }
            }

        }
        return res;
    }




    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
