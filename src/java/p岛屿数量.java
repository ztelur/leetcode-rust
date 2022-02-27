package java;

/**
 * 岛屿数量
 *
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/x2p3cd/
 *
 */


class Solution {

    private int cols = 0;
    private int rows = 0;

    private int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        rows = grid.length;
        cols = grid[0].length;
        int islandsNum = 0;

        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                if (grid[i][j] == 1) {
                    islandsNum ++;
                    dfs(grid, i, j);
                }
            }
        }
        return islandsNum;
    }

    // 只要上下左右有陆地，就进行扩展
    private void dfs(char[][] grid, int row, int col) {
        // 代表来过，或者是水域
        if (grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '2';

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            boolean notBeyond =  newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols;
            if (notBeyond) {
                dfs(grid,newRow, newCol);
            }
        }
    }
}
