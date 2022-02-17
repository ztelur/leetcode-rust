/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2022 All Rights Reserved.
 */

/**
 * https://leetcode-cn.com/problems/word-search/
 * 单词搜索
 *
 * 回溯
 *
 * 参数不要使用不容易被发现的缩写。
 * @author libing
 * @version $Id: p79.java, v 0.1 2022年02月17日 下午6:46 zt Exp $
 */
class Solution {

    public boolean exist(char[][] board, String word) {
        int w = board.length, h = board[0].length;

        boolean[][] visited = new boolean[w][h];

        for (int i = 0; i < w; i ++) {
            for (int j = 0; j < h; j++) {
                boolean ret = check(board, visited, word, 0, i, j);
                if (ret) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, String word, int index, int i, int j) {

        if (index == word.length()) {
            return true;
        }

        if (i >= board.length || i < 0) {
            return false;
        }

        if (j >= board[0].length || j < 0) {
            return false;
        }

        // 访问过
        if (visited[i][j]) {
            return false;
        }


        char charInboard = board[i][j];
        char charInStr = word.charAt(index);

        if (charInboard != charInStr) {
            return false;
        }

        visited[i][j] = true;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int p = 0; p < 4; p ++) {
            int[] nextStep = directions[p];
            if (check(board, visited, word, index + 1, i + nextStep[0], j + nextStep[1])) {
                return true;
            }
        }

        visited[i][j] = false;

        return false;
    }
}