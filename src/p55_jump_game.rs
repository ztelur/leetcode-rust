/**
https://leetcode.com/problems/jump-game/


You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.



Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.


Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105

[2,3,1,1,4]

[2,3] true 0 -> 1 use 1 < 2
[2,3,1] true 0 -> 2 use 2 <=2 or true 0 -> 1 -> 2 use 1,1
[2,3,1,1] true 0->1->3


**/

pub struct Solution {}

impl Solution {
    pub fn can_jump(nums: Vec<i32>) -> bool {
        let mut len = nums.len();
        let mut max_jump = 0;

        for (i, &value) in nums.iter().enumerate() {
            if i > max_jump {
                return false;
            }

            max_jump = max_jump.max(i + value as usize);
        }

        true
    }
}
