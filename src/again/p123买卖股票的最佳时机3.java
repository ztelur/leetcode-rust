package again;

class Solution {
    /**
     * 因为只能进行2次交易，所以一共有 5 个状态
     * 未进行过任何操作；
     *
     * 只进行过一次买操作；
     *
     * 进行了一次买操作和一次卖操作，即完成了一笔交易；
     *
     * 在完成了一笔交易的前提下，进行了第二次买操作；
     *
     * 完成了全部两笔交易。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        // 从 1 开始
        for (int i = 1; i < n; ++i) {
            // 对于买一手
            buy1 = Math.max(buy1, -prices[i]);
            // 对于卖一手
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
