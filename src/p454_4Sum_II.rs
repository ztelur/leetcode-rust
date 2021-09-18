use std::collections::HashMap;

/**
https://leetcode.com/problems/4sum-ii/


Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:

0 <= i, j, k, l < n
nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0


Example 1:

Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
Output: 2
Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
Example 2:

Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
Output: 1
**/

pub struct Solution {}


impl Solution {
    pub fn four_sum_count(mut nums1: Vec<i32>, mut nums2: Vec<i32>, mut nums3: Vec<i32>, mut nums4: Vec<i32>) -> i32 {
        let mut ans = 0;
        let mut map= HashMap::new();

        for i in 0..nums1.len() {
            for j in 0..nums2.len() {
                *map.entry(nums1[i] + nums2[j]).or_insert(0) += 1;
            }
        }

        for i in 0..nums3.len() {
            for j in 0..nums4.len() {
                ans += map.get(&(0 - nums3[i] - nums4[j])).unwrap_or(&0);
            }
        }

        return ans;
    }
}