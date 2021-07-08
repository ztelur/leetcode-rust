/**
https://leetcode.com/problems/longest-common-prefix/
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.
**/
pub struct Solution {}

impl Solution {
    pub fn longest_common_prefix(strs: Vec<String>) -> String {
        if strs.len() == 0 {
            return "".to_string();
        }

        let min_len = strs.iter().map(|s| s.len()).min().unwrap();

        for i in 0..min_len {
            let ch = strs[0].chars().nth(i).unwrap();
            for s in &strs {
                if s.chars().nth(i).unwrap() != ch {
                    return s[0..i].to_string();
                }
            }
        }
        return strs[0][..min_len].to_string();
    }
}