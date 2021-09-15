/**
https://leetcode.com/problems/4sum/

Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.



Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]


1 暴力破解法

2 类似的累加都可以先排一下序，这样数组有序后，做判断更加容易


Approach 1: Two Pointers
https://leetcode.com/problems/4sum/solution/

**/

pub struct Solution {}

impl Solution {
    pub fn four_sum(mut nums: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        let mut res = vec![];

        if nums.len() < 4 {
            return res;
        }

        nums.sort();

        for i in 0..nums.len() - 3 {
            // 重复的字段只处理一次
            if i > 0 && nums[i] == nums [i -1] {
                continue;
            }

            for j in i+1..nums.len() - 2 {

                if  j > i + 1 && nums[j] == nums[j - 1] {
                    continue;
                }

                let t2 = target  - nums[i] - nums[j];

                let (mut lo, mut hi) = (j + 1, nums.len() - 1);

                let min2sum = nums[lo] + nums[lo + 1];
                let max2sum = nums[hi] + nums[hi - 1];

                // 不可能找到
                if min2sum > t2 || max2sum < t2 {
                    continue;
                }

                while lo < hi {
                    if lo > j + 1 && nums[lo] == nums[lo -1] {
                        lo += 1;
                        continue;
                    }

                    let sum = nums[lo] + nums[hi];
                    if sum < t2 {
                        lo +=1;
                    } else if sum > t2 {
                        hi -= 1;
                    } else {
                        res.push(vec![nums[i],nums[j],nums[lo],nums[hi]]);
                        lo +=1;
                        hi -=1;
                    }
                }
            }

        }
        return res;
    }
}