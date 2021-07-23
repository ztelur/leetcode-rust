/**
https://leetcode.com/problems/pascals-triangle/

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:




Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]


Constraints:

1 <= numRows <= 30

**/

pub struct Solution {}

impl Solution {
    pub fn generate(num_rows: i32) -> Vec<Vec<i32>> {
        let mut res = Vec::new();
        for x in 0..num_rows as usize {
            res.push(vec![1;x + 1]);
            for y in 1..x {
                res[x][y] = res[x - 1][y-1] + res[x - 1][y];
            }
        }
        return res;
    }
}