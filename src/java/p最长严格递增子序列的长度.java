/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2022 All Rights Reserved.
 */
package java;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *
 *
 * 【10，7，9】
 * [10, 7, 9, ]
 *
 * 示例 1：
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 *
 * 暴力处理办法：
 * 暴力生成子序列，但是必须要每次加入时都大于当前一个节点。回溯方法
 *
 *
 * 动态规划
 *
 * F(i) 表示最大数组
 * F(i) = i(i) > max(i(1..i)) ? F(i-1) F(i-1) + 1
 *
 *
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 *
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 * 时间复杂度希望是nlogn
 *
 * @author libing
 * @version $Id: p最长严格递增子序列的长度.java, v 0.1 2022年02月25日 下午4:21 zt Exp $
 */
class Solution {

    int ans = 0;

    public int lengthOfLIS2(int[] nums) {
        // 使用动态规划的方法
        // 需要记录每个的长度和最大值
        int[][] dp = new int[nums.length + 1][2];

        dp[0] = new int[]{0,0};
        dp[1] = new int[]{1, nums[0]};

        for (int i = 1; i < nums.length; i ++) {
            int curr = nums[i];
            int len = -1;
            int max = -1;
            for (int j = 0; j <= i + 1; j ++) {
                // 可以和它构成严格递增
                if (curr > dp[j][1]) {
                    int clen = Math.max(len, dp[j][0] + 1);
                    if (clen > len) {
                        len = clen;
                        max = curr;
                    }
                } else {
                    // 取旧的中
                }
            }
        }

    }

    public int lengthOfLIS(int[] nums) {
        for (int i = 0; i < nums.length; i ++) {
            backtrack(nums, i, 0);
        }
        return ans;
    }

    public void backtrack(int[] nums, int index, int length) {
        for (int i = index + 1; i < nums.length; i++ ) {
            if (nums[i] > nums[index]) {
                length ++;
                ans  = length;
                backtrack(nums, i, length);
                length --;
            }
        }
    }
}