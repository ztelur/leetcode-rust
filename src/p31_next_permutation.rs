use std::mem::swap;

/**
https://leetcode.com/problems/next-permutation/



Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.



Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]


Approach 2: Single Pass Approach





**/
pub struct Solution {}

impl Solution {
    pub fn next_permutation(nums: &mut Vec<i32>) {
        let s = nums.as_mut_slice();
        let mut i = s.len() - 1;
        while i >= 1 && s[i - 1] >= s[i] {
            i -= 1;
        }
        if i >= 1 {
            let mut j = s.len() - 1;
            while s[j] <= s[i - 1] {
                j -= 1;
            }
            s.swap(i - 1, j);
        }
        s[i..].reverse();
    }
}

