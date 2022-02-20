package java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * <p>
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 */

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> retList = new ArrayList<>();
        int i = 0;
        int j = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while (i < nums1.length && j < nums2.length) {
            int n1 = nums1[i];
            int n2 = nums2[j];
            if (n1 == n2) {
                retList.add(n1);
                do {
                    i++;
                } while (i < nums1.length && nums1[i] == n1);
                do {
                    j++;
                } while (j < nums2.length && nums2[j] == n2);
            } else if (n1 < n2) {
                i ++;
            } else {
                j ++;
            }
        }

        int[] retArray = new int[retList.size()];
        for (int k =0; k < retList.size(); k ++) {
            retArray[k] = retList.get(k);
        }
        return retArray;

    }
}