/**

https://leetcode.com/problems/regular-expression-matching/

Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).



Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input: s = "aab", p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
Example 5:

Input: s = "mississippi", p = "mis*is*p*."
Output: false


Constraints:

1 <= s.length <= 20
1 <= p.length <= 30
s contains only lowercase English letters.
p contains only lowercase English letters, '.', and '*'.
It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.



two point


dp


Approach 1: Recursion
Approach 2: Dynamic Programming


class Solution {
    public boolean isMatch(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--){
            for (int j = pattern.length() - 1; j >= 0; j--){
                boolean first_match = (i < text.length() &&
                                       (pattern.charAt(j) == text.charAt(i) ||
                                        pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}

**/

pub struct Solution {}

impl Solution {


    pub fn is_match(s: String, p: String) -> bool {
        fn is_match_str(s: &str, p: &str) -> bool {
            let (s_len, p_len) = (s.len(), p.len());
            if p_len == 0 {
                return s_len == 0;
            }
            // 46 is .
            let m = { s_len >0 && (s.as_bytes()[0] == p.as_bytes()[0] || p.as_bytes()[0] == 46 )};
            // 43 is *
            if p_len >= 2 && p.as_bytes()[1] == 42 {
                // 分两种情况
                // 1 跳过*的组合，完全不匹配
                // 2 进行匹配，当前字段删除掉一位
                return is_match_str(s, &p[2..]) || (m && is_match_str(&s[1..],p));
            }
            // 因为不存在*，所以两个都-1
            return m && is_match_str(&s[1..], &p[1..]);
        }
        return is_match_str(&s,&p);
    }




    // pub fn is_match1(s: String, p: String) -> bool {
    //     let mut si = 0;
    //     let mut pi = 0;
    //
    //     loop {
    //         // string 已经检查完
    //         if si == s.len() {
    //             return true;
    //         }
    //
    //         // string未检查完，regix完了，失败
    //         if pi == p.len() {
    //             return false;
    //         }
    //
    //         let mut cs = s.chars().nth(si).unwrap();
    //         let mut cp = s.chars().nth(pi).unwrap();
    //
    //
    //         if cp == cs {
    //             si += 1;
    //             pi += 1;
    //         } else {
    //             if cp == '.' {
    //                 si += 1;
    //                 pi += 1;
    //             } else if cp == '*' {
    //                 // 需要检查前一个
    //                 let prei = pi - 1;
    //
    //                 if prei > 0 {
    //                     let pre = p.chars().nth(prei).unwrap();
    //                     if cp == pre || pre == '.' {
    //                         si += 1;
    //                         pi += 1;
    //                     } else {
    //                         return false;
    //                     }
    //
    //                 } else {
    //                     return false;
    //                 }
    //
    //             } else {
    //                 return false;
    //             }
    //         }
    //     }
    // }
}
