package java;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/contains-duplicate/
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> numCount = new HashMap<>();
        for (int i =0; i < nums.length; i ++) {
            int itrVal = nums[i];
            Boolean flag = numCount.get(itrVal);
            if (flag == null) {
                numCount.put(itrVal, false);
            } else {
                return true;
            }
        }
        return false;
    }
}
