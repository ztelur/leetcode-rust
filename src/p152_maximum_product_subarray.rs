/**
https://leetcode.com/problems/maximum-product-subarray/


Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

It is guaranteed that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.



Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.



**/

pub struct Solution {}

impl Solution {
    pub fn max_product(nums: Vec<i32>) -> i32 {
        let mut max = nums[0];
        let mut neg_max = 0;
        let mut pos_max = 0;
        for num in nums.into_iter() {
            if num == 0 {
                neg_max = 0;
                pos_max = 0;
                max = i32::max(max, 0);
            } else if num > 0 {
                pos_max = i32::max(pos_max * num, num);
                neg_max = neg_max * num;
                max = i32::max(max, pos_max);

            } else {
                let pos_pre = pos_max;
                pos_max = neg_max * num;
                neg_max = i32::min(pos_pre * num, num);
                max = i32::max(max, pos_max);
            }
        }
        return max;
    }
}

