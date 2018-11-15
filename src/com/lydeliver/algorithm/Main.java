package com.lydeliver.algorithm;

import com.lydeliver.datastruture.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        DFS(root,0,res);
        return res;
    }

    void DFS(TreeNode root, int deepth, List<List<Integer>> res){
        if(root==null)return;
        while(res.size()<=deepth){
            res.add(new ArrayList<>());
        }
        res.get(deepth).add(root.val);
        DFS(root.left,deepth+1,res);
        DFS(root.right,deepth+1,res);

    }
    public static void main(String[] args) {

        Main main= new Main();
        TreeNode treeNode =new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right=new TreeNode(3);
        main.levelOrder(treeNode);

	// write your code here

        Sqrt sqrt = new Sqrt();
        ThreeSumCloset threeSumCloset = new ThreeSumCloset();
        System.out.println( threeSumCloset.threeSumClosest(new int[]{1,1,1,1},0));

        FourSum fourSum = new FourSum();
    //    System.out.println( fourSum.fourSum1(new int[]{-3,-2,-1,0,0,1,2,3},0));

       /* NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(new int[]{1,5,1});*/

       // SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
       // searchInsertPosition.binarySearch(new int[]{1,3,5,6},2);


        String a = "A";
        a.hashCode();
        String b = "A";
        b.hashCode();
    }/**/
}
