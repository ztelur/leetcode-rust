/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2022 All Rights Reserved.
 */
package java;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 * [1,2,3] [1,2,3]
 * [1,3,4,5,7] => [3,4,5]
 *
 *
 *
 *
 * @author libing
 * @version $Id: p最长连续序列.java, v 0.1 2022年02月25日 下午3:34 zt Exp $
 */
class Solution {
    int maxLen = -1;
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        /**
         * 因为是不要求在原数组的位置，所以直接将其转换为set
         */
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        /**
         * 可以知道，里边一定是一段一段的，先找到每段的最小数，然后进行遍历，找出最长的距离
         */
        // 从 set 中进行遍历
        for (int num : set) {
            // 如果num-1 不存在,只能向上。这里只处理每段的最小值，也就是不存在比他小1的值
            // 1,2 4,5 7,8,9 这个数组，只处理 1 4 7
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum ++;
                    currentStreak ++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }

        }

        return longestStreak;
    }

    public boolean dfs(Set<Integer> set, int num) {
        if (!set.contains(num)) {
            return false;
        }



    }




}