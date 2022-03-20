package again;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 */

public class Solution {
    // 双指针，根据分析
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            // 计算这两个指针下的面积
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            // 将指针下的那个进行位置移动
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }
}
