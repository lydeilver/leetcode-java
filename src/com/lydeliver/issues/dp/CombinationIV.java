package com.lydeliver.issues.dp;

/**
 * @ClassName CombinationIV
 * @Author jonathan
 * @Date 2018/10/26 4:30 PM
 * @Version 1.0
 * @Description TODO
 */
public class CombinationIV {

    public static int combinationSum4(int[] nums, int target) {

        int [] dp = new int [target+1];
        dp[0] = 1;


        for(int i=1;i<=target;i++){
            for(int num : nums){
                if(i-num>=0)
                    dp[i] +=dp[i-num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        CombinationIV.combinationSum4(new int []{1,2,3,},4);
    }

}
