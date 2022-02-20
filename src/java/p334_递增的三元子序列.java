package java;

/**
 * https://leetcode-cn.com/problems/increasing-triplet-subsequence/
 *
 * 贪心算法
 * 要推算局部最优解能达到全局最优解
 *
 * a < b < c
 * 第二种方法用人话说就是：
 * 赋初始值的时候，已经满足second > first了，现在找第三个数third
 * (1) 如果third比second大，那就是找到了，直接返回true
 * (2) 如果third比second小，但是比first大，那就把second的值设为third，然后继续遍历找third
 * (3) 如果third比first还小，那就把first的值设为third，然后继续遍历找third（这样的话first会跑到second的后边，但是不要紧，因为在second的前边，老first还是满足的）
 */

class Solution {

    public boolean increasingTriplet(int[] nums) {
        int first = nums[0];
        int second = Integer.MAX_VALUE;


        for (int i = 0; i < nums.length; i ++) {
            int current = nums[i];
            if (current > second) {
                return true;
            } else if (current > first) {
                second = current;
            } else {
                first = current;
            }

        }
        return false;
    }
}
