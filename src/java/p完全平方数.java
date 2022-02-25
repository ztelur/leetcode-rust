/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2022 All Rights Reserved.
 */
package java;

/**
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * @author libing
 * @version $Id: p完全平方数.java, v 0.1 2022年02月25日 下午4:02 zt Exp $
 *
 * n = 12 输出3 12 = 4 + 4 + 4
 * n  = 13 输出 2 13 = 4 + 9
 *
 * 暴力方法：从 1 开始，每次相乘, 直到 i * i > n
 * 那么 n1 = n % (i-1)*(i-1) = n2
 * 接着处理 n2，使用相同的场景，直到 i - 1 = 1;
 *
 */
class Solution {
    public int numSquares(int n) {
        int i = 1;
        while ( i * i <= n) {
            i ++;
        }

        int maxPart = i - 1;
        int j = maxPart;
        int curr = n;
        int ans = 0;
        while (curr > 0) {
            int inc = curr / j;
            int delta = curr % j;
            ans += inc;
            curr = delta;
        }
        return ans;
    }
}