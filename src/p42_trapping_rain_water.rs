use std::cmp::{min, max};
use std::collections::VecDeque;

/**
https://leetcode.com/problems/trapping-rain-water/


Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.



Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.



Input: height = [4,2,0,3,2,5]
Output: 9
 **/

pub struct Solution {}

impl Solution {
    pub fn trap2(height: Vec<i32>) -> i32 {
        let mut stack = VecDeque::<usize>::new();
        let mut rain = 0;
        for (i, h) in height.iter().enumerate() {
            while !stack.is_empty() && height[*stack.back().unwrap()] <= *h {
                let ch = height[stack.pop_back().unwrap()];
                rain += stack
                    .back()
                    .map(|&bi| (h.min(&height[bi]) - ch) * (i - bi - 1) as i32)
                    .unwrap_or(0);
            }
            stack.push_back(i);
        }
        rain
    }
    pub fn trap(height: Vec<i32>) -> i32 {
        let len = height.len();

        if len <= 2 {
            return 0;
        }

        let mut total_water = 0;

        let mut left_max_height = 0;
        let mut right_max_height = 0;

        let mut left = 0;
        let mut right = len - 1;


        while (left < right) {
            let left_height = height[left];

            if left_height > left_max_height {
                // 如果大于，则停止，重新开始计算
                left_max_height = left_height;

                // 右侧的一致，只不过是反了过来
                while (right > left) {
                    let right_height = height[right];

                    right_max_height = max(right_height, right_max_height);

                    if right_max_height > left_max_height {
                        break;
                    } else {
                        let fill = right_max_height - right_height;
                        total_water += fill;
                    }
                    right -= 1;
                }
            } else {
                // 如果小于，则表明可以存水
                total_water += left_max_height - left_height;
            }
            left += 1;
        }
        return total_water;
    }
}