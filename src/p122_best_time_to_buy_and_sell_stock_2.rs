use std::thread::sleep;
use std::cmp::max;

/**
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/


You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).



Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e., max profit = 0.


Constraints:

1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104



!!!!!!!!!!!!!
**/

pub struct Solution {}

impl Solution {
    // Non Dp Approach.
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        let mut profit = 0;

        for i in 0..prices.len() -1 {
            if prices[i + 1] > prices[i] {
                profit = profit + (prices[i + 1] - prices[i])
            }
        }
        return profit;
    }
    // dp
    pub fn max_profit_dp(prices: Vec<i32>) -> i32 {

        let mut buy = vec!(0 as i32, prices.len() as i32);
        let mut sell = vec!(0 as i32, prices.len() as i32);
        buy[0] = -1 * prices[0];
        println!("ddd {} {}", buy.len(), prices.len() as i32);

        for i in 1..(prices.len() -1) {
            buy[i] = max(buy[i -1],sell[i - 1]- prices[i]);
            sell[i] = max(sell[i - 1], buy[i -1] + prices[i]);
        }
        return sell[sell.len()-1];
    }

}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test() {
        assert_eq!(7, Solution::max_profit_dp(vec![7,1,5,3,6,4]));
    }
}