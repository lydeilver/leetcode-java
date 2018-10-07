package com.lydeliver.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BinaryTreeInorderTraversal
 * @Author jonathan
 * @Date 2018/10/7 8:23 PM
 * @Version 1.0
 * @Description 中序遍历
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result =new ArrayList<>();
        traversal(root,result);
        return result;
    }

    public void traversal(TreeNode root,List<Integer> result){
        if(root==null){
            return;
        }
        traversal(root.left,result);
        result.add(root.val);
        traversal(root.right,result);

    }

    private static class TreeNode{
        int val;

        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
