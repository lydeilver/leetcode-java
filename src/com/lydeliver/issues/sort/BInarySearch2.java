package com.lydeliver.issues.sort;

/**
 * @ClassName BInarySearch2
 * @Author jonathan
 * @Date 2018/11/4 5:38 PM
 * @Version 1.0
 * @Description TODO
 */
public class BInarySearch2 {

    public boolean find(int[][] nums, int x) {
        int row =0;
        int col = nums[0].length-1;
        while (row <= nums.length && col >= 0) {
            if (nums[row][col] == x) {
                return true;
            }else if(nums[row][col] > x){
                col--;
            }else {
                row++;
            }
        }
        return false;
    }
}
