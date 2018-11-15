package com.lydeliver.issues.sort;

/**
 * @ClassName BinarySearch1
 * @Author jonathan
 * @Date 2018/11/4 5:09 PM
 * @Version 1.0
 * @Description 排序后的数组经过了旋转，找某个元素
 */
public class BinarySearch1 {

    public int findx(int[] nums, int x) {

        int l=0,r=nums.length-1;

        while (l <= r) {
            int mid = (l+r)/2;
            if(nums[mid] == x) {
                return mid;
            }

            if (nums[l] <= nums[mid]) {
                if (nums[l]<=x && x<nums[mid]) {
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else{
                if(nums[mid]<x && x<=nums[r]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] nums ={4,5,6,7,8,1,2,3};
        BinarySearch1 search1 = new BinarySearch1();
        System.out.println(search1.findx(nums,8));
    }
}
