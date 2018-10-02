package com.lydeliver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ThreeSum
 * @Author jonathan
 * @Date 2018/10/2 8:07 PM
 * @Version 1.0
 * @Description TODO
 */
public class ThreeSum {

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result =new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int N = nums.length;
        for(int i=0;i<N-2&&nums[i]<=0;i++){
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int sums = 0-nums[i];
            int l = i+1,r=N-1;
            while(l<r){
                int s = nums[l]+nums[r];
                if(sums>s){
                    l++;
                }else if (sums<s){
                    r--;
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    result.add(list);
                    l++;
                    r--;
                    while(l<r&& nums[l]==nums[l-1])l++;
                    while(l<r&& nums[r]==nums[r+1])r--;

                }

            }
        }
        return result;

    }
}
