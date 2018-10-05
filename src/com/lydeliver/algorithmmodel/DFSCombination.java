package com.lydeliver.algorithmmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DFSCombination
 * @Author jonathan
 * @Date 2018/10/5 4:11 PM
 * @Version 1.0
 * @Description
 * DFS 做组合操作，d为递归深度，n为定长，代表着组合后长度为n，s为当前位置，组合必须找当前位置之后，所以是i+1
 */
public class DFSCombination {

    public void combination(int [] nums,int d,int n,int s,List<Integer> curr,List<List<Integer>> res) {

        if (d == n) {
            List<Integer> list = new ArrayList<>(curr);
            res.add(list);
            return;
        }
        for (int i = s; i < nums.length; i++) {
            curr.add(nums[i]);
            combination(nums, d + 1, n, i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }

    }

    public static void main(String[] args) {
        DFSCombination dfsCombination = new DFSCombination();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        int [] nums = {1,2,3};
        dfsCombination.combination(nums,0,1,0,curr,res);
        System.out.println(res);

    }
}
