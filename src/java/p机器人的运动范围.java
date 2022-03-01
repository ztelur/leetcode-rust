package java;

/**
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/ji-qi-ren-de-yun-dong-fan-wei-by-leetcode-solution/
 */

class Solution {
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            // 只有 0 0 这一个
            return 1;
        }

        boolean[][] vis = new boolean[m][n];
        int ans = 1;
        vis[0][0] = true;

        for (int i =0; i < m; i ++) {
            for (int j =0; j < n; j ++) {
                // 如果横轴坐标的位和超过了
                if ((i == 0 && j ==0) || get(i) + get(j) > k) {
                    continue;
                }

                // 自身可以通过了，但是还要再看是否有节点连接到这里
                // 查看i - 1 和  j - 1 是否是联通的
                if (i -1 >= 0) {
                    vis[i][j] |= vis[i-1][j];
                }
                if (j - 1 >= 0 ) {
                    vis[i][j] |= vis[i][j-1];
                }
                // 根据自身是否遍历通过
                ans += vis[i][j] ? 1 : 0;

            }
        }
        return ans;

    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x = x / 10;
        }
        return res;
    }
}
