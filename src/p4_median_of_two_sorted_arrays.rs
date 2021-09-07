/**
https://leetcode.com/problems/median-of-two-sorted-arrays/

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:

Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
Example 4:

Input: nums1 = [], nums2 = [1]
Output: 1.00000
Example 5:

Input: nums1 = [2], nums2 = []
Output: 2.00000

有序列表，都可以考虑二分查找


在两个列表上进行二分查找

**/

pub struct Solution {}

impl Solution {
    pub fn find_median_sorted_arrays(nums1: Vec<i32>, nums2: Vec<i32>) -> f64 {
        let first;
        let second;
        // 小的为first，大的为second
        if nums1.len() <= nums2.len() {
            first = nums1;
            second = nums2;
        } else {
            first = nums2;
            second = nums1;
        }

        let mut low = 0;
        let mut high = first.len();

        let mut part_x;
        let mut part_y;

        while low <= high {
            part_x = (low + high) / 2;
            part_y = (first.len() + second.len() + 1) / 2 - part_x;

            let one_left = if part_x == 0 { std::i32::MIN} else {first[part_x - 1]};
            let one_right = if part_x == first.len() { std::i32::MAX } else { first[part_x]};

            let two_left = if part_y == 0 { std::i32::MIN } else { second[part_y - 1]};
            let two_right = if part_y == second.len() { std::i32::MAX } else { second[part_y]};

            if one_left <= two_left && two_left <= one_right {
                if (first.len() + second.len()) % 2 == 0 {
                    return f64::from(one_left.max(two_left) + one_right.min(two_right)) / 2.0;
                } else {
                    return f64::from(one_left.max(two_left));
                }
            } else if one_left > two_right {
                high = part_x - 1;
            } else {
                low  = part_x + 1;
            }
        }
        panic!("Wrong arrays");
    }
}