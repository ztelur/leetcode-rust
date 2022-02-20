package java;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 * 1,1,1,0,0
 * 0,1,1,1
 * 0,1,0,1 => 1,0,0,1 =>
 *
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int left = 0, right = 0;
        // left 指向第一个为0的位置
        // right 指向当前遍历的位置。
        while (right < len) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left ++;
            }
            right ++;
        }
    }
}
