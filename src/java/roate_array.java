/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2022 All Rights Reserved.
 */
package java;

/**
 * 旋转数组
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * @author libing
 * @version $Id: roate_array.java, v 0.1 2022年02月18日 下午3:10 zt Exp $
 *
 *
 * [1,2,3,4,5,] k = 2
 *  1,1 => 1,3 tmp = 3
 *  3,3 => 3,5 tmp = 5;
 *  5,5 => 5,2 tmp = 2;
 *
 */
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        // 取余数
        k = k % len;

        assert k < len;

        int tmp = nums[0];
        int curIndex = 0;
        int count = len;

        while (count > 0) {
            int nextIndex = curIndex + k;
            if (nextIndex >= len) {
                nextIndex = nextIndex - len;
            }
            int preTmp = tmp;
            tmp = nums[nextIndex];
            nums[nextIndex] = preTmp;

            count --;
            curIndex = nextIndex;
        }
    }
}