package again;

class Solution {

    // 典型的 dp[i][j] 在过程中进行不断对比，求最值的题目
    //

    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        // 边界场景
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        // rows cols
        int rows = matrix.length, columns = matrix[0].length;
        // 生成对应的 dp[][] 分别代表 i j 为右下角的最大正方形
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // 双层遍历
                // 只有在1 时进行处理 0 时不符合条件
                if (matrix[i][j] == '1') {
                    // 如果是边界，则都是 1，仅自己可能成为，并且处理了异常流程
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // 三者最小的。
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    // 统计最大值
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        // 计算最后的数值
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }
}
