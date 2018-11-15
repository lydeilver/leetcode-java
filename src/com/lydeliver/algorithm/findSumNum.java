package com.lydeliver.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName findSumNum
 * @Author jonathan
 * @Date 2018/11/6 3:33 PM
 * @Version 1.0
 * @Description TODO
 */
public class findSumNum {

    public  List<List<Integer>> findSumNum(int[] nums, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        findHelper(n, nums, res, curr, 0, 0);
        return res;
    }

    private void findHelper(int n,int[] nums, List<List<Integer>> res, List<Integer> curr,int currSum,int s) {
        if(curr.size()==2 ){
            if (currSum == n) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }

        for (int i = s; i < nums.length; i++) {
            curr.add(nums[i]);
            currSum+=nums[i];
            findHelper(n, nums, res, curr, currSum, i+1);
            currSum-=curr.get(curr.size()-1);
            curr.remove(curr.size()-1);


        }
    }

    public static void main(String[] args) {
        findSumNum sum = new findSumNum();
        List<List<Integer>> res =sum.findSumNum(new int[]{1, 2, 3, 4, 5, 6, 7}, 8);
        System.out.println(res);

    }
}
