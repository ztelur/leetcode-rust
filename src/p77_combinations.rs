/**
https://leetcode.com/problems/combinations/


Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].

You may return the answer in any order.



Example 1:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
Example 2:

Input: n = 1, k = 1
Output: [[1]]


Constraints:

1 <= n <= 20
1 <= k <= n

**/
pub struct Solution {}

impl Solution {
    pub fn combine(n: i32, k: i32) -> Vec<Vec<i32>> {
        let mut all_solution:Vec<Vec<i32>> = vec![];
        Self::combine_help(n, k, 1, &mut Vec::new(), &mut all_solution);
        return all_solution;
    }

    fn combine_help(n:i32, k:i32, index: i32, one_solution: &mut Vec<i32>, all_solution: &mut Vec<Vec<i32>>) {
        if k == 0 {
            all_solution.push(one_solution.to_vec());
            return;
        }

        for i in index..= n - k + 1 {
            one_solution.push(i);
            Self::combine_help(n, k-1, i+1, one_solution, all_solution);
            one_solution.pop();
        }
    }
}