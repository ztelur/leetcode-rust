/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2022 All Rights Reserved.
 */
package java;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 * @author libing
 * @version $Id: p零钱兑换.java, v 0.1 2022年02月25日 下午5:18 zt Exp $
 *
 * 先排序
 *
 * amount = S[amount1] + S[amount2]
 *
 * 这里的动态规划，没有看前1个，而是看了前边所有的值，所以必须要有一个数组记录前边所有的数据
 *
 * 从底向上的动态规划
 *
 *
 * 1 记忆化搜索 回溯 + 记忆
 * 2 动态规划
 *
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount +1;
        // 对 amount 进行动态规划
        int[] dp = new int[amount +1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j ++) {

                // 如果币值大于当前的总数，则直接不处理
                // 如果小于，则可以考虑获取 dp[i - coins[j] + 1的数据

                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }

            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    // 带记忆的搜索
    public int coinChange2(int[] coins, int amount) {

        if (amount < 0) {
            return 0;
        }

        return backtrack(coins, amount, new int[amount]);
    }

    // count 是记忆体的
    public int backtrack(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }

        if (rem == 0) {
            return 0;
        }

        // 因为 count 是长度就是 amount ，所以从0开始，需要-1
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = backtrack(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }

        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1: min;
        return count[rem-1];
    }

}