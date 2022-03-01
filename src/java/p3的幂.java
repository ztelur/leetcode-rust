package java;

import java.util.Map;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/x2lkle/
 *
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 *
 */

class Solution {
    public boolean isPowerOfThree(int n) {

        int curr = n;
        while (curr != 0 && curr % 3 == 0) {
            curr = curr / 3;
        }
        return curr == 1;
    }
}
