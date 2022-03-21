package again;

class Solution {
    public int numSquares(int n) {
        // 经典1维的数组
        int[] f = new int[n + 1];
        // 从1开始，到 n
        for (int i = 1; i <= n; i++) {
            //
            int minn = Integer.MAX_VALUE;
            // 对于1 到 j * j < i 。这些所有数据，我们可以知道 f[i] = f[i - j * j] + 1
            // 所以对应找到最小的即可。
            for (int j = 1; j * j <= i; j++) {
                //
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }
}
