/**
https://leetcode.com/problems/permutations/

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]


Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.


**/

pub struct Solution {}

impl Solution {
    pub fn permute(nums: Vec<i32>) -> Vec<Vec<i32>> {
        fn backtrack(nums: &[i32], sub: &[i32], res: &mut Vec<Vec<i32>>) {
            if nums.len() == 0 {
                res.push(sub.to_vec());
                return;
            }

            for (i, v) in nums.iter().enumerate() {
                let (mut nums_c, mut sub_c) = (nums.to_vec(), sub.to_vec());
                nums_c.remove(i as usize);
                sub_c.push(*v);
                backtrack(&nums_c, &sub_c, res);
            }

        }

        let mut res: Vec<Vec<i32>> = vec![];
        backtrack(&nums, &vec![], res);
        return res;
    }
}