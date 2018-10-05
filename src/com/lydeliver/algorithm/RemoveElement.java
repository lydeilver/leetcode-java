package com.lydeliver.algorithm;

/**
 * @ClassName RemoveElement
 * @Author jonathan
 * @Date 2018/10/3 3:33 PM
 * @Version 1.0
 * @Description TODO
 */
public class RemoveElement {

    public int removeElement(int[] nums,int val) {
        int i=0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return ++i;
    }
}
