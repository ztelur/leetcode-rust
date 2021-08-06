/**
https://leetcode.com/problems/palindrome-partitioning/

Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.



Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]


思考：
1 backtrack

substring





**/
pub struct Solution {}

impl Solution {

    fn check(s: &String) -> bool {
        let (mut i, mut j) = (0,s.len() -1);
        while i < j {
            if s[i] != s[j] {
                return false;
            }
            i += 1;
            j -= 1;
        }
        return true;
    }

    fn backtrack(s: &String, cur: &String, index: usize, res: &mut Vec<Vec<String>>) {
        if index == s.len() {
            return;
        }
        for i in index..s.len() {
            let mut new = cur.clone();
            new.push(s[i]);
            if Solution::check(&new) {
                res.push(new.chars().collect());
            }
            Solution::backtrack(s, &new, i + 1, res);
        }
    }

    pub fn partition(s: String) -> Vec<Vec<String>> {
        let mut res = Vec
        Solution::backtrack(s, "", 0, )
    }
}