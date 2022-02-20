package java;

import java.util.Random;

/**
 * https://leetcode-cn.com/problems/shuffle-an-array/
 *
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是 等可能 的。
 *
 * 实现 Solution class:
 *
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shuffle-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
    private int[] nums;
    private int[] origin;

    public Solution(int[] nums) {
        this.origin = nums;
        this.nums = new int[nums.length];
        System.arraycopy(this.origin, 0, this.nums, 0, this.origin.length);
    }

    public int[] reset() {
        System.arraycopy(this.origin, 0, this.nums, 0, this.origin.length);
        return this.nums;
    }

    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < this.nums.length; i ++) {
            int j = i + random.nextInt(this.nums.length - i);
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
        }
        return this.nums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
