package com.lydeliver.sort;

/**
 * @ClassName HalfSort
 * @Author jonathan
 * @Date 2018/10/10 5:56 PM
 * @Version 1.0
 * @Description TODO
 */
public class HalfSort {

    private int sort(int[] nums,int s) {
        int l=0,r=nums.length-1;
        while (l < r) {
            int mid = l+(r-l)/2;
            if (nums[mid] == s) {
                return mid;
            } else if (nums[mid] < s) {
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return -1;
    }
}
