package again;

class Solution {
    public int numTrees(int n) {
        // 使用动态规划
        int[] G = new int[n + 1];
        // 初始值
        G[0] = 1;
        G[1] = 1;
        // 进行规划
        for (int i = 2; i <= n; ++i) {
            // 表示 j 作为 根节点，所以 j 只能从 1 开始
            for (int j = 1; j <= i; ++j) {
                /// 左右各自形成子树的数量想乘，等于以 j 为跟节点的字数的个数。
                // 然后进行累加。
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
