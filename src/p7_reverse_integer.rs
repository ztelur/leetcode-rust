/**
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).



Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
Example 4:

Input: x = 0
Output: 0


Constraints:

-231 <= x <= 231 - 1
**/
pub struct Solution {}

impl Solution {
    pub fn reverse(x: i32) -> i32 {
        let mut res = 0;
        let mut sign = 1;

        if x < 0 {
            sign = -1;
        }

        let mut x = x.abs();
        while x > 0 {
            let new = res * 10 + x % 10;
            if (new - x % 10) / 10 != res {
                return 0;
            }
            res = new;
            x = x / 10
        }
        return res * sign;
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn reverse_test() {
        assert_eq!(4321, Solution::reverse(1234));
        assert_eq!(4433, Solution::reverse(3344));
    }
}

