package com.lydeliver.algorithm;

/**
 * @ClassName MaxSum
 * @Author jonathan
 * @Date 2018/11/6 1:47 PM
 * @Version 1.0
 * @Description 获取最大连续子序列之和
 */
public class MaxSum {

    public int getMaxSum(int[] nums) {
        int max = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                max=sum;
            } else if (sum < 0) {
                sum =0;
            }
        }
        return max;
    }
}
