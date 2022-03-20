package again;

class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i ++) {
            dp[i] = 1;
        }

        int tmp = 0;
        for (int i = 1; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (j == 0) {
                    dp[j] = dp[1];
                } else {
                    dp[j] = dp[j - 1] + dp[j];
                }
            }
        }
        return dp[n];
    }
}
