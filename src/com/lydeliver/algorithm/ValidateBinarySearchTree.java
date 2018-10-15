package com.lydeliver.algorithm;

import com.lydeliver.datastruture.TreeNode;

/**
 * @ClassName ValidateBinarySearchTree
 * @Author jonathan
 * @Date 2018/10/8 9:02 PM
 * @Version 1.0
 * @Description TODO
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {

        if(root == null) return false;
        boolean res = true;
        return res;
    }

    public boolean vaild(TreeNode root ){
        if(root==null)return false;
        boolean res = true;
        if(root.left!=null && root.left.val>root.val){
            res= false;
        }

        if(root.right!=null && root.right.val<root.val){
            res = false;
        }
        if (!res) {
            return res;
        }
        vaild(root.left );
        vaild(root.right );
        return res;

    }
}
