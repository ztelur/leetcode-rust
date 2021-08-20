use std::collections::HashSet;

/**
https://leetcode.com/problems/word-break/

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.



Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false


Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.



这种使用记忆数组 memo 的递归写法，和使用 dp 数组的迭代写法，乃解题的两大神器，凡事能用 dp 解的题，一般也有用记忆数组的递归解法，好似一对形影不离的好基友



**/

pub struct Solution {}

impl Solution {

    pub fn word_break(s: String, word_dict: Vec<String>) -> bool {
        let n = s.len();
        let mut pref_dp: Vec<bool> = vec![false; n + 1];
        pref_dp[0] = true;
        let mut dict: HashSet<String> = word_dict.into_iter().collect();
        for i in 1..=n {
            for j in (0..= i - 1).rev() {
                if pref_dp[j] & dict.contains(&s[j..=i-1]) {
                    pref_dp[i] = true;
                    break;
                }
            }
        }
        return pref_dp[n];
    }
}