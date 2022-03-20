package again;

class Solution {
    public boolean exist(char[][] board, String word) {
        //
        int h = board.length, w = board[0].length;
        // 记录哪些访问过了
        boolean[][] visited = new boolean[h][w];

        // 从任何一个地方开始入手
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                // 如果有则直接返回成功
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        // 查看当前是否相等
        if (board[i][j] != s.charAt(k)) {
            // 如果不相等，则返回 false
            return false;
        } else if (k == s.length() - 1) {
            // 到了最后一个位置，则返回true
            return true;
        }
        // 设置当前位置已经访问
        visited[i][j] = true;
        // 四个方向
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            // 从四个方向，
            int newi = i + dir[0], newj = j + dir[1];
            // 判断是否越界
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                // 那个位置还必须是没有访问
                if (!visited[newi][newj]) {
                    // 继续检查。
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}
