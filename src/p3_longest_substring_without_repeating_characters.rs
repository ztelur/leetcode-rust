use std::collections::HashMap;

/**
https://leetcode.com/problems/longest-substring-without-repeating-characters/
Given a string s, find the length of the longest substring without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0


hashmap + 两个指针的滑动窗口
**/

pub struct Solution {}

use std::collections::HashMap;

impl Solution {
    pub fn length_of_longest_substring(s: String) -> i32 {
        let mut hash = HashMap::with_capacity(s.len());
        let mut max = 0;
        let mut start = 0;
        let mut end = 0;

        for (i, item) in s.chars().enumerate() {
            if let Some(j) = hash.get(&item) {
                // 有值，说明有重复，然后检查是否在当前窗口呢
                if *j >= start {
                    let curr = end - start;
                    if max < curr {
                        max = curr;
                    }
                    // move window
                    start = *j + 1;
                }
            }
            end +=1;
            hash.insert(item, i);
        }

        let cur = end - start;
        if max < cur {
            max = cur
        }
        return max as i32;
    }
}