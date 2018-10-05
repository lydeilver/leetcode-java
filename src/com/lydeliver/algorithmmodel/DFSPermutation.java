package com.lydeliver.algorithmmodel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName DFSPermutation
 * @Author jonathan
 * @Date 2018/10/5 4:10 PM
 * @Version 1.0
 * @Description
 *
 * DFS 做全排列，d是递归深度，n是从nums中取n个数做全排列，used代表是否用过，curr是当前的组合
 */
public class DFSPermutation {


    public void permutation(int [] nums, int d , int n, boolean [] used,ArrayList<Integer> curr,List<List<Integer>> arr) {

       if(n==d){
           List<Integer> list = new ArrayList<>(curr);
           arr.add(list);
           return;
       }

        for (int i = 0; i < nums.length; i++) {
           if(used[i])
               continue;
            used[i]=true;
            curr.add(nums[i]);
            permutation(nums, d + 1, n, used, curr, arr);
            used[i] = false;
            curr.remove(curr.size()-1);
        }


    }

    public static void main(String[] args) {
        DFSPermutation dfsPermutation = new DFSPermutation();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        int [] nums = {1,2,3};
        boolean [] used  = new boolean[nums.length];
        dfsPermutation.permutation(nums,0,3,used,curr,res);
        System.out.println(res);

    }
}
