package com.lydeliver.sort;

import java.util.Arrays;

/**
 * @ClassName QuickSort
 * @Author jonathan
 * @Date 2018/11/4 12:37 PM
 * @Version 1.0
 * @Description TODO
 */
public class QuickSort {


    /*public void sort(int[] nums, int start, int end) {

        if (start >= end) {
            return;
        }
        int mid = findMid(nums, start, end);
        sort(nums, start, mid - 1);
        sort(nums, mid + 1, end);
    }

    private int findMid(int[] nums, int start, int end) {
        int l=start;
        int r=end-1;
        int tmp = nums[end];

        while (true) {
            while(l<end && nums[l]<=tmp) l++;
            if(l==end) break;
            while(r>=start && nums[r]>=tmp) r--;

            if (l < r) {
                int d = nums[l];
                nums[l]=nums[r];
                nums[r] =d;
            }else{
                nums[end]=nums[l];
                nums[l]=tmp;
                break;
            }
        }
        return l;
    }
*/


    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = findMid(nums, start, end);
        quickSort(nums, start, mid - 1);
        quickSort(nums, mid + 1, end);
    }

    private int findMid(int[] nums, int start, int end) {
        int tmp = nums[end];
        int l =start;
        int r =end-1;
        while (true) {
            while(l<end && nums[l]<tmp) l++;
            if(l==end) break;
            while(r>=start && nums[r]>tmp) r--;
            if (l < r) {
                int d = nums[l];
                nums[l]=nums[r];
                nums[r]=d;
            }else {
                nums[end]=nums[l];
                nums[l]=tmp;
                break;
            }

        }
        return l;
    }
    public static void main(String[] args) {
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i]=(int)(Math.random()*10);
        }
        System.out.println(Arrays.toString(nums));
        QuickSort sort =new QuickSort();
        sort.quickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
