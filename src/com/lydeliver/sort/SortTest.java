package com.lydeliver.sort;

import java.util.Arrays;

/**
 * @ClassName SortTest
 * @Author jonathan
 * @Date 2018/11/4 11:12 AM
 * @Version 1.0
 * @Description TODO
 */
public class SortTest {


    public static void bublleSort(int [] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int tmp =nums[i];
            for (int j = i - 1; j >= 0 && nums[j]>tmp; j--) {
                nums[j+1]=nums[j];
                nums[j] =tmp;
            }
        }
    }

   static  void swap(int [] nums,int i,int j){
        int tmp = nums[i];
        nums[i]=nums[j];
         nums[j]=tmp;
    }


    public void mergeSrot(int[] nums,int [] res,int start,int end) {
        if (start > end) {
            return;
        }
        int mid = (start+end)/2;
        mergeSrot(nums, res,start, mid - 1);
        mergeSrot(nums, res,mid + 1, end);
        merge(nums, res,start, mid, end);

    }


    public void merge(int[] nums,int [] res, int ls,int mid,int re) {
        int rs = mid+1;
        int i=ls;
        int numElements = re-ls+1;
        while (ls <= mid && rs <= re) {
            if (nums[ls] < nums[rs]) {
                res[i++]=nums[ls++];
            }else{
                res[i++]=nums[rs++];
            }
        }

        while (ls <= mid) {
            res[i++]=nums[ls++];
        }
        while (rs <= re) {
            res[i++]=nums[rs++];
        }
        for(int j=0;j<numElements;j++,re--){
            nums[re]=res[re];
        }
    }
    public static void main(String[] args) {
        int[] nums = {5, 4, 6, 2, 7, 1, 9};
        SortTest test = new SortTest();
        int[] res = new int[7];
        test.mergeSrot(nums,res,0,6);
        System.out.println(Arrays.toString(nums));
    }
}
