package again;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 一买一卖
        int[][] dp = new int[n][2];
        // 定义状态 \textit{dp}[i][0]dp[i][0] 表示第 ii 天交易完后手里没有股票的最大利润，\textit{dp}[i][1]dp[i][1] 表示第 ii 天交易完后手里持有一支股票的最大利润（ii 从 00 开始）
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        // 进行转移
        for (int i = 1; i < n; ++i) {
            // 因为是要全部卖出，所以 dp[i-1][0] 和 dp[i-1][1] + prices[i] 的最大值
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 持有的收益等于 - prices 因为这天要进行买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
