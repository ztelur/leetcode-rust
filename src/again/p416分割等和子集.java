// 背包问题
//

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        // 小于2 不行
        if (n < 2) {
            return false;
        }

        int sum = 0, maxNum = 0;
        // 进行累加，并计算最大值
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        // 如果不能被2整除，则直接返回
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        // 如果最大值大于对半分，则返回
        if (maxNum > target) {
            return false;
        }
        // 表示是否能成功
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        // 对于 1 到 n
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            // 对于
            for (int j = target; j >= num; --j) {
                // dp[j] = dp[j][dp i - num]
                dp[j] |= dp[j - num];
            }
        }

        return dp[target];
    }
}