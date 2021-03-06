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
        int count = gcd(k, len);
        for (int start = 0; start < count; start ++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % len;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;

            } while (current != start); // 回到原点
        }


    }
    public int gcd(int x, int y) {
        //
        return y > 0 ? gcd(y, x % y) : x;
    }

    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        // 取余数
        k = k % len;
        reverse(nums, 0, len-1);
        reverse(nums, 0, k-1);
        reverse(nums, k , len - 1);
    }

    void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[end];
            nums[end] = nums[start];
            nums[start] = tmp;
            start ++;
            end --;
        }
    }



}