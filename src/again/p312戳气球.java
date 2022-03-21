package again;

import java.util.Arrays;

class Solution {
    public int[][] rec;
    public int[] val;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        val = new int[n + 2];
        // 左右各加一个边界，将数据copy进去。
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        // 两边的边界都为 1
        val[0] = val[n + 1] = 1;
        // 用于记忆化搜索。
        rec = new int[n + 2][n + 2];
        // 先全部都加入 -1
        for (int i = 0; i <= n + 1; i++) {
            Arrays.fill(rec[i], -1);
        }
        // 进行搜索
        return solve(0, n + 1);
    }

    public int solve(int left, int right) {
        // 如果第一种情况，这时因为都是开区间，所以返回0
        if (left >= right - 1) {
            return 0;
        }
        // 看看是否已经搜索过，搜索过直接返回
        if (rec[left][right] != -1) {
            return rec[left][right];
        }
        //
        for (int i = left + 1; i < right; i++) {
            // 选择任一个，计算 sum
            int sum = val[left] * val[i] * val[right];
            // 还要在累加左右的合。
            sum += solve(left, i) + solve(i, right);
            // 进行最大值求合
            rec[left][right] = Math.max(rec[left][right], sum);
        }
        // 最终返回 left 和 right
        return rec[left][right];
    }
}
