/**
https://leetcode.com/problems/subsets/

Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]


Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
**/
pub struct Solution {}


impl Solution {
    pub fn subsets(nums: Vec<i32>) -> Vec<Vec<i32>> {
        let mut set = vec![];
        let mut res = vec![];
        Solution::helper(&nums, 0, &mut set, &mut res)
        return res;
    }

    fn helper(nums: & Vec<i32>, start: usize, set: &mut Vec<i32>, res: &mut Vec<Vec<i32>>) {
        if start >= nums.len() {
            res.push(set.clone());
            return;
        }

        set.push(nums[start]);
        Solution::helper(nums, start + 1, set, res);
        set.pop();
        Solution::helper(nums, start + 1, set, res);
    }

}