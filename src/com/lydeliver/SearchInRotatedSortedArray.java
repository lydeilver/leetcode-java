package com.lydeliver;

/**
 * @ClassName SearchInRotatedSortedArray
 * @Author jonathan
 * @Date 2018/10/3 7:48 PM
 * @Version 1.0
 * @Description 要求时间复杂度O(logn)典型二分查找
 *
 * eg: 4 5 6 7 0 1 2
 *     4 5 6 0 1 2 3
 *  nums[l]<=nums[mid] 证明 l--mid 这一段是升序的，反之则是mid--r这一段升序
 *  在两段升序arrays中做二分查找
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[l]<=nums[mid]){
                if(nums[l]<=target && target<nums[mid]){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else{
                if(nums[mid]<target && target<=nums[r]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}
