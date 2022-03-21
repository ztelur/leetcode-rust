package again;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 经典一维 dp
        int[] dp = new int[nums.length];
        // 0 就是自己
        dp[0] = 1;
        int maxans = 1;
        // 从 1 开始 到最后
        for (int i = 1; i < nums.length; i++) {
            // 首先自己是1
            dp[i] = 1;
            // 然后它的所有子串都可能和自己形成
            for (int j = 0; j < i; j++) {
                // 只要大于
                if (nums[i] > nums[j]) {
                    // dp[i], dp[j] + 1
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 中间进行最大值计算
            maxans = Math.max(maxans, dp[i]);
        }
        // 在这个过程中找到的最大值
        return maxans;
    }
}
