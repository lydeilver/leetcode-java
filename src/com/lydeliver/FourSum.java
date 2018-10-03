package com.lydeliver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName FourSum
 * @Author jonathan
 * @Date 2018/10/3 2:54 PM
 * @Version 1.0
 * @Description TODO
 */
public class FourSum {

    /**
     * my solution
     * attention avoid duplicates， i，j，l，r only compare to themselves
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        Arrays.sort(nums);
        int N = nums.length;

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(N<4) return result;
        for(int i=0;i<N-3;i++){
            if(i>0&&nums[i]==nums[i-1])continue;
            for(int j=i+1;j<N-2;j++){
                if(j>i+1&&nums[j]==nums[j-1])continue;
                int twoSum = target - nums[i] - nums[j];
                int l=j+1,r=N-1;
                while(l<r){
                    int sum = nums[l]+nums[r];
                    if(sum==twoSum){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        result.add(list);
                        l++;
                        r--;
                    }else if(sum<twoSum){
                        l++;
                    }else{
                        r--;
                    }
                    while(l<r&&l>j+1&&nums[l]==nums[l-1])l++;
                    while(l<r&&r<N-1&&nums[r]==nums[r+1])r--;

                }

            }
        }
        return result;
    }
}
