package com.lydeliver;

/**
 * @ClassName RemoveDuplicates
 * @Author jonathan
 * @Date 2018/10/3 3:10 PM
 * @Version 1.0
 * @Description TODO
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int j =0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]!=nums[j]){
                nums[++j]=nums[i];
            }
        }
        return ++j;
    }
}
