package java;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/x2osfr/
 *
 * 带记忆功能的深度遍历
 *
 * 将矩阵看成一个有向图，每个单元格对应图中的一个节点，如果相邻的两个单元格的值不相等，则在相邻的两个单元格之间存在一条从较小值指向较大值的有向边。问题转化成在有向图中寻找最长路径。
 *
 * 深度优先搜索是非常直观的方法。从一个单元格开始进行深度优先搜索，即可找到从该单元格开始的最长递增路径。对每个单元格分别进行深度优先搜索之后，即可得到矩阵中的最长递增路径的长度。
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/solution/ju-zhen-zhong-de-zui-chang-di-zeng-lu-jing-by-le-2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

class Solution {
    public int[][] directions = new int[][] {{1,0},{-1,0},{0,1},{0,-1}}
    public int rows,cols;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        rows = matrix.length;
        cols = matrix[0].length;

        int[][] memo = new int[rows][cols];
        int ans = 0;
        // 标准的多入口 dfs 寻找最值
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }

        return ans;
    }

    private  int dfs(int[][] matrix,  int row, int col, int[][] memo) {
        if (memo[row][col] != 0) {
            return memo[row][col];
        }
        // 自身一定构成一个1
        memo[row][col] = 1;

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            // 确保不超过边界
            boolean beyondBorder = newRow > 0 && newRow < rows && newCol > 0 && newCol < cols;
            if (beyondBorder && matrix[newRow][newCol] > matrix[row][col]) {
                // 因为四个方向，所以要依次对比大小
                memo[row][col] = Math.max(memo[row][col], dfs(matrix, newRow, newCol, memo));
            }


        }

        return memo[row][col];
    }
}
