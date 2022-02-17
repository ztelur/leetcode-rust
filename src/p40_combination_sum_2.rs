/**
https://leetcode.com/problems/combination-sum-ii/



Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.



Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]


https://leetcode-cn.com/problems/combination-sum-ii/solution/zu-he-zong-he-ii-by-leetcode-solution/
**/

pub struct Solution {}

impl Solution {
    pub fn combination_sum2(candidates: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        let mut seq = candidates;
        let mut res = Vec::new();
        // 排序
        seq.sort_unstable_by(|a,b|{b.cmp(a)});
        let mut vec = Vec::new();
        Solution::backtrack(&seq, target, vec, &mut res, 0);
        res
    }

    fn backtrack(seq: &Vec<i32>, target: i32, mut curr: Vec<i32>, result: &mut Vec<Vec<i32>>, start_idx: usize) {
        let mut i = start_idx;

        while i < seq.len() {
            let item = seq[i];
            if target - item < 0 {
                i += 1;
                continue;
            }

            let mut new_vec = curr.clone();
            new_vec.push(item);
            if target == item {
                result.push(new_vec);
            } else {
                Solution::backtrack(seq, target - item, new_vec, result, i + 1);
            }
            // 去除重复
            while i < seq.len() && seq[i] == item {
                i += 1;
            }
        }
    }
}