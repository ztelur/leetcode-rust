/**
https://leetcode.com/problems/unique-paths/

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Example 2:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
Example 3:

Input: m = 7, n = 3
Output: 28
Example 4:

Input: m = 3, n = 3
Output: 6

**/
pub struct Solution {}

impl Solution {
    // my error
    pub fn unique_paths11(m: i32, n: i32) -> i32 {
        if m == 1 && n == 1 {
            return 1;
        }

        let mut dp = vec![0, m];
        let mut old = vec![0, m];
        for i in 0..n {
            let mut sum = 1;
            if i != 0 {
                sum = old[0];
            }
            for j in 0..m {
                dp[j as usize] = sum + old[i as usize] + sum;
            }
            old = dp.clone();
        }
        return dp[m as usize]
    }

    //

    pub fn unique_paths(m: i32, n: i32) -> i32 {
        let (m, n) = (m as usize, n as usize);
        let mut count = vec![1; n];
        for i in 1..m {
            for j in 1..n {
                count[j] += count[j - 1];
            }
        }
        count[n - 1]
    }

}