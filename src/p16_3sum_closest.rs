/**

https://leetcode.com/problems/3sum-closest/



Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.



Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0


**/

pub struct Solution {}

impl Solution {
    pub fn three_sum_closest(nums: Vec<i32>, target: i32) -> i32 {
        if nums.len() <= 3 {
            return nums.into_iter().sum();
        }

        let mut nums = nums;
        // 先排序，可以使用有序的列表
        nums.sort();

        let mut closest = nums[0] + nums[1] + nums[2];
        let mut min_diff = (closest - target).abs();

        let mut a = 0;
        // 先确定一个数字，然后另外两个指针从两头向中间移动
        while a < nums.len() - 2 {
            let mut b = nums.len() - 1;
            let mut c = a + 1;

            while c < b {

                let sum = nums[a] + nums[b] + nums[c];
                let diff = (sum - target).abs();
                // 和最值进行对比
                if diff < min_diff {
                    closest = sum;
                    min_diff = diff;
                }

                if sum > target {
                    b -=1;
                } else if sum < target {
                    c +=1;
                } else {
                    return closest;
                }
            }

            a += 1;
        }

        return closest;
    }

}