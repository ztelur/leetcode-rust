/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2022 All Rights Reserved.
 */
package java;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author libing
 * @version $Id: p计算右侧小于当前元素的个数.java, v 0.1 2022年02月24日 下午7:01 zt Exp $
 */
class Solution {
    /**
     * 使用线段树的能力和剑指offer中的反序是一样的思路
     *
     *
     * 只要求出每个位置上的元素比他小的元素
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        int[] indexNums = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            // 初始化，最开始索引数组的值就是下标值
            indexNums[i] = i;
            ans.add(0);
        }



    }

    // 进行归并排序
    public void mergeSort(int[] nums, int[] indexNums, int left, int right, int[] temp, List<Integer> ans) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(nums, indexNums, left, mid, temp, ans);
        mergeSort(nums, indexNums, mid + 1, right, temp, ans);


        if (nums[indexNums[mid]] < nums[indexNums[mid + 1]]) {
            return;
        }

        int l = mid;
        int r = right;
        int k = right;

        // 进行三分


    }

}