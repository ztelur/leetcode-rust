package again;

public class Solution {
    public int maxProfit(int prices[]) {
        // 记录最小值
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        // 一次遍历
        for (int i = 0; i < prices.length; i++) {
            // 如果当前值小于最小值
            if (prices[i] < minprice) {
                // 进行记录
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                // 如果当前值减去最小值大于最大值，则进行替换
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
