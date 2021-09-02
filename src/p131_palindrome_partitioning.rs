
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


1 backtracking

2 Backtracking with Dynamic Programming


Let NN be the length of the string. To determine if a substring starting at index \text{start}start and ending at index \text{end}end is a palindrome or not, we use a 2 Dimensional array \text{dp}dp of size N \cdot NN⋅N where,

\text{dp[start][end]} = \text{true}dp[start][end]=true , if the substring beginning at index \text{start}start and ending at index \text{end}end is a palindrome.

Otherwise, \text{dp[start][end] }== \text{false}dp[start][end] ==false.

Also, we must update the \text{dp}dp array, if we find that the current string is a palindrome.


 记 n 个字符的回文拆分方式是 f(n) 种, 则:

 f(n) = (0..n).iter().fold(0, |acc, i| {
    if is_palindrome(s[i..n]) { acc + f(i-1) } else { acc }
 })

 按这种方式向上递推即可, 时间复杂度为 O(N^3), 空间复杂度 O(N), 显然, is_palindrome 这一步仍然有重复计算

 is_palindrome(s[i..n]) = s[i] == s[n] && is_palindrome(s[i+1..n-1])

 存储所有 i, n 的 is_palindrome 结果, 则可以优化 is_palindrome 的时间到 O(1)

 最后的复杂度: 时间 O(N^2), 空间 O(N^2)



**/
pub struct Solution {}

impl Solution {
    pub fn partition(s: String) -> Vec<Vec<String>> {
        let mut res = vec![];
        let s: Vec<char> = s.chars().collect();
        Self::dfs_helper(&s, &mut vec![], &mut res, 0);
        res
    }

    fn dfs_helper(s: &Vec<char>, cans: &mut Vec<String>, res: &mut Vec<Vec<String>>, idx: usize) {
        if idx == s.len() {
            res.push(cans.clone());
        }

        for i in idx..s.len() {
            if !Self::is_palindrome(s, idx, i) {
                continue;
            }
            let can: String = s[idx..i + 1].into_iter().collect();
            cans.push(can);
            Self::dfs_helper(s, cans, res, i + 1);
            cans.pop();
        }
    }

    fn is_palindrome(s: &Vec<char>, start: usize, end: usize) -> bool {
        let (mut start, mut end) = (start, end);
        while start < end {
            if s[start] != s[end] {
                return false;
            }
            start += 1;
            end -= 1;
        }
        true
    }


    pub fn partition2(s: String) -> Vec<Vec<String>> {
        let s = s.chars().collect::<Vec<_>>();
        if s.is_empty() { return Vec::new() }
        let mut palindrome_cache = vec![vec![None; s.len()]; s.len()];
        let mut res: Vec<Vec<Vec<(usize, usize)>>> = Vec::with_capacity(s.len());
        res.push(vec![vec![(0,1)]]);
        for n in 1..s.len() {
            let mut curr: Vec<Vec<(usize, usize)>> = Vec::new();
            for i in 0..n+1 {
                if Solution::is_palindrome2(&mut palindrome_cache, &s, i, n) {
                    if i > 0 {
                        for vec in res[i-1].iter() {
                            let mut new_vec = vec.clone();
                            new_vec.push((i,n+1));
                            curr.push(new_vec);
                        }
                    } else {
                        curr.push(vec![(i, n+1)]);
                    }
                }
            }
            res.push(curr);
        }
        (*res[s.len()-1]).into_iter().map(|vec| {
            vec.iter()
                .map(|&range| {s[range.0..range.1].iter().collect::<String>()})
                .collect::<Vec<_>>()
        }).collect()
    }

    fn is_palindrome2(cache: &mut Vec<Vec<Option<bool>>>, s: &Vec<char>, i: usize, j: usize) -> bool {
        if j <= i { return true }
        if let Some(result) = cache[i][j] {
            result
        } else {
            let result = s[i] == s[j] && (i + 1 > s.len() || j < 1 || Self::is_palindrome2(cache, s, i+1, j-1));
            cache[i][j] = Some(result);
            result
        }
    }
}