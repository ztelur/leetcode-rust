package java;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/x2dj82/
 *
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 */

public class Solution {
    public int hammingWeight(int n) {
        int ret = 0;
        //
        for (int i = 0; i < 32; i++) {
            // n & (1 << i) 来判断这一位是否为0
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }
}
