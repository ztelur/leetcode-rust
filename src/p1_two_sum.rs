/**
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.


Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
**/

pub struct Solution {}

use std::collections::HashMap;
impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        // 暴力枚举法
        // let len = nums.len();
        // for i in 0..len {
        //     for j in i+1..len {
        //         if nums[i] + nums[j] == target {
        //             return vec![i as i32, j as i32];
        //         }
        //     }
        // }
        // vec![]

        // 利用HashMap, 一次遍历
        let mut map = HashMap::new();
        for (index, num) in nums.iter().enumerate() {
            if let Some(&other_index) = map.get(&(target - num)) {
                return vec![other_index as i32, index as i32]
            } else {
                map.insert(num, index);
            }
        }
        vec![]
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn two_sum_test() {
        assert_eq!(vec![0, 1], Solution::two_sum(vec![2, 7, 11, 15], 9));
        assert_eq!(vec![1, 2], Solution::two_sum(vec![3, 2, 4], 6));
    }
}
