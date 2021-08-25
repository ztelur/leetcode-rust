/**
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.



Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400



1 backtracking可以搞
2 dp

f(i) = f(i-2) : f(i-3) + a[i]

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.


[2] = 2
[2,7] = 7
[2,7,9] = 2 + 9 > 7 = 11
[2,7,9,3] = 2 + 9 > 7 + 3 = 11
[2,7,9,3,1] = 2 + 9 < 2 + 9 + 1

**/

pub struct Solution {}

impl Solution {
    pub fn rob(nums: Vec<i32>) -> i32 {

        let n = nums.len();
        if n == 1 {
            return nums[0]
        }
        let mut first = 0;
        let mut second = nums[0];

        for i in 1..n {
            let mut cur = first + nums[i];
            if cur < second {
                cur = second;
            }
            first = second;
            second = cur;
        }
        return second;
    }
}



