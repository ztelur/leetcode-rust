package java;

/**
 * 连续子数组的最大合
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */


class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            /// 第
            //i
            //i 个数结尾的「连续子数组的最大和」
            // 所以才推导出这个，要么是自己，要么是前边的最大合 + 自己。
            // 这个是需要注意点的。
            // 将动态规划的 f(i) 的含义进行了转换
            // 最终结果是 max(f(i)) 并不是 f(imax)
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
