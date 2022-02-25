/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2022 All Rights Reserved.
 */
package java;

import java.util.Map;

/**
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 * @author libing
 * @version $Id: p至少k个重复数字的最大子串.java, v 0.1 2022年02月25日 下午2:27 zt Exp $
 *
 * 采用分而治之的方法
 * 少 k 次的num一定可以将s划分成不同的，然后在分别计算
 */
class Solution {
    public int longestSubstring(String s, int k) {
        return dfs(s, k, 0, s.length() - 1);
    }

    public int dfs(String s, int k, int left, int right) {
        int[] count = new int[26];

        // 计算每个字母出现的次数
        for (int i = left; i <= right; i ++) {
            count[s.charAt(i) - 'a'] += 1;
        }

        char split = 0;

        // 先找一个拆分点，找到了第一个
        for (int i = 0; i < 26; i ++) {
            if (count[i] > 0 && count[i] < k) {
                split = (char)('a' + i);
                break;
            }
        }

        // 说明所有字符出现的次数都大于k，所以直接返回字符串的长度-1，因为是最大子串
        if (split == 0) {
            return right - left + 1;
        }

        // 进行递归

        int i = left;
        int ret = 0;
        // 拿到 split 去拆分
        while (i <= right) {
            // 跳过等于的。因为这里要截取一段都没有小于k的数据
            while (i <= right && s.charAt(i) == split) {
                i ++;
            }
            // 如果已经到了边界，就跳过
            if (i > right) {
                break;
            }
            // 找到了一个段的开始
            int start = i;
            // 继续向下，如果一直不等于，则一直推进
            while (i <= right && s.charAt(i) != split) {
                i ++;
            }
            // 无论是 = 了 split 还是超出了范围，都要进行这段的计算

            int length = dfs(s, k, start, i - 1);

            ret = Math.max(length, ret);
        }
        return ret;
    }
}