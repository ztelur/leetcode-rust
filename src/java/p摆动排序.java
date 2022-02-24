/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2022 All Rights Reserved.
 */
package java;

/**
 * 摆动排序
 *
 * @author libing
 * @version $Id: p摆动排序.java, v 0.1 2022年02月24日 下午5:27 zt Exp $
 *  给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 * []
 */
class Solution {

    // 因为只是要局部顺序，所以只要进行排序就行了。

    public void wiggleSort(int[] nums) {
        int length = nums.length;

        // 到达到 i 时，我们需要确保
        // - 当 i 是偶数时 a[i-1] > a[i]
        //   当 i 时基数时 a[i -1] < nums[i]
        // 所以我们只需要处理 i 和 i + 1 的关系
        // 当 i 时 偶数时 a[i] < a[i + 1]  如果此时满足，则继续向后，如果不满足，则出现了 a[i-1] > a[i] > a[i + 1] 的情况，所以只要替换 i 和 i + 1 即可
        // 当 i 是 基数时 a[i] > a[i + 1] 如果此时满足，则继续向后，如果不满足，则出现了 a[i - 1] < a[i] < a[i + 1] 的情况，则将 i 和 i + 1 替换即可

        // 唯一的问题时，会不会出现到最后一步，无法处理的情况，根据上边的规划，说明并不会

        for (int i =0; i < length; i ++) {
            int even = i % 2;

            // 是偶数
            if (even == 0) {
                // 需要进行下一个校验
                if (i + 1 < length) {
                    int val = nums[i + 1];
                    // 需要进行处理
                    if (val < nums[i]) {
                        nums[i + 1] = nums[i];
                        nums[i] = val;
                    }
                }
            } else {
                // 是基数
                if (i + 1 < length) {
                    int val = nums[i + 1];
                    if (val > nums[i]) {
                        nums[i + 1] = nums[i];
                        nums[i] = val;
                    }
                }
            }
        }
    }
}