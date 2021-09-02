/**
https://leetcode.com/problems/multiply-strings/

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.



Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"


Constraints:

1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
**/

pub struct Solution {}

impl Solution {
    pub fn multiply(num1: String, num2: String) -> String {
        let mut ans = vec![0;num1.len() + num2.len()];

        for (i, ch1) in num1.chars().rev().peekable().enumerate() {
            for (j, ch2) in  num2.chars().rev().peekable().enumerate() {
                let a = ch1.to_digit(10).unwrap();
                let b = ch2.to_digit(10).unwrap();

                let lo = (a * b + ans[i + j]) %10;
                let hi = (a *b + ans[i + j]) / 10;
                ans[i + j] = lo;
                ans[i + j + 1] += hi;
            }
        }

        while ans.len() > 1 && ans.last() == Some(&0) {
            ans.pop();
        }
        ans.into_iter().rev().map(|s|s.to_string()).collect::<String>()
    }
}