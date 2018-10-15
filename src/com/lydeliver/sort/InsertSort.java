package com.lydeliver.sort;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName InsertSort
 * @Author jonathan
 * @Date 2018/10/9 6:29 PM
 * @Version 1.0
 * @Description insert sort
 */
public class InsertSort {

    public static int[] sort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            for(int j=i-1;j>=0 && nums[j]>tmp;j--){
                nums[j+1]=nums[j];
                nums[j]=tmp;
            }

        }
        return nums;
    }

    public static void main(String[] args) {
        int [] result =sort(new int[]{34,8,64,51,52,21});
        List s = Arrays.asList(result);

        System.out.println(s.toArray());
    }
}