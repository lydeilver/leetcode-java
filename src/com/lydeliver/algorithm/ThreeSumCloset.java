package com.lydeliver.algorithm;

import java.util.Arrays;

/**
 * @ClassName ThreeSumCloset
 * @Author jonathan
 * @Date 2018/10/2 8:29 PM
 * @Version 1.0
 * @Description TODO
 */
public class ThreeSumCloset {


    /**
     * my solution
     * @param nums
     * @param target
     * @return
     * notice:
     * 1. 初始result设置为任意三个数相加，在比较时用两个差值作比较
     * 2. 最近的元素，不是0，不用考虑负数+正数问题
     * 3. 数组问题，可以先考虑排个序
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int l = nums.length;
        if(l<3) return 0;
        int result = nums[0]+nums[1]+nums[2];
        for(int i=0;i<l-2;i++){
            int left = i+1,right = l-1;
            while(left<right){
                int r = nums[i]+nums[left]+nums[right];
                if(r<target){
                    left++;
                }else if(r>target){
                    right--;
                }else{
                    return target;
                }
                if(Math.abs(r-target)<Math.abs(result-target)){
                    result=r;
                }
            }

        }
        return result;
    }

}
