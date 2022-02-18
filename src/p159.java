/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2022 All Rights Reserved.
 */

/**
 * https://leetcode-cn.com/problems/majority-element/
 * @author libing
 * @version $Id: p159.java, v 0.1 2022年02月18日 下午12:02 zt Exp $
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 使用投票法
 * 记录一下当前的擂主
 */
class Solution {
    public int majorityElement(int[] nums) {
        int master = nums[0];
        int vote = 1;

        for (int i = 1; i < nums.length; i ++) {
            if (master != nums[i]) {
                if (vote == 0) {
                    master = nums[i];
                    vote = 1;
                } else {
                    vote --;
                }
            } else {
                vote ++;
            }
        }
        return master;
    }
}