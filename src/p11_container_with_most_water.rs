/**
https://leetcode.com/problems/container-with-most-water/

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.



Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
Example 3:

Input: height = [4,3,2,1,4]
Output: 16
Example 4:

Input: height = [1,2,1]
Output: 2



正常情况下就是枚举法，也就是O(n^2)

但是这个题目有一些缩减的办法，
首先，两个bar一左一右，减少一半
但是，注意其要计算出最大的值，那么就可以有一个

则，枚举法是有重复场景的

**/
use std::cmp;

pub struct Solution {

}

impl Solution {
    pub fn max_area(height: Vec<i32>) -> i32 {
        let mut r = height.len() - 1;
        let mut maxarea = 0;
        let mut l = 0;

        while l < r {
            let mut curr = cmp::min(height[l], height[r]) * (r as i32 - l as i32);
            maxarea = cmp::max(maxarea, curr);
            if height[l] < height[r] {
                l += 1;
            } else {
                r -= 1;
            }
        }
        return maxarea as i32;
    }
}
