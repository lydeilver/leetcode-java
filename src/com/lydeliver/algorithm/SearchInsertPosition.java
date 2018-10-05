package com.lydeliver.algorithm;

import java.util.ArrayList;

/**
 * @ClassName SearchInsertPosition
 * @Author jonathan
 * @Date 2018/10/4 12:22 PM
 * @Version 1.0
 * @Description TODO
 */
public class SearchInsertPosition {


    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public int binarySearch(int[] nums, int target) {

        int l =0,r=nums.length-1;

        while (l <= r) {
            int mid = l+(r-l)/2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target){
                l=mid+1;
            }else {
                r=mid-1;
            }


        }
        return l;
    }
}
