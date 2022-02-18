/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2022 All Rights Reserved.
 */

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * @author libing
 * @version $Id: p152.java, v 0.1 2022年02月18日 下午12:01 zt Exp $
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个 32-位 整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 动态规划
 * [1,2,3,4,-1,6,-2]
 *
 * 因为是连续子数组，所以每增加一位，就有一个选择，是选择之前数组的结果，还是选择之前数组中连接到最后一位的最大的 * 自己。
 * [1] => 1
 * [1,2] =>   1 ? 1 * 2 => 结果是 2， 连接到最后一位最大的也是 2
 * [1,2，-1] =》 2 ? 2 * -1  最大是
 *
 * [2,3,-2,4]
 *
 *
 * max = 6
 * min = 3
 *
 * -2
 *
 * max = -2 ? -6 = -2
 * min = -2 ? -12 = -12
 *
 * [2,3,-2,4]
 * [48]
 * [6]
 */
class Solution {
    public int maxProduct(int[] nums) {

        int max = nums[0];
        int min = nums[0];
        int ret = nums[0];

        for (int i = 1; i < nums.length; i ++) {
            int c = nums[i];

            int sMax = max;
            int sMin = min;

            max = Math.max(c, Math.max(c * sMax, c * sMin));
            min = Math.min(c, Math.min(c * sMax, c * sMin));

            if (max > ret) {
                ret = max;
            }

        }
        return ret;
    }
}