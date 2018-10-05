package com.lydeliver.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName CombinationSum
 * @Author jonathan
 * @Date 2018/10/5 5:20 PM
 * @Version 1.0
 * @Description TODO
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        combination(candidates, target, 0, curr, res);
        return res;
    }


    public void combination(int [] nums, int target, int s, List<Integer> curr, List<List<Integer>> res) {

        if (target==0) {
            List<Integer> list = new ArrayList<>(curr);
            res.add(list);
            return;
        }
        for (int i = s; i < nums.length && target>=nums[i]; i++) {
            curr.add(nums[i]);
            combination(nums, target-nums[i] ,i, curr, res);
            curr.remove(curr.size() - 1);
        }

    }
}
