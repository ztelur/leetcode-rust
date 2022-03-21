package again;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        // 经典的1维
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        // 注意这里是反过来的。
        dp[0] = 0;
        // 从 1 开始
        for (int i = 1; i <= amount; i++) {
            // 从 第一个零钱开始
            for (int j = 0; j < coins.length; j++) {
                // 如果当前的币种小于，则
                if (coins[j] <= i) {
                    // dp[i], dp[i-coins[j] + 1]
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        // 如果大于，表示没有数据计算的出来。
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
