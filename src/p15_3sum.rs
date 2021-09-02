/**
https://leetcode.com/problems/3sum/


Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []

**/


pub struct Solution {}

impl Solution {
    pub fn three_sum(nums: Vec<i32>) -> Vec<Vec<i32>> {
        if nums.len() < 3 {
            return vec![];
        }

        let mut ret = Vec::new();
        let mut nums = nums;

        nums.sort();

        let mut a = 0;

        while a < nums.len() - 2 {

            if nums[a] > 0 {
                return ret;
            }

            let mut b = nums.len() - 1;
            let mut c = a + 1;


            while c < b {
                let sum = nums[a] + nums[b] + nums[c];

                if sum == 0 {
                    ret.push(vec![nums[a], nums[b], nums[c]]);
                    c += 1;
                    b -= 1;
                } else if sum < 0 {
                    c += 1;
                } else {
                    b -=1;
                }
            }
            a += 1;
        }
        return ret;
    }
}