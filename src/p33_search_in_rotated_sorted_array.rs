/**
https://leetcode.com/problems/search-in-rotated-sorted-array/


There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1

循环链表中存在这样一个性质（事实）：将数组从中间点劈开，会将数组分成两部分，分别是循环有序数组部分和有序数组部分。

为了找到目标元素 target，我们可以先找到数组的有序部分，然后再判断目标元素是否在有序数组部分中。

如果首元素小于中间元素mid，那么前半部分是有序的，后半部分是循环有序数组（如 4 5 6 7 8 1 2 3）；
如果首元素大于中间元素 mid，那么后半部分是有序的，前半部分是循环有序数组（如 5 6 1 2 3 4）；
如果 target 在有序数组部分中，则对有序部分使用二分查找；
如果目标元素在循环有序数组中，则重新设定数组边界后，重复上述步骤。
————————————————
版权声明：本文为CSDN博主「天亥的梦呓」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/big_rotor/article/details/100088473


将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.

**/

pub struct Solution {}

impl Solution {
    pub fn search(nums: Vec<i32>, target: i32) -> i32 {
        let (mut left, mut right) = (0, nums.len() - 1);
        while left < right && right != std::usize::MAX {
            if nums[left] == target {
                return left as i32;
            } else if nums[right] == target {
                return right as i32;
            }

            let mid = (right + left) / 2;
            if nums[mid] == target {
                return mid as i32;
            }

            if nums[left] > nums[right] {
                left += 1;
                right -= 1;
            } else {
                if nums[mid] > target {
                    right = mid - 1;
                    left += 1;
                } else {
                    left = mid +1;
                    right -= 1;
                }
            }
        }
        -1
    }
}
