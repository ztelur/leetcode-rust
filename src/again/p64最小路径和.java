package again;

class Solution {
    public int minPathSum(int[][] grid) {
        // 使用动态规划
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        // 得出 row 和 col
        int rows = grid.length, columns = grid[0].length;
        // 需要一个二维的dp数组，表示是到达该位置的最小路径
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        // 第一 column 是可以计算的，只有一条路
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // 第一 row 也是可以计算的，只有一条路
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                // 因为达到一个点就只有两条路，所以它的最小路径就是这两条路中最小的 + 当前的节点
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][columns - 1];
    }
}
