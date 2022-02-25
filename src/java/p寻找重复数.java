/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2022 All Rights Reserved.
 */
package java;

/**
 * 寻找重复数
 *
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 *
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xabtn6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author libing
 * @version $Id: p寻找重复数.java, v 0.1 2022年02月24日 下午5:45 zt Exp $
 *
 * 使用二分法
 *
 *
 *
 */
class Solution {

    public int findDuplicate(int[] nums) {
        int length = nums.length;
        //
        int left = 1, right = length - 1, ans = -1;

        while (left < right) {
            int mid = (left + right) / 2;
            // 选择一个中间的数进行判断
            int cnt = 0;
            // 将 nums 遍历一遍，如果统计小于等于 mid 的数量
            for (int i = 0; i < length; i ++) {
                if (nums[i] <= mid) {
                    cnt ++;
                }
            }
            // 如果小于该数值，则说明并不是重复的，所以要继续向上
            if (cnt <= mid) {
                left = mid + 1;
            } else {
                // 需要找到一个最小的
                right = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}