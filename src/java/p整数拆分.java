package java;

/**
 * https://leetcode-cn.com/problems/integer-break/solution/zheng-shu-chai-fen-by-leetcode-solution/
 *
 * 由于每个正整数对应的最大乘积取决于比它小的正整数对应的最大乘积，因此可以使用动态规划求解。
 *
 * 对动态规划需要注意，不再是相邻场景的推导方案，而是其多个子场景的结果的对比结果推导。
 */

class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        // 从 i = 2 开始计算
        for (int i = 2; i <= n; i ++) {
            int allMax = 0;
            // 要计算 i 的尽可能多的子情况
            for (int j = 1; j < i; j++) {
                // i * j
                int curMax = Math.max(j * (i - j), j * dp[i - j]);
                curMax = Math.max(curMax, curMax);
            }
        }
        return dp[n];
    }
}
