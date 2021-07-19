use std::panic::resume_unwind;
use std::cmp::Ordering;

/**
https://leetcode.com/problems/search-insert-position/


Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
Example 4:

Input: nums = [1,3,5,6], target = 0
Output: 0
Example 5:

Input: nums = [1], target = 0
Output: 0


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104



**/

pub struct Solution {}

impl Solution {

    pub fn b_search(nums: Vec<i32>, target: i32, left : i32, right : i32) -> i32 {
        if (left >= right) {
            return left;
        }

        let mid = (left + right) / 2;
        let itr = nums[mid];
        if itr == target {
            return mid;
        } else if itr > target {
            return b_search(nums, target, left, mid - 1)
        } else {
            return b_search(nums, target, mid + 1, right)
        }
    }

    // pub fn search_insert(nums: Vec<i32>, target: i32) -> i32 {
    //     if nums.is_empty() {
    //         return 0 as i32;
    //     }
    //     let len = nums.len();
    //     return b_search(nums, target, 0, len - 1);
    // }

    pub fn search_insert(nums: Vec<i32>, target: i32) -> i32 {
        let (mut low, mut high) = (0i32, nums.len() as i32 - 1);

        while low <= high {
            let mid = low + (high - low) / 2;

            match nums[mid as usize].cmp(&target) {
                Ordering::Equal => { return mid; }
                Ordering::Greater => { high = mid - 1; }
                Ordering::Less => { low = mid + 1; }
            }
        }

        low
    }
}