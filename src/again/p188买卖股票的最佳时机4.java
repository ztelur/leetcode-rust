package again;

import java.util.Arrays;

class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        // 一共最大值
        int n = prices.length;
        // 计算这么多日，和最大k 一共看可以真正操作几次
        k = Math.min(k, n / 2);
        //
        int[][] buy = new int[n][k + 1];
        int[][] sell = new int[n][k + 1];

        // 0 天 第一次持有当然是 -prices
        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        // 边缘情况，也就是第0天都是最小值
        for (int i = 1; i <= k; ++i) {
            buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
        }

        // buy[i][j] 表示对于数组 \textit{prices}[0..i]prices[0..i] 中的价格而言，进行恰好 jj 笔交易，并且当前手上持有一支股票，这种情况下的最大利润；用 \textit{sell}[i][j]sell[i][j] 表示恰好进行 jj 笔交易，并且当前手上不持有股票，这种情况下的最大利润
        // 从 1 开始 到 n
        for (int i = 1; i < n; ++i) {
            // i 的 0 表示第 i 进行了0比交易，当前持有股票的价格。
            // 等于sell i - 1 的 0 和 今天进行买入。
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            // 然后计算从1比交易到 k 笔交易
            for (int j = 1; j <= k; ++j) {
                // 和  0 次类似
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                // sell 要进行 注意这里是要 +
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }
        // 最后 sell 的 n - 1 这个行的所有的数据中最大的。
        return Arrays.stream(sell[n - 1]).max().getAsInt();
    }
}
