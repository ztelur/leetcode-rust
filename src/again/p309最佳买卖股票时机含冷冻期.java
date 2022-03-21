package again;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        // 三个状态，然后是一维dp的数组。
        int[][] f = new int[n][3];
        // 这个只有一种状态，就是 买入。
        f[0][0] = -prices[0];
        // 从 1开始
        for (int i = 1; i < n; ++i) {
            // 今天持有股票的收益等于 前一天持有，今天未操作和大前天卖掉，今天继续买入的最大值
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            // 今天不持有并且是冷冻期 = 昨天还持有+今天卖掉
            f[i][1] = f[i - 1][0] + prices[i];
            // 今天不持有并且不是冷冻期 f[i-1][1] 和 f[i-1][2]
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        // 判断后两种情况
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }
}
