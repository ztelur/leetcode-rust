package again;


class Solution {
    /**
     * 正则表达式
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // 注意，也是一个矩阵，表示 s 的i位和 p 的 j 位是匹配的
        boolean[][] f = new boolean[m + 1][n + 1];
        // 两个空的是匹配的
        f[0][0] = true;
        // 双重进行for循环
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                // 根据 p 的最后一位如果是 *
                if (p.charAt(j - 1) == '*') {
                    // 因为可以是 零个，所以 f[i][j] = f[i][j - 2]
                    f[i][j] = f[i][j - 2];
                    // 判断 i 和 j-1 位置是否相等
                    if (matches(s, p, i, j - 1)) {
                        // 如果相等，则它还会依赖 f[i-1][j] 因为 * 是零个或者多个。
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    // 检查是否相等
                    if (matches(s, p, i, j)) {
                        // 相等，就是依赖 f[i-1][j-1]
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        // 如果是 . 则全部都返回true
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
