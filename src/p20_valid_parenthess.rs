/**
https://leetcode.com/problems/valid-parentheses/
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true


Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.


给出算法的时间复杂度和空间复杂度，以及算法所使用的思维

stack ！！！ 解决线性配对问题
**/

pub struct Solution {}

impl Solution {
    pub fn is_valid(s: String) -> bool {
        let mut stack = Vec::new();
        for c in s.chars() {
            let c1 = match c {
                '(' => ')',
                '{' => '}',
                '[' => ']',
                _ => {
                    if Some(c) != stack.pop() {
                        return false;
                    }
                    continue;
                }
            };
            stack.push(c1);
        }
        return stack.is_empty();
    }
}