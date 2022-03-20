package again;

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // 有一个字符串为空串
        if (n * m == 0) {
            return n + m;
        }

        // DP 数组，表示word 第i个字符和第 word2 第 j 个字符的最小修改路径。所以需要用到 n 和 m，所以需要将数组长度扩大
        int[][] D = new int[n + 1][m + 1];

        // 边界状况，
        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        // 都可以使用减法
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }

        // 计算所有 DP 值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // 可以是 A 添加一个字段
                int left = D[i - 1][j] + 1;
                // 可以是 B 删除第一个字段
                int down = D[i][j - 1] + 1;
                // 也可以是
                int left_down = D[i - 1][j - 1];
                // 如果末尾是不相等的。
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                // 三种场景的最小值
                D[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return D[n][m];
    }
}
