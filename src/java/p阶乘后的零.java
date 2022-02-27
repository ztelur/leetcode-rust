package java;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/x2we65/
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 *
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 * 匹配 2 和 5 的出现的数量
 */

public class Solution {
    public int trailingZeroes(int n) {
        int zeroCount = 0;
        // We need to use long because currentMultiple can potentially become
        // larger than an int.
        //
        long currentMultiple = 5;
        //
        while (n >= currentMultiple) {
            // 计算有几个 5，有几个5就有几个0
            // 而且 2 5 10 15 一共正好 15、5 = 3 也就是3个0
            // 5 10 15 20 25 = 25 / 5 + 25 / 25
            //
            zeroCount += (n / currentMultiple);
            // 直接一次性乘以 5
            currentMultiple *= 5;
        }
        return zeroCount;
    }
}
