/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2022 All Rights Reserved.
 */
package java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 最大树，将nums 合并成一个最大值的 string
 * 其实就是按照 int 的字符串排序一下即可
 * @author libing
 * @version $Id: p最大数.java, v 0.1 2022年02月24日 下午5:21 zt Exp $
 */
class Solution {
    public String largestNumber(int[] nums) {
        Integer[] arrayList = new Integer[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            arrayList[i] = nums[i];
        }

        Arrays.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                long sx = 10, sy = 10;
                while (sx <= a) {
                    sx *= 10;
                }

                while (sy <= b) {
                    sy *=10;
                }

                // 123   32
                // sx = 1000
                // sy = 100
                // 后边就是计算两个数字前后排列那个大。
                // 如果第一个大，则说明 b 需要排在 a 的前边
                // 如果后一个大，则说明 a 应该排在 b 的前边
                return (int) ((sx * b + a) - (sy * a + b));
            }
        });

        if (arrayList[0] == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int num : arrayList) {
            sb.append(num);
        }
        return sb.toString();
    }
}