/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2022 All Rights Reserved.
 */
package java;

import java.util.Random;

/**
 * 寻找一个数组中的任何一个峰值
 * 也就是说绝对大于两侧数据的值
 * @author libing
 * @version $Id: p寻找峰值.java, v 0.1 2022年02月24日 下午4:26 zt Exp $
 *
 *
 * 方法一，找到该数组的最大值，它一定是一个峰值
 *
 * 方法二、逐步递增法，不断想上找大于的数据，只有要另外一侧有一个小于它的就对了
 *
 * 方法三、用二分法进行排查？
 *
 * https://leetcode-cn.com/problems/wiggle-sort/submissions/
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xaygd7/ 两个摆动排序的区别？？？？
 *
 * https://leetcode-cn.com/problems/wiggle-sort-ii/solution/yi-bu-yi-bu-jiang-shi-jian-fu-za-du-cong-onlognjia/
 *
 *
 */
class Solution {



    public int findPeakElement2(int[] nums) {
        int length = nums.length;

        int idx = (int) Math.random() * length;

        ///     1 2 3 4


        while (!(compare(nums, idx -1, idx) <0 && compare(nums, idx, idx + 1) > 0)) {

            if (compare(nums, idx, idx + 1) < 0) {
                idx +=1;
            } else {
                idx -= 1;
            }
        }

        return idx;
    }


    public int findPeakElement(int[] nums) {

        int length = nums.length;

        int left =0, right = length - 1, ans = -1;

        while (left <= right) {

            int mid = (left + right) / 2;
            // [mid] > [mid -1]  && [mid] > [mid + 1]
            if (compare(nums, mid - 1, mid) < 0 && compare(nums, mid, mid +1) > 0) {
                ans = mid;
                break;
            }
            // 为什么这里可以进行二分呢？

            /**
             * 首先要有一个前提是，一定是存在峰值的
             *
             * 如果 [mid] < [mid + 1]
             * 我们可以发现，如果
             * nums
             * [
             * i
             * ]
             * <
             * nums
             * [
             * i
             * +
             * 1
             * ]
             * nums[i]<nums[i+1]，并且我们从位置
             * i
             * i 向右走到了位置
             * i
             * +
             * 1
             * i+1，那么位置
             * i
             * i 左侧的所有位置是不可能在后续的迭代中走到的。
             */

            // [mid] < [mid + 1]
            if (compare(nums, mid, mid + 1) < 0) {
                left = mid +1;
            } else {
                right = mid - 1;
            }

        }

        return ans;
    }

    // 辅助的函数，用于处理边界情况
    public int[] get(int[] nums, int idx) {
        if (idx == -1 || idx == nums.length) {
            return new int[] {0, 0};
        }
        return new int[] {1, nums[idx]};
    }

    public int compare(int[] nums, int idx1, int idx2) {
        int[] nums1 = get(nums, idx1);
        int[] nums2 = get(nums, idx2);

        // 有一个已经超出了边界
        if (nums1[0] != nums2[0]) {
            return nums1[0] > nums2[0] ? 1 : -1;
        }

        if (nums1[1] == nums2[1]) {
            return 0;
        }

        return nums1[1] > nums2[1] ? 1: -1;
    }
}