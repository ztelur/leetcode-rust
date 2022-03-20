package again;


/**
 * https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode-solution/
 */

public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        // 记录最右侧
        int rightmost = 0;
        // 从 0 开始，进行遍历
        for (int i = 0; i < n; ++i) {
            // 如果当前i 《 则说明可以达到
            if (i <= rightmost) {
                // 更新 right most
                rightmost = Math.max(rightmost, i + nums[i]);
                // 如果已经到了末尾，则结束
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
