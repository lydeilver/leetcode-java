package com.lydeliver.sort;

/**
 * @ClassName ShellSort
 * @Author jonathan
 * @Date 2018/10/10 11:39 AM
 * @Version 1.0
 * @Description TODO
 */
public class ShellSort {

    public static void sort(int [] nums){

        int j;
        for (int gap = nums.length/ 2; gap > 0; gap/=2) {

            for (int i = gap; i < nums.length ; i++) {
                int tmp = nums[i];
                for (j = i; j >= gap && tmp < nums[j - gap]; j -= gap) {
                    nums[j] = nums[j - gap];
                }
                nums[j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        sort(new int [] {3,1,5,7,2,6,8,4});
    }
}
