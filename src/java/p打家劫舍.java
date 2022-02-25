/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2022 All Rights Reserved.
 */
package java;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * @author libing
 * @version $Id: p打家劫舍.java, v 0.1 2022年02月25日 下午3:52 zt Exp $
 *
 *
 * f[i] 对于 int[0,i] 的最大数据
 * f[i + 1] = f[i] or a[i+1] + f[i - 1];
 * 这就是动态规划的
 *
 */
class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        if (len  == 1) {
            return nums[0];
        }

        int first = 0;
        int second = nums[0];

        for (int i = 1; i < nums.length;i ++) {
            int third = Math.max(first + nums[i], second);
            first = second;
            second = third;
        }

        return second;
    }
}