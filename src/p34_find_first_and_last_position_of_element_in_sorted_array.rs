
/**
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]


**/

pub struct Solution {}

impl Solution {
    pub fn search_range(nums: Vec<i32>, target: i32) -> Vec<i32> {
        fn search_inner(nums: &Vec<i32>, l :i32, r: i32, target: i32) -> Vec<i32> {
            if nums.len() == 0 || l > r {
                return vec![-1, -1];
            }
            let mid = (l + r) / 2;
            let m = nums[mid as usize];

            if m < target {
                return search_inner(nums, mid + 1, r, target);
            } else if m > target {
                return search_inner(nums, l, mid - 1, target);
            } else {
                // 找到了目标，但是仍然要向两侧寻找
                let l = search_inner(nums, l, mid - 1, target);
                let r = search_inner(nums, mid + 1, r, target);

                let l = if l[0] == -1 { mid as i32 } else { l[0]};
                let r = if r[1] == -1 { mid as i32 } else { r[1]};
                return vec![l, r];
            }

        }

        search_inner(&nums, 0, nums.len() as i32 -1, target)
    }
}