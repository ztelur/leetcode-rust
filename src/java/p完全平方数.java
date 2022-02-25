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
    /**
     * 使用动态规划 f(i) = f(m) + f(n); 其中
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        // 16 16 = 1
        //
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j ++) {
                // 当 16 是，就会是 dp[0]
                // 假设当前枚举到 jj，那么我们还需要取若干数的平方，构成 i-j^2i−j
                //2
                // 。此时我们发现该子问题和原问题类似，只是规模变小了
                // 然后就是全部都列举，然后取最小值
                minn = Math.min(minn, dp[i - j * j]);
            }
            dp[i] = minn + 1;
        }
        return dp[n];
    }

//    错误的实现方式，因为会出现 4 4 4 而不是 9 1 1 1 的方案
//    public int numSquares(int n) {
//
//        int i = 1;
//        // n = 12 i = 4
//        while ( i * i <= n) {
//            i ++;
//        }
//
//        // maxPart = 3
//        int maxPart = i - 1;
//        int j = maxPart;
//        int curr = n;
//        int ans = 0;
//        while (curr > 0) {
//            // inc = 1,0,3
//            int inc = curr / (j * j);
//            // delta = 3,3,0
//            int delta = curr % (j * j);
//            // ans = 1,1,4
//            ans += inc;
//            // cur = 3,3
//            curr = delta;
//            // j = 2 1
//            j = j - 1;
//        }
//        return ans;
//    }
}