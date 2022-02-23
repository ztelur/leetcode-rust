/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2022 All Rights Reserved.
 */
package java;

import java.util.HashMap;
import java.util.Map;

/**
 * 四个数相加的和为 0
 * @author libing
 * @version $Id: pxx_四数相加2.java, v 0.1 2022年02月23日 下午3:38 zt Exp $
 *
 *
 * 思路，两个两个为一组，先计算两个的合，然后再两层for循环来查看匹配关系
 */
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < nums1.length; i ++) {
            for (int j = 0; j < nums2.length; j ++) {
                int sum = nums1[i] + nums2[j];
                countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
            }
        }


        // 然后再次遍历 3 4 数组
        int total = 0;
        for (int i = 0; i < nums3.length; i ++) {
            for (int j = 0; j < nums4.length; j ++) {
                int sum = nums3[i] + nums4[i];
                total += countMap.getOrDefault(-sum, 0);
            }
        }
        return total;
    }
}