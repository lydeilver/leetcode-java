package com.lydeliver.algorithm;

/**
 * @ClassName UniqueBinarySearchTrees
 * @Author jonathan
 * @Date 2018/10/8 9:01 PM
 * @Version 1.0
 * @Description DP
 */

public class UniqueBinarySearchTrees {
    public int numTrees_1(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; ++i)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j] * dp[i-j-1];
        return dp[n];
    }
    public int numTrees(int n) {
        if (n < 0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;
        for(int i = 2;i <= n; ++i){
            dp[i] = dp[i-1] * (4 * i - 2)/(i + 1);
        }
        return dp[n];
    }
}
