/**
https://leetcode.com/problems/divide-two-integers/


Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, assume that your function returns 231 − 1 when the division result overflows.



Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = truncate(3.33333..) = 3.
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = truncate(-2.33333..) = -2.
Example 3:

Input: dividend = 0, divisor = 1
Output: 0
Example 4:

Input: dividend = 1, divisor = 1
Output: 1

**/
pub struct Solution {}

impl Solution {
    pub fn divide(dividend: i32, divisor: i32) -> i32 {
        // 全部搞成正数
        let mut x = (dividend as i64).abs();
        let y = (divisor as i64).abs();

        let mut res: i64 = 0;

        if y == 0 {
            return std::i32::MAX;
        }

        // 通过减法
        while x >= y {
            let mut n = y;
            let mut i = 1;
            // 找到 x 比 n ^ 2 * m 最接近的大 也就是 m 是几
            while x >= (n << 1) {
                n <<= 1;
                i <<= 1;
            }
            // 指数级别比乘数级别要大很多，自然也更快
            x -= n;
            res += i;
        }

        if ((dividend <0) ^ (divisor < 0)) {
            res = -res;
        }

        if res > std::i32::MAX as i64 {
            return std::i32::MAX;
        }
        return res as i32;
    }
}

